package com.kaluzny.assistant.app.utils.converter;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * PageRequest parameters resolver.
 *
 * @author Oleg Kaluzny
 */
public class PageRequestArgumentResolver implements HandlerMethodArgumentResolver {

    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_COUNT = 20;

    private static final String PAGE_PARAM_NAME = "page";
    private static final String COUNT_PARAM_NAME = "count";
    private static final String SORT_PARAM_NAME = "sort";
    private static final Sort.Order DEFAULT_ORDER = new Sort.Order(Sort.Direction.DESC, "id");

    /**
     * Method checks whether the parameters are supported.
     *
     * @param parameter method parameter.
     * @return check results.
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Objects.equals(parameter.getParameterType(), PageRequest.class);
    }

    /**
     * Resolve arguments.
     *
     * @param parameter     method parameter.
     * @param mavContainer  model and view container.
     * @param webRequest    native web request.
     * @param binderFactory A factory for creating a {@link WebDataBinder} instance.
     * @return page request {@link PageRequest}.
     */
    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {

        int page = getIntegerParameter(webRequest, PAGE_PARAM_NAME, DEFAULT_PAGE);
        if (page < DEFAULT_PAGE) {
            throw new IllegalArgumentException(String.format("Illegal page number %d", page));
        }
        page = page - DEFAULT_PAGE;

        List<Sort.Order> orders = new ArrayList<>();
        String[] sortParams = webRequest.getParameterValues(SORT_PARAM_NAME);
        if (sortParams != null) {
            orders.addAll(Arrays.stream(sortParams)
                    .map(this::createOrder)
                    .collect(Collectors.toList()));
        } else {
            orders.add(DEFAULT_ORDER);
        }

        int count = getIntegerParameter(webRequest, COUNT_PARAM_NAME, DEFAULT_COUNT);
        return PageRequest.of(page, count, Sort.by(orders));
    }

    private int getIntegerParameter(NativeWebRequest webRequest, String name, int defaultValue) {
        try {
            return Optional.ofNullable(webRequest.getParameter(name))
                    .map(Integer::parseInt)
                    .orElse(defaultValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("Parameter %s must be a number", name), e);
        }
    }

    private Sort.Order createOrder(String parameter) {
        String[] orderSplit = parameter.split(",");
        String fieldName = orderSplit[0];

        if ("status.label".equals(fieldName)) {
            fieldName = "status.base";
        }
        if ("status.extendedLabel".equals(fieldName)) {
            fieldName = "status.extended";
        }

        String direction = orderSplit[1];
        return new Sort.Order(Sort.Direction.fromString(direction), fieldName);
    }
}
