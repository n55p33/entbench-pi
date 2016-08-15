package org.apache.batik.bridge;
public class SVGFeCompositeElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeCompositeElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_COMPOSITE_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.CompositeRule rule =
          convertOperator(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        org.apache.batik.ext.awt.image.renderable.Filter in2 =
          getIn2(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in2 ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion;
        defaultRegion =
          (java.awt.geom.Rectangle2D)
            in.
            getBounds2D(
              ).
            clone(
              );
        defaultRegion.
          add(
            in2.
              getBounds2D(
                ));
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        java.util.List srcs =
          new java.util.ArrayList(
          2);
        srcs.
          add(
            in2);
        srcs.
          add(
            in);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit(
          srcs,
          rule,
          true);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.CompositeRule convertOperator(org.w3c.dom.Element filterElement,
                                                                                  org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_OPERATOR_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_ATOP_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     ATOP;
        }
        if (SVG_IN_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     IN;
        }
        if (SVG_OVER_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_OUT_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OUT;
        }
        if (SVG_XOR_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     XOR;
        }
        if (SVG_ARITHMETIC_VALUE.
              equals(
                s)) {
            float k1 =
              convertNumber(
                filterElement,
                SVG_K1_ATTRIBUTE,
                0,
                ctx);
            float k2 =
              convertNumber(
                filterElement,
                SVG_K2_ATTRIBUTE,
                0,
                ctx);
            float k3 =
              convertNumber(
                filterElement,
                SVG_K3_ATTRIBUTE,
                0,
                ctx);
            float k4 =
              convertNumber(
                filterElement,
                SVG_K4_ATTRIBUTE,
                0,
                ctx);
            return org.apache.batik.ext.awt.image.CompositeRule.
              ARITHMETIC(
                k1,
                k2,
                k3,
                k4);
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_OPERATOR_ATTRIBUTE,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ya2wU1xW+XuP324B5GzAGyiO7EKANNXkYY4PJ+lGbWKp5" +
       "LHdn764Hz84MM3ftxTQJiVKFtipBlCS0EpZaOYW2NERVozbNQ64i5aGklUhR" +
       "0zQKRUp/JG1RgqKmP+jrnDszO7Ozu0a0TS3N3fG95557zznf/c65c+EaKTEN" +
       "0sxUHuRHdGYGO1XeTw2TxToUapp7oC8iPVlMPznwQe/WACkdJrUj1OyRqMm6" +
       "ZKbEzGGyRFZNTlWJmb2MxXBGv8FMZoxRLmvqMJkrm91JXZElmfdoMYYCQ9QI" +
       "kwbKuSFHU5x12wo4WRKGnYTETkLt/uG2MKmWNP2IKz7fI97hGUHJpLuWyUl9" +
       "+BAdo6EUl5VQWDZ5W9og63RNOZJQNB5kaR48pGyxXbA7vCXHBS3P1H164+RI" +
       "vXDBbKqqGhfmmQPM1JQxFguTOre3U2FJ8zB5gBSHSZVHmJPWsLNoCBYNwaKO" +
       "ta4U7L6GqalkhybM4Y6mUl3CDXGyPFuJTg2atNX0iz2DhnJu2y4mg7XLMtZa" +
       "VuaY+Pi60OknD9T/pJjUDZM6WR3E7UiwCQ6LDINDWTLKDLM9FmOxYdKgQrAH" +
       "mSFTRZ6wI91oygmV8hSE33ELdqZ0Zog1XV9BHME2IyVxzciYFxeAsv8riSs0" +
       "AbY2ubZaFnZhPxhYKcPGjDgF3NlTZo3KaoyTpf4ZGRtb7wUBmFqWZHxEyyw1" +
       "S6XQQRotiChUTYQGAXpqAkRLNACgwcnCgkrR1zqVRmmCRRCRPrl+awikKoQj" +
       "cAonc/1iQhNEaaEvSp74XOvdduKouksNkCLYc4xJCu6/CiY1+yYNsDgzGJwD" +
       "a2L12vATtOnF4wFCQHiuT9iS+dlXrt+zvnn6NUtmUR6ZvughJvGINBWtvbS4" +
       "Y83WYtxGua6ZMgY/y3Jxyvrtkba0DgzTlNGIg0FncHrglS8f+yH7c4BUdpNS" +
       "SVNSScBRg6QldVlhxk6mMoNyFusmFUyNdYjxblIG72FZZVZvXzxuMt5NZimi" +
       "q1QT/4OL4qACXVQJ77Ia15x3nfIR8Z7WCSFl8JBqeD5HrD/xy0k8NKIlWYhK" +
       "VJVVLdRvaGi/GQLGiYJvR0JRQP1oyNRSBkAwpBmJEAUcjDB7IGrIsQQLDQ7t" +
       "7GIdYA9azJAYQMF2MRZEvOn/t5XSaPPs8aIiCMdiPxkocI52aUqMGRHpdGp7" +
       "5/WnI29YQMPDYXuLk02weNBaPCgWD1qLB2dYnBQViTXn4Cas8EPwRoEGgIer" +
       "1wzu333weEsx4E4fnwWeR9GWrHzU4XKFQ/AR6WJjzcTyKxtfDpBZYdJIJZ6i" +
       "CqaXdiMBxCWN2me7OgqZyk0YyzwJAzOdoUksBnxVKHHYWsq1MWZgPydzPBqc" +
       "dIYHN1Q4meTdP5k+M/7Q0IMbAiSQnSNwyRKgN5zej8yeYfBWPzfk01v36Aef" +
       "Xnzifs1liayk4+TKnJloQ4sfFX73RKS1y+izkRfvbxVurwAW5xROHRBks3+N" +
       "LBJqcwgdbSkHg+OakaQKDjk+ruQjhjbu9gi4Noj3OQCLKjyVq+AJ2cdU/OJo" +
       "k47tPAveiDOfFSJh3Dmon/3drz/cJNzt5JY6T1EwyHibh89QWaNgrgYXtnsM" +
       "xkDuvTP933r82qN7BWZBYkW+BVuxxQMBIQQ3f/W1w+/84crU5YCLcw4JPRWF" +
       "uiidMRL7SeUMRsJqq9z9AB8qwBSImtb7VMCnHJdpVGF4sP5et3Ljs385UW/h" +
       "QIEeB0brb67A7V+wnRx748DfmoWaIgnzseszV8wi+dmu5nbDoEdwH+mH3lry" +
       "7VfpWUgXQNGmPMEE6xLhAyKCtkXYv0G0m31jX8BmpekFf/b58tRNEenk5Y9r" +
       "hj5+6brYbXbh5Y11D9XbLHhhsyoN6uf5yWkXNUdAbvN07756ZfoGaBwGjRIQ" +
       "sNlnAE2ms5BhS5eU/f6XLzcdvFRMAl2kUtForIuKQ0YqAN3MHAGGTet332MF" +
       "d7wcmnphKskxPqcDHbw0f+g6kzoXzp74+byfbjs3eUWgTLd0LPIqXI3Nugze" +
       "xF+pP/d58ZalwSBLCpUnorSaevj0ZKzvqY1WEdGYnfI7oaL98W//8WbwzNXX" +
       "82SWCq7ptylsjCmeNYtxyaxc0CMqN5eP3qs99f5zrYntt5IGsK/5JkSP/y8F" +
       "I9YWpnX/Vl59+E8L99w1cvAWGH2pz51+lT/oufD6zlXSqYAoUy0yzylvsye1" +
       "eR0LixoM6nEVzcSeGgH7FRkANGJgm+HZbANgc35WzYOdDFcVmjrDqd4zw9gQ" +
       "Nn2cVCegiNMkqvSCNUJyPlzjxAHAEj1olehi4A5s+i2Et/2Hpws72nXRf2+u" +
       "e3bbNu6+dfcUmupzQZnYSJlj6MpChZZVU9m3Mkd6NkqPb5KCMS0ZtIsvHIo7" +
       "Astz1CXGeHCnQfURWTJ7AfCO5IYcSQQ+HedBOQn3mCCkdGA/TBLBLlmBu5Ez" +
       "cYEIDQomGOxiAMgJwqSw23dkH2I8nYOpqMkH6Ligj4i0b3V9U+vWT1os3mjO" +
       "I+u5Bp14/hfDw6vrJUu4JZ/i7OvP+XPl0rvJV/5oTViQZ4IlN/d86JtDbx96" +
       "U5zfciSMzKnxkAUQi6c+qc/EuxbD2wDPVTve4peTff9lcQ/T4G4vJwHroT1y" +
       "ksXs8DqXh89Uv8iMWfzrBu1Ho0r7R3d8/07LrcsL8KQr/9yXrl46O3HxgsX9" +
       "6F5O1hX6GpL7CQbr05Uz1NguQP6684vTH74/tD9gE0otNmbawWmNm0MhY2Pn" +
       "0cwhLMrcQOZkw8TSvONrdS+cbCzugmTTTcpTqnw4xbpj2YRbZqaiHty4l36X" +
       "fm3Q/Av+iuD5Jz4IFuywQNPYYV+Al2VuwJDOcZyTorXwKvRIM7DoI9gcABaV" +
       "DAbTraOKfYdcxox8Boy5Asduh+cx+xg8NgNjinYtNrcJpQEoA3RD4wBgFoPy" +
       "2BRfoHzl8ZwZlPscErC0CibEJiYWPzWD205j83WoFuFmA5UA79OZKN8d8Ky/" +
       "CTtmbsADKYW5nv7G/8LTaU4WzXDNxvpwfs43Puu7lPT0ZF35vMn73hZlUubb" +
       "UTXwXDylKB74eqFcqhssLgu/VFvlsi5+JjmZVyA9QdCsF2HEWUv+u5C3/fKc" +
       "lIhfr9wUJ5WuHKiyXrwi5zgpBhF8Pa87Qbm7UK5sB243oCZEr4kD0G8A0XF5" +
       "LNtz6aLcQlmEbe7NwuapjFdkcZP4JOvwR6rfpsCLk7t7j17//FPWJVRS6MQE" +
       "aqkC1rDuw5nCcHlBbY6u0l1rbtQ+U7HSYbkGa8Pu6VrkgXU7kJqOAFnou6GZ" +
       "rZmL2jtT21761fHSt4Cf95IiCkXFXs8HUevrH1zzUpDM94Zz2RGKaHF1bFvz" +
       "nSN3rY9/9K64g9hsuriwfES6fG7/b07Nn4IrZlU3KYFrBEsPk0rZ3HFEhSJi" +
       "zBgmNbLZmYYtghaZKlnUW4tYplgJCr/Y7qzJ9OInDE5acr7K5vnwA/e1cWZs" +
       "11JqzCbvKrcn61uxU1undN03we3xFAkPYHMsbVF7cSTco+sO1Zd8Txen+0F/" +
       "ChKdYvbz4hWbF/4N6Fvhl64ZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+zrVn33/bX33vb2cW9baEuBPm8ZbdjPedhxQmGQOHEc" +
       "x3Fs52lvcPErjuNn/Igds45SaYCGRBEr0Em0+wcEY4UyNLRNE1OnaQMEmsSE" +
       "9pIGaJs0GEOif8CmsY0dO7/3fVQV0yL55OSc7/me7+t8ztfn5PkfQqcDHyp4" +
       "rrXRLTfc1ZJwd2mhu+HG04JdikZZyQ80FbekIBiBtkvKg184/5OffnhxYQc6" +
       "I0J3SI7jhlJouE7Aa4FrrTWVhs4ftrYtzQ5C6AK9lNYSHIWGBdNGED5GQzcd" +
       "GRpCF+l9EWAgAgxEgHMR4MYhFRh0i+ZENp6NkJwwWEG/Bp2ioTOekokXQg8c" +
       "Z+JJvmTvsWFzDQCHG7LfE6BUPjjxofsPdN/qfJnCHy3AT3/8nRe+eB10XoTO" +
       "G84wE0cBQoRgEhG62dZsWfODhqpqqgjd5miaOtR8Q7KMNJdbhG4PDN2RwsjX" +
       "DoyUNUae5udzHlruZiXTzY+U0PUP1JsbmqXu/zo9tyQd6Hrnoa5bDYmsHSh4" +
       "zgCC+XNJ0faHXG8ajhpC950ccaDjxR4gAEPP2lq4cA+mut6RQAN0+9Z3luTo" +
       "8DD0DUcHpKfdCMwSQvdclWlma09STEnXLoXQ3Sfp2G0XoLoxN0Q2JIRefZIs" +
       "5wS8dM8JLx3xzw+Zt3zo3Q7p7OQyq5piZfLfAAbde2IQr801X3MUbTvw5kfp" +
       "j0l3fvkDOxAEiF99gnhL8we/+tLb33Tvi1/d0rz2CjQDeakp4SXlk/Kt33wd" +
       "/kj9ukyMGzw3MDLnH9M8D392r+exxAMr784Djlnn7n7ni/xfCE98VvvBDnSu" +
       "C51RXCuyQRzdpri2Z1ia39EczZdCTe1CN2qOiuf9XegsqNOGo21bB/N5oIVd" +
       "6Horbzrj5r+BieaARWais6BuOHN3v+5J4SKvJx4EQWfBA90MnjdC20/+HUJz" +
       "eOHaGiwpkmM4Lsz6bqZ/AGtOKAPbLmAZRL0JB27kgxCEXV+HJRAHC22vQ/YN" +
       "Vdfg4aRDaDjQJ9NYy2ACMGjmfbtZvHn/bzMlmc4X4lOngDtedxIMLLCOSNdS" +
       "Nf+S8nTUbL/0+Utf3zlYHHvWCqEKmHx3O/luPvnudvLda0wOnTqVz/mqTIit" +
       "+4HzTAADACBvfmT4DupdH3jwOhB3Xnw9sHxGCl8dp/FD4Ojm8KiA6IVefCZ+" +
       "7+Q9xR1o5zjgZoKDpnPZcDaDyQM4vHhyoV2J7/n3f+8nL3zscfdwyR1D8D0k" +
       "uHxktpIfPGli31U0FWDjIftH75e+dOnLj1/cga4H8AAgMZRACAO0uffkHMdW" +
       "9GP76JjpchooPHd9W7Kyrn1IOxcufDc+bMl9f2tevw3Y+KYsxN8AHngv5vPv" +
       "rPcOLytftY2VzGkntMjR961D79m//cvvV3Jz7wP1+SNb31ALHzsCDhmz8zkM" +
       "3HYYAyNf0wDdPzzD/uZHf/j+X84DAFA8dKUJL2ZlFl3AhcDMv/7V1d9959uf" +
       "/NbOYdCEYHeMZMtQkgMls3bo3DWUBLO94VAeAC4WWHZZ1FwcO7arGnNDki0t" +
       "i9L/Ov9w6Uv/9qEL2ziwQMt+GL3p5Rkctr+mCT3x9Xf++705m1NKtrkd2uyQ" +
       "bIuYdxxybvi+tMnkSN77V6//ra9IzwLsBXgXGKmWQxiU2wDKnQbn+j+al7sn" +
       "+kpZcV9wNPiPr68jScgl5cPf+tEtkx/9yUu5tMezmKO+7kveY9vwyor7E8D+" +
       "rpMrnZSCBaBDXmR+5YL14k8BRxFwVACaBQMfYE5yLDL2qE+f/fs//bM73/XN" +
       "66AdAjpnuZJKSPkig24E0a0FCwBXife2t2+dG98Aigu5qtBlym+D4u7813VA" +
       "wEeuji9EloQcLtG7/3NgyU/+439cZoQcWa6w954YL8LPf+Ie/Jd+kI8/XOLZ" +
       "6HuTy3EYJGyHY8uftX+88+CZP9+BzorQBWUvG5xIVpQtHBFkQMF+iggyxmP9" +
       "x7OZ7db92AGEve4kvByZ9iS4HOI/qGfUWf3cUTz5GficAs//ZE9m7qxhu4fe" +
       "ju9t5Pcf7OSel5wCq/V0eRfbLWbj35ZzeSAvL2bFL2zdlFXfCJZ1kKehYMTc" +
       "cCQrn/jtIQgxS7m4z30C0lLgk4tLC8vZvBok4nk4ZdrvbnO5LaBlZTlnsQ0J" +
       "9Krh8+YtVb5z3XrIjHZBWvjBf/7wN5566DvApxR0ep3ZG7jyyIxMlGXK73v+" +
       "o6+/6envfjBHKQBRkyce/sETGVf6WhpnRTsriH1V78lUHeabPy0FYT8HFk3N" +
       "tb1mKLO+YQP8Xe+lgfDjt3/H/MT3PrdN8U7G7Qli7QNP/8bPdj/09M6RxPqh" +
       "y3Lbo2O2yXUu9C17FvahB641Sz6C+JcXHv/jzzz+/q1Utx9PE9vgLehzf/3f" +
       "39h95rtfu0I2cr3l/hyODW/5EYkE3cb+hy4JUjkel5JpYRaxlTLSRDtpo7Mx" +
       "Bli712CYmSkICEsVrI487XkoTaoOVkXItIb0+5V5mIw4ypj0iNDwmhY+LLY9" +
       "URoI0zLT5iduKjNcFTFQqWNa4wVfTLkeP/ZgqlPi9VXPZgtL32kF6QAbpFFR" +
       "Ko6GFaYy79RRFMXS1JnDShVVCm2pN2ozxSAZkxFPqh2hMyjNtFFcHiUjdyx5" +
       "HubiNYOdWH02dWJOg6cN3FQpf7wsDTb8qm9XxZ7cTjudDU+IzMiaUrZc7iez" +
       "ZmddI/qim/C0vV71KdO36yVqJrYte666fUHAuTrXNWO5Fw0JcowmpXLsIlO+" +
       "13GEUXtk0iDj75T7PXvKsOVuL8Xm3Tq26IxJyqOj6WZs1QvNhupW22MLnXDT" +
       "lohO665erfDMQKQ4pomaEo/UvM4mmckNbI3PyOawwpbIUhUp8N31rNWUe6tV" +
       "ZzG3bY7tlyguIfRoNPC1yrhMULW0ierNITkUJ6RNsdOAZly8KTCx1BuEEjLG" +
       "6GpnJVnmYiP3EaFqj60K3pp1NiwRUSO9LIXMrGik5dbCoaLyBrF1bEb3Q1Ga" +
       "RJJQYI1qcWA6rfoI9qjluCX2q1O+0sbGRoxzVbrVZVrTEd1r0f06YQ8SQe3p" +
       "nN8g7SEx4sVq3K2X3I1uT2qLYbtSadPqSiyKrl6aTepNst8udzeTJFUMgUi0" +
       "RrCu+cYwKDZkoRzJokQ44oJNFkJPYTvLlk5UGGskupWe5G5G3hwRO3woY/G4" +
       "aROrqUgm7c0mLg2rM47j3dDAF+ORwHUaM2/VMHmaaeB6rDi4bvp8KV1NeNvG" +
       "eR7nWd8qSLFh9lxuqTRcR4FLBrdg2pLUXg89DJkN1qoa9dzIDBgTpwUFSSg8" +
       "qsK4IZQKG4EJWnraoeKWVKZL5XVjFA4cAokJnCONaFQ3hgXVmvlhIV07TpUZ" +
       "h/aYr4rrSF9Q606XaU7DtTxEhFplKoRJJ5KqYl8X4E2FSjZrPzRlqQjYjyym" +
       "09WLhKOQvm4Na/PChsQUpDlWPWY4nIBHafJ6lbPUibVIzKrdd5kNEQU2Md4w" +
       "qrBMZKvbwcqEKE7E9SxNon6IMiJAoVWJG8HIgEZWDXw24SgM60olNKk48y5f" +
       "E7EpPiSsGtVcaS2U9FtwsimaNabXtabCojehJhNa5ddSx4A7HN0xBGrNFyme" +
       "Y4G/GX7YNBux17SpdmOsLFtNrNvxuwHH0S0OC7FOVxUadSmlGgLXJ8p9Xmyv" +
       "Bw4corOhxLJBTeoaeF812MR0lS5alsarfocnPbXjYSg8dbrlOhjHtoRZRJvF" +
       "cqwxTYnF9WmrtKKbZVVwmtzEGM0cBJeCWpuNebfd0buaX4rTqFKpxFo7SJA2" +
       "MnfiqcbXO1OfTMfIrEdwcIOvTqllqow2vSSct7ymKKhUlxKrBr6SZqrRbyb4" +
       "lCnbGjbQV+LGLAqbNKYa6UB1x2bQdJJJjySFabAq9aeizm7UlG2uFLUrkEyJ" +
       "Q2xtpLKoWejDGFfs9uWGMeScIRNv+J7OoKm2rG00Yd6csuncLJbWlWpDm8+c" +
       "1JgHJcuQNiZSGPUcynI5JJgTM6zC94alTcFITX6+lpNJ5MeNKZrwA5JvmkGl" +
       "wNBNaqXEuioPTVIvDCRT4nqtpVnwI265WMpRXTcQxl1WBhxO95abyarQoMqK" +
       "OoYHlGsiWMg21prRGsyJIbWotGzXgSuqn8IKxaQhSgnVUakdb0hDXtTq3FRi" +
       "dF8XZqET9BOzFa1HbL1S8WvlFYM1p2JTMKeF5iRKEq7f7HJcZQ5PS3EBriGK" +
       "P0YFnFZihGL5KREZhtrnaWyojft8QK1W9bTeaNZWcXPYtcFyn/Rxh6RUD7xs" +
       "IwGLamGFXgaVGjqewguu29aaRdmXq1gDmxRih08wpNaa2+5U6upOGmhBOqnF" +
       "RkG1I9SRW25bjcmCTVYsf4NN5t50rM84pmOz/Xa7mtCLxqaHh+ZMWBc7RbtS" +
       "Ws5qTdvTTGIOy2gt5Jm25pioUPcXS7RQlX1BnskLVCiVWvWZTJOLRbBxmWo0" +
       "RzdTc8aM1Ya8ZooYhlbFuduRmnFnyXe5gLGcRrtsB2hzMUS1MTyvzuhUUdcE" +
       "329YZXMcEiDfj3pcUVg1mEqfbHQ6I6B1pdwnVCxWbMdb9AIzYVdKi5Tj4ryg" +
       "V83UnaUAuwryZi4D62jjqT6i1SLNdlezboWJdPDWRBQ8FlbRmihZ8bBJ497Y" +
       "cf2hpK2XRbGXrldCadoGGyzAAsyV6HptCsO1qRynzGxWKw+n+Arzwo0VLHFb" +
       "YwB4baREKeL9FYNqbGUV1OtzNPUFJwzRbifowShlDll4UyO6dWHqOTN4YqH1" +
       "QrtG1+txSVk3ph2y7KVoqWCNYDeat6qpNRuuhIY73hQ36cZaBxutpPFF2kjc" +
       "ftVpT1JlqHV0EiN4s8F0KN0ukKLcYHSlgk5TYaC2CGViL/3WSkXSuK5zjFNW" +
       "JrimG0zfXK2HODOmNqyVLpMG2WgvS66lLQykgQYFo9wO4TLpxQFWdmb8vFyI" +
       "tIosM1G1oM6VsR15KSc6wpCyltW+hy8Aqo7rdqVvqlXGXLEy2sP7w6IYdoM1" +
       "2XWxRhCmJXzW0Ujc4eZjfjqisMYcH6BdQRlyXIHU1OaAcyo2DhKVTgMeNekm" +
       "bdnNCG2nitDutjjX7gwSo9HXqXg1jMsV1STL3ZojDLxV3ySrtKEvEaMoVyb1" +
       "cWE9HZXcoGIvB91ChDa9EgIv5q24uvapcYRQImxggzVbmLFW0V9TExh1RxOD" +
       "E5GuxcBqrUqFLTmpV8doOleMYT/tOYnZGHNGVSmsFLgdJXKrHLfYyWitIZ42" +
       "ms/rlsLBI6SDrKmY9N1RaWMGs6DWWs0AJozXNaM/nad+MyqRbtHH+Ipag4sY" +
       "7SsBXetxPlzfzHwLqQ4qZKIHs3qVQAelxaza8WgM52S/iI7TEqNHHFut1pD1" +
       "iMQQOGzV9XbRDRlbluKpzdjF/kIos05RiRd031e4gWjGtdFwPWB8dVhQZDyN" +
       "dHs0GineaOXESCJ7y7LAy+JKMshwg1iV6mxuVwD0rwtG1EKpFOkS0SbmGFYQ" +
       "JgWwBCdRTLUGirgZuf4s7q35bh9rud26rjSa0qTVkEe+NOjNBVVJ3KTWdDdo" +
       "I1CjRUFJColeY3RmaThCyPgK5XFtt1HhW0jc1AmX3ZSb/NwlU6smxqLFBkrb" +
       "x4u4IbcpQwB7wLRVLqJLkBq4RETYDXTcwOoDscfU1FpvA+Oj0JaDRqsnTFFn" +
       "jXXgGj2Sxsg0nbWYZO3F8wCpsFGEWeyoKBIVdN13sMpCtMaRLI9Hs3jW2li9" +
       "JoZoK0JZLYKA1iN4QqytwEAL1NIWJ5tGnVPxgCiT7el4DaIJr8DznmJ1F3O/" +
       "Ho8pdBqRPQM4MDbQVPeaC6LGSjWMk21s3EODZhmpuLjY9hGzVezUGsUZgdJM" +
       "mFYlWuEsuy1rGBNHkrckVFMRWYQarGO+6s+9AKdNkCIsSxgME+yUmvDDap9r" +
       "SysTL/mtKEYdXCGtpixUo6JV8uWQK4wxcijIZkeqsVF14pv6bIyZ1GrQIBw3" +
       "qnZEX7Tp8jIclUtYtTQnhyGCz+soyDHMGQGilRxra58spenYa/XriJiW+U5P" +
       "IomSTKxTsD9XfKEO13tVRK8vgsg34nl7WJ13MFguYoyDdH1g1UpPIPxmO2DN" +
       "oi9WSKK9GFJG2tRtRqZFWxBCfSGJPcsZT5FQ8Cydwn1YwFYpVR90nVYblRQf" +
       "66FrJ27AWkmZikGpRK1SXF73fMWplqJkXIoclSmC5KWSEA2TFch+IE8ITBmO" +
       "FLcQDEqiWhslmlMoEjC+6KnCWk6RxVQmYISpEuuFVUVE8Ib31uzV7x2v7O37" +
       "tvyg4eAGCbx0Zx3kK3jr3HY9kBUPHxxO5p8zJ28djh5OHp5YQdmb9OuvdjGU" +
       "v0V/8smnn1MHnyrt7J30zULoxtD1ftHS1pp14vDr0aufGPTze7HDE6ivPPmv" +
       "94x+afGuV3Cuft8JOU+y/J3+81/rvEH5yA503cF51GU3dscHPXb8FOqcr4WR" +
       "74yOnUW9/sCyt2cWuxc8yJ5lkSufbV8xCk7lUbD1/TUOUoNr9EVZ4YTQzboW" +
       "0q4iWcye6ORhuLgvd0hxlGneYF6uH7WnH/V/o9/ZnODs/gHaw1e76dle6uxd" +
       "C+9T35FRxxVlV3Xt3b3bn6zryX2CBy5jp6/D3Y4veQtDCRhX1fYpi5dRZmEq" +
       "xeGuYUtgfl9zVM3PDtZ3CcMKNX9/4GvyA7iMUNeAFLymgOjRLa3cOnYQdTzo" +
       "eSnOV9Il5Y+4737z2fSF57fnTLIUaCFUuNpt/eV/GMiufB6+xrXV4T3ujztv" +
       "fvH7/zR5x/5avenAtfdlnnwQPOyea9mTrt3X9ZbD0/K+lPc9lfN6zzUC8yNZ" +
       "kYLAVHxNCrWt8bK29x0G5rt/jsB8KGssg+epPemfegWBuQMAy/PdEDhNU3MU" +
       "vmKQ7myJ89DKiidyqmevofVvZ8XHQ+i84jprzQ8HnpbfIe1b8k0vE24Hd5p8" +
       "ZGmHhnrmlRgqCaHXXuOCNLvtufuyf2ds/1GgfP658zfc9dz4b/I7woNb/xtp" +
       "6IZ5ZFlHD+eP1M94vjY3cv1v3B7Ve/nXZ0Lorqus6xA6s63k0n96S/+7IXTh" +
       "JH0Inc6/j9J9PoTOHdIBVtvKUZLfC6HrAElW/aK3b/y3XQ1kGnIQ+pISZlbL" +
       "4/Tg4PiY5ZJTx7fJA/fc/nLuObKzPnRs1eZ/ptnfuyJ2DxxeeI5i3v1S9VPb" +
       "G0/FktI043IDDZ3dXr4e7H8PXJXbPq8z5CM/vfULNz68v/5v3Qp8uDiOyHbf" +
       "la8X2zZ4/cwuBNM/vOv33/Lp576d3zH8LyG0M/LlJAAA");
}
