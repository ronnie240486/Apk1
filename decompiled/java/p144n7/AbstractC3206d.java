package p144n7;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import p125l7.AbstractC3006m;
import p154o7.AbstractC3275p;
import p154o7.C3266g;
import p154o7.C3272m;
import p212t7.C3813b;

public abstract class AbstractC3206d {

    public static final Type[] f10780a = new Type[0];

    public static void m6485a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: ".concat(cls.getName()));
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: ".concat(cls.getName()));
        }
    }

    public static Type m6486b(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new C3203a(m6486b(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C3204b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new C3203a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new C3205c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static void m6487c(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException();
        }
    }

    public static void m6488d(Type type) {
        m6487c(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    public static boolean m6489e(Type type, Type type2) {
        return type == type2 || (type != null && type.equals(type2));
    }

    public static boolean m6490f(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return m6489e(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m6490f(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static Type m6491g(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i6 = 0; i6 < length; i6++) {
                Class<?> cls3 = interfaces[i6];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i6];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return m6491g(cls.getGenericInterfaces()[i6], interfaces[i6], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return m6491g(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Class m6492h(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            m6487c(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance((Class<?>) m6492h(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return m6492h(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static Type m6493j(Type type, Class cls, Type type2, HashMap map) {
        Type[] lowerBounds;
        Type[] upperBounds;
        Type typeM6493j;
        Type[] upperBounds2;
        Type typeM6493j2;
        Type[] lowerBounds2;
        Type typeM6493j3;
        boolean z7;
        Type[] actualTypeArguments;
        int length;
        Type c3204b;
        Type typeM6493j4;
        Type genericComponentType;
        Type typeM6493j5;
        TypeVariable typeVariable;
        TypeVariable typeVariable2 = null;
        do {
            if (!(type2 instanceof TypeVariable)) {
                if (!(type2 instanceof Class)) {
                    if (type2 instanceof GenericArrayType) {
                        if (type2 instanceof ParameterizedType) {
                            if (type2 instanceof WildcardType) {
                                break;
                            }
                            type2 = (WildcardType) type2;
                            lowerBounds = type2.getLowerBounds();
                            upperBounds = type2.getUpperBounds();
                            if (lowerBounds.length == 1) {
                                if (upperBounds.length == 1) {
                                    break;
                                }
                                typeM6493j = m6493j(type, cls, upperBounds[0], map);
                                if (typeM6493j != upperBounds[0]) {
                                    break;
                                }
                                if (typeM6493j instanceof WildcardType) {
                                    upperBounds2 = ((WildcardType) typeM6493j).getUpperBounds();
                                } else {
                                    upperBounds2 = new Type[]{typeM6493j};
                                }
                                type2 = new C3205c(upperBounds2, f10780a);
                                break;
                            }
                            typeM6493j2 = m6493j(type, cls, lowerBounds[0], map);
                            if (typeM6493j2 != lowerBounds[0]) {
                                break;
                            }
                            if (typeM6493j2 instanceof WildcardType) {
                                lowerBounds2 = ((WildcardType) typeM6493j2).getLowerBounds();
                            } else {
                                lowerBounds2 = new Type[]{typeM6493j2};
                            }
                            type2 = new C3205c(new Type[]{Object.class}, lowerBounds2);
                            break;
                        }
                        type2 = (ParameterizedType) type2;
                        Type ownerType = type2.getOwnerType();
                        typeM6493j3 = m6493j(type, cls, ownerType, map);
                        z7 = !m6489e(typeM6493j3, ownerType);
                        actualTypeArguments = type2.getActualTypeArguments();
                        length = actualTypeArguments.length;
                        for (int i6 = 0; i6 < length; i6++) {
                            typeM6493j4 = m6493j(type, cls, actualTypeArguments[i6], map);
                            if (m6489e(typeM6493j4, actualTypeArguments[i6])) {
                                if (!z7) {
                                    actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                    z7 = true;
                                }
                                actualTypeArguments[i6] = typeM6493j4;
                            }
                        }
                        if (z7) {
                            break;
                        }
                        c3204b = new C3204b(typeM6493j3, type2.getRawType(), actualTypeArguments);
                        type2 = c3204b;
                        break;
                    }
                    type2 = (GenericArrayType) type2;
                    genericComponentType = type2.getGenericComponentType();
                    typeM6493j5 = m6493j(type, cls, genericComponentType, map);
                    if (m6489e(genericComponentType, typeM6493j5)) {
                        c3204b = new C3203a(typeM6493j5);
                        type2 = c3204b;
                        break;
                    }
                    break;
                }
                Class cls2 = (Class) type2;
                if (!cls2.isArray()) {
                    if (type2 instanceof GenericArrayType) {
                        if (type2 instanceof ParameterizedType) {
                            if (type2 instanceof WildcardType) {
                                break;
                            }
                            type2 = (WildcardType) type2;
                            lowerBounds = type2.getLowerBounds();
                            upperBounds = type2.getUpperBounds();
                            if (lowerBounds.length == 1) {
                                if (upperBounds.length == 1) {
                                    break;
                                }
                                typeM6493j = m6493j(type, cls, upperBounds[0], map);
                                if (typeM6493j != upperBounds[0]) {
                                    break;
                                }
                                if (typeM6493j instanceof WildcardType) {
                                    upperBounds2 = ((WildcardType) typeM6493j).getUpperBounds();
                                } else {
                                    upperBounds2 = new Type[]{typeM6493j};
                                }
                                type2 = new C3205c(upperBounds2, f10780a);
                                break;
                            }
                            typeM6493j2 = m6493j(type, cls, lowerBounds[0], map);
                            if (typeM6493j2 != lowerBounds[0]) {
                                break;
                            }
                            if (typeM6493j2 instanceof WildcardType) {
                                lowerBounds2 = ((WildcardType) typeM6493j2).getLowerBounds();
                            } else {
                                lowerBounds2 = new Type[]{typeM6493j2};
                            }
                            type2 = new C3205c(new Type[]{Object.class}, lowerBounds2);
                            break;
                        }
                        type2 = (ParameterizedType) type2;
                        Type ownerType2 = type2.getOwnerType();
                        typeM6493j3 = m6493j(type, cls, ownerType2, map);
                        z7 = !m6489e(typeM6493j3, ownerType2);
                        actualTypeArguments = type2.getActualTypeArguments();
                        length = actualTypeArguments.length;
                        while (i6 < length) {
                            typeM6493j4 = m6493j(type, cls, actualTypeArguments[i6], map);
                            if (m6489e(typeM6493j4, actualTypeArguments[i6])) {
                                if (!z7) {
                                    actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                    z7 = true;
                                }
                                actualTypeArguments[i6] = typeM6493j4;
                            }
                        }
                        if (z7) {
                            break;
                        }
                        c3204b = new C3204b(typeM6493j3, type2.getRawType(), actualTypeArguments);
                        type2 = c3204b;
                        break;
                    }
                    type2 = (GenericArrayType) type2;
                    genericComponentType = type2.getGenericComponentType();
                    typeM6493j5 = m6493j(type, cls, genericComponentType, map);
                    if (m6489e(genericComponentType, typeM6493j5)) {
                        break;
                    }
                    c3204b = new C3203a(typeM6493j5);
                    type2 = c3204b;
                    break;
                }
                Class<?> componentType = cls2.getComponentType();
                Type typeM6493j6 = m6493j(type, cls, componentType, map);
                if (!m6489e(componentType, typeM6493j6)) {
                    c3204b = new C3203a(typeM6493j6);
                    type2 = c3204b;
                    break;
                }
                type2 = cls2;
                break;
            }
            typeVariable = (TypeVariable) type2;
            Type type3 = (Type) map.get(typeVariable);
            if (type3 != null) {
                return type3 == Void.TYPE ? type2 : type3;
            }
            map.put(typeVariable, Void.TYPE);
            if (typeVariable2 == null) {
                typeVariable2 = typeVariable;
            }
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            Class cls3 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls3 == null) {
                type2 = typeVariable;
            } else {
                Type typeM6491g = m6491g(type, cls, cls3);
                if (typeM6491g instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls3.getTypeParameters();
                    int length2 = typeParameters.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length2) {
                            throw new NoSuchElementException();
                        }
                        if (typeVariable.equals(typeParameters[i10])) {
                            type2 = ((ParameterizedType) typeM6491g).getActualTypeArguments()[i10];
                            break;
                        }
                        i10++;
                    }
                } else {
                    type2 = typeVariable;
                }
            }
        } while (type2 != typeVariable);
        if (typeVariable2 != null) {
            map.put(typeVariable2, type2);
        }
        return type2;
    }

    public static String m6494k(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static void m6495l(AbstractC3006m abstractC3006m, C3813b c3813b) {
        C3272m c3272m = AbstractC3275p.f10938a;
        C3266g.m6561d(abstractC3006m, c3813b);
    }

    public abstract Object mo6496i(Class cls);
}
