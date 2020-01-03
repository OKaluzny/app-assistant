package com.kaluzny.assistant.api.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.*;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Utility class intended for getting diff from DTOs.
 *
 * @author Oleg Kaluzny
 */
@Slf4j
@UtilityClass
public class DiffBuilderUtils {

    private static final String DELIMITER_WITH_EQUAL_SIGN = " = ";
    private static final String DELIMITER_WITH_CONSEQUENT_SIGN = " → ";
    private static final String DIFF_DELIMITER = "; ";

    public static <T> DiffResult createBuilder(T left, T right) {
        Class<T> tClass = (Class<T>) left.getClass();
        DiffBuilder builder = new DiffBuilder(left, right, ToStringStyle.DEFAULT_STYLE);
        Arrays.stream(tClass.getDeclaredFields())
                .forEach(field -> {
                    try {
                        Object leftFieldValue = FieldUtils.readField(field, left, true);
                        Object rightFieldValue = FieldUtils.readField(field, right, true);
                        append(builder, field.getName(), leftFieldValue, rightFieldValue);
                    } catch (IllegalAccessException e) {
                        log.error("Can't get difference between {} field from {} class", field, tClass.getName(), e);
                    }
                });
        return builder.build();
    }

    private void append(DiffBuilder builder, String fieldName, Object leftFieldValue, Object rightFieldValue) {
        if (leftFieldValue instanceof Diffable && rightFieldValue instanceof Diffable) {
            builder.append(fieldName, ((Diffable) leftFieldValue).diff(rightFieldValue));
        } else if (leftFieldValue instanceof List && rightFieldValue instanceof List) {
            List leftList = (List) leftFieldValue;
            List rightList = (List) rightFieldValue;
            appendDiffsBetweenLists(builder, fieldName, leftList, rightList);
        } else if (leftFieldValue instanceof Date && rightFieldValue instanceof Date) {
            Date leftDate = (Date) leftFieldValue;
            Date rightDate = (Date) rightFieldValue;
            builder.append(fieldName, new Date(leftDate.getTime()), new Date(rightDate.getTime()));
        } else {
            builder.append(fieldName, leftFieldValue, rightFieldValue);
        }
    }

    public String convertToString(DiffResult diffResult) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Diff<?>> iterator = diffResult.iterator();
        while (iterator.hasNext()) {
            Diff<?> diff = iterator.next();
            stringBuilder.append(diff.getFieldName())
                    .append(DELIMITER_WITH_EQUAL_SIGN)
                    .append(diff.getLeft())
                    .append(DELIMITER_WITH_CONSEQUENT_SIGN)
                    .append(diff.getRight());
            if (iterator.hasNext()) {
                stringBuilder.append(DIFF_DELIMITER);
            }
        }
        return stringBuilder.toString();
    }

    private void appendDiffsBetweenLists(DiffBuilder builder, String fieldName, List leftList, List rightList) {
        int size = Math.min(leftList.size(), rightList.size());
        IntStream.range(0, size).forEach(i -> appendDiffsBetweenItems(builder, fieldName, i, leftList.get(i), rightList.get(i)));
        IntStream.range(size, leftList.size()).forEach(i -> appendDiffsBetweenItems(builder, fieldName, i, leftList.get(i), null));
        IntStream.range(size, rightList.size()).forEach(i -> appendDiffsBetweenItems(builder, fieldName, i, null, rightList.get(i)));
    }

    private void appendDiffsBetweenItems(DiffBuilder builder, String fieldName, int index, Object leftItem, Object rightItem) {
        append(builder, String.format("%s(%d)", fieldName, index), leftItem, rightItem);
    }
}
