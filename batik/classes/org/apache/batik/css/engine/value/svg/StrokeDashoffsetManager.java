package org.apache.batik.css.engine.value.svg;
public class StrokeDashoffsetManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LENGTH_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_DASHOFFSET_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_0;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     INHERIT_VALUE;
        }
        return super.
          createValue(
            lu,
            engine);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public StrokeDashoffsetManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZfWwUxxWfO39/4Q8wED4MBkOEQ+5CE1oikxAwdjA9g4vB" +
       "ak3AjPfmfIv3dpfdOfvslJRESqGtQhElCakK/YcIWhFAVdO0ShMRRWpCk1YN" +
       "RU1JBYmUqiVtUIMqpX/QNn1vdvf243xnuarVk3Zub+a9mfd+8+Z9zJ29SUpM" +
       "gzQxlUf4mM7MSIfKe6hhsni7Qk1zO/QNSM8W0b/vvrHl/jAp7SczktTslqjJ" +
       "OmWmxM1+slBWTU5ViZlbGIsjR4/BTGaMUC5raj9plM2ulK7Iksy7tThDgj5q" +
       "xEg95dyQB9OcddkTcLIwBpJEhSTR9cHhthipljR9zCWf6yFv94wgZcpdy+Sk" +
       "LraXjtBomstKNCabvC1jkLt0TRkbUjQeYRke2austiHYHFudA8GSC7Wf3j6S" +
       "rBMQzKSqqnGhnrmNmZoywuIxUuv2digsZe4jj5GiGKnyEHPSEnMWjcKiUVjU" +
       "0dalAulrmJpOtWtCHe7MVKpLKBAnzf5JdGrQlD1Nj5AZZijntu6CGbRdnNXW" +
       "0jJHxafvih57dnfdj4pIbT+pldVeFEcCITgs0g+AstQgM8z18TiL95N6FTa7" +
       "lxkyVeRxe6cbTHlIpTwN2+/Agp1pnRliTRcr2EfQzUhLXDOy6iWEQdm/ShIK" +
       "HQJdZ7u6Whp2Yj8oWCmDYEaCgt3ZLMXDshrnZFGQI6tjyxeBAFjLUowntexS" +
       "xSqFDtJgmYhC1aFoL5ieOgSkJRoYoMHJvLyTItY6lYbpEBtAiwzQ9VhDQFUh" +
       "gEAWThqDZGIm2KV5gV3y7M/NLWsPP6puUsMkBDLHmaSg/FXA1BRg2sYSzGBw" +
       "DizG6tbYM3T2K4fChABxY4DYonnpq7ceWtl08U2LZv4ENFsH9zKJD0inBme8" +
       "s6B9xf1FKEa5rpkybr5Pc3HKeuyRtowOHmZ2dkYcjDiDF7f94isHfsj+GiaV" +
       "XaRU0pR0CuyoXtJSuqww42GmMoNyFu8iFUyNt4vxLlIG7zFZZVbv1kTCZLyL" +
       "FCuiq1QTvwGiBEyBEFXCu6wmNOddpzwp3jM6IaQMHlINzzJifcQ3J3o0qaVY" +
       "lEpUlVUt2mNoqL8ZBY8zCNgmo4Ng9cNRU0sbYIJRzRiKUrCDJLMHJBNph0Cm" +
       "6AhV0ixqjgi70obZRmomLSm7qQrGYUTQ8vT/w5oZxGHmaCgEW7Qg6CAUOFub" +
       "NCXOjAHpWHpDx61zA29ZxocHxkaQkwdAjIglRkSIEQExIpYYESFGBMSI5BGD" +
       "hEJi9VkojmUcsLXD4CTAS1ev6N21ec+hJUVglfpoMewLki7xRat215M47n9A" +
       "Ot9QM958fdXrYVIcIw1U4mmqYPBZbwyBW5OG7ZNfPQhxzA0niz3hBOOgoUks" +
       "Dt4sX1ixZynXRpiB/ZzM8szgBDs81tH8oWZC+cnF46OP933tnjAJ+yMILlkC" +
       "zg/Ze9DvZ/17S9BzTDRv7cEbn55/Zr/m+hBfSHIiaQ4n6rAkaB9BeAak1sX0" +
       "xYFX9rcI2CvAx3MKRgDusym4hs9FtTnuHnUpB4UTmpGiCg45GFfypKGNuj3C" +
       "cOuxabRsGE0oIKCIFA/06id+/+uP7hVIOkGl1pMN9DLe5nFkOFmDcFn1rkVu" +
       "NxgDumvHe77z9M2DO4U5AsXSiRZswbYdHBjsDiD45Jv7rr5//dSVsGvCHCJ5" +
       "ehASoozQZdZn8AnB82980Plgh+WEGtptT7g46wp1XHm5Kxs4RQWcBBpHyw4V" +
       "zFBOyHRQYXh+/lm7bNWLHx+us7ZbgR7HWlZOPoHbf8cGcuCt3f9oEtOEJAzK" +
       "Ln4umeXpZ7ozrzcMOoZyZB6/vPC5N+gJiBngp015nAnXSwQeRGzgaoHFPaK9" +
       "LzD2BWyWmV4b9x8jT/I0IB258klN3yev3hLS+rMv7753U73NsiJrF2CxNmI3" +
       "vlCAo7N1bOdkQIY5QUe1CVwaTHbfxS2P1CkXb8Oy/bCsBA7a3GqA88z4TMmm" +
       "Lil777XXZ+95p4iEO0mlotF4JxUHjlSApTNwkko8o697yJJjtByaOoEHyUEo" +
       "pwN3YdHE+9uR0rnYkfGfzvnx2tMnrwuz1K055nsnXC7aFdistMwWX+/OZMES" +
       "n9ICYPnnNMjCfKmNSMtOPXHsZHzr86usBKTBny50QDb8wu/+9Xbk+AeXJohA" +
       "FVzT71bYCFM8a5bjkr5I0S2yPtdbXZtx9MOftQxtmEqQwL6mScIA/l4ESrTm" +
       "d/pBUd544i/ztj+Y3DMFf78oAGdwyh90n7308HLpaFikuJarz0mN/UxtXmBh" +
       "UYNBLq+imthTI07L0qwBzMSNXQ5Pq20ArcHTYjlmYU3YdGRZhU1UFmAt4Az6" +
       "Cox9GZsvcTITSk41CcUJ+EsIU6L+8CcOuM+96UETgrycAsc/YufKn+vZIx1q" +
       "6fmjZYZ3TMBg0TWeiT7V9+7et8WGlaOFZGHyWAdYkidc1WETwaOwokDl6Zcn" +
       "ur/h/eHv3XjBkieY6AeI2aFj3/wscviYdUSsamhpTkHi5bEqooB0zYVWERyd" +
       "fz6//+Uz+w+Gbdy7OCkb1DSFUTW7L6FsvjbLj6Il68Zv1P78SENRJxy+LlKe" +
       "VuV9adYV9xtgmZke9MDqFlCuOdpSY8TkJNTquLI12Gyz3tf+l14UOzboor/b" +
       "b/R3wrPKttxVUzf6fKwFDHtfgTHRCYd7lmyuV+UU5Ri8HavHsUdcSFLTBQk6" +
       "/zW2XmumDkk+1gJqP1Zg7AA2Y5A+yXhdIWw3DyDj0wBILY41wbPO1mrd1AHJ" +
       "x1pA6W8VGHsKm69DAjTEuINENpnut08+fu3yvFNOimT7+slzovFnwnPMDk4D" +
       "hA041gxPp41D59QhzMdaAKYTBca+j81xP4RbwFcJ4rmc1ImMC2+PItbtkYvQ" +
       "c9OAUD2OLYan21aze+oI5WMtgMLZAmPnsDltIbSRJWha4X1Y/jsI3Tn5RYFL" +
       "L4A7M13ALYBnu6399qkDl481AE5YCBJ29J+P+o/eKwm1TSpFYiwjS1TZocrc" +
       "oVlWCKP23t4O8SZEfDmwmhNw7ZnmOqvFtVRk49bujozEdMwpBfNr2PyEkyrJ" +
       "YFBVCtyx64IL/kvTda7RaqmNIC0Afk4FApm+bmgcihkWz/h3pabAnAVM9jcF" +
       "xi5jc4mTGWDOWw0ZkhjqXBB820Xpl/8LlDKczMlzP4bF3Nycq3vrulk6d7K2" +
       "fM7JHe+KCiZ7JVwNGWkirSieTMqbVZXqBkvIQsVqqwDWxdd7k1hf9ioPwgK0" +
       "QperFus1TponZeWkZCR7vG3GD+xTkYeRk1LrxcvzIaQ6E/GAWNB6Kf8EXjlI" +
       "CVKIby/dR5xUunSwqPXiJfkYZgcSfL2pO0csOjlcMfjFk/ZeZkK5dbYwosbJ" +
       "jMhTRi/11Q7ivx8nuU5b//4MSOdPbt7y6K3PP29dekkKHR/HWaogpbau1rJV" +
       "ZHPe2Zy5SjetuD3jQsUyJ9f3Xbp5ZROmDKdUXFDNC9wCmS3Zy6Crp9a++qtD" +
       "pZehStlJQpBkzNzp+efF+puhLaOnoXzfGcstHaDiFtdTbSu+O/bgysTf/iCu" +
       "MIhVaizITz8gXTm967dH555qCpOqLlICZQzL9JNK2dw4pm5j0ojRT2pksyMD" +
       "IsIsMlV8dckMPF0U47rAxYazJtuLt6GcLMmttnLvkCsVbZQZG7S0GsdpoLKp" +
       "cnuc2wRfIZ7W9QCD2+MpMAV9JIO7AeY6EOvWdecqsTiqC1+TmDibgzYkXGYC" +
       "30L/AVv3UhgXHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
