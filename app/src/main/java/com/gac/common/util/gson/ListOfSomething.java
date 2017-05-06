package com.gac.common.util.gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * GsonUtil depend
 *
 * @see <a href="http://stackoverflow.com/questions/14139437/java-type-generic-as-argument-for-gson">java-type-generic-as-argument-for-gson</a>
 * Created by spencer on 5/6/17.
 */
class ListOfSomething<X> implements ParameterizedType {

    private Class<?> wrapped;

    public ListOfSomething(Class<X> wrapped) {
        this.wrapped = wrapped;
    }

    public Type[] getActualTypeArguments() {
        return new Type[]{wrapped};
    }

    public Type getRawType() {
        return List.class;
    }

    public Type getOwnerType() {
        return null;
    }

}