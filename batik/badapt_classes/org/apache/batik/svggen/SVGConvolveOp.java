package org.apache.batik.svggen;
public class SVGConvolveOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    public SVGConvolveOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp filter,
                                                             java.awt.Rectangle filterRect) {
        if (filter instanceof java.awt.image.ConvolveOp)
            return toSVG(
                     (java.awt.image.ConvolveOp)
                       filter);
        else
            return null;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.ConvolveOp convolveOp) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          (org.apache.batik.svggen.SVGFilterDescriptor)
            descMap.
            get(
              convolveOp);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (filterDesc ==
              null) {
            java.awt.image.Kernel kernel =
              convolveOp.
              getKernel(
                );
            org.w3c.dom.Element filterDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FILTER_TAG);
            org.w3c.dom.Element feConvolveMatrixDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_CONVOLVE_MATRIX_TAG);
            feConvolveMatrixDef.
              setAttributeNS(
                null,
                SVG_ORDER_ATTRIBUTE,
                kernel.
                  getWidth(
                    ) +
                SPACE +
                kernel.
                  getHeight(
                    ));
            float[] data =
              kernel.
              getKernelData(
                null);
            java.lang.StringBuffer kernelMatrixBuf =
              new java.lang.StringBuffer(
              data.
                length *
                8);
            for (int i =
                   0;
                 i <
                   data.
                     length;
                 i++) {
                kernelMatrixBuf.
                  append(
                    doubleString(
                      data[i]));
                kernelMatrixBuf.
                  append(
                    SPACE);
            }
            feConvolveMatrixDef.
              setAttributeNS(
                null,
                SVG_KERNEL_MATRIX_ATTRIBUTE,
                kernelMatrixBuf.
                  toString(
                    ).
                  trim(
                    ));
            filterDef.
              appendChild(
                feConvolveMatrixDef);
            filterDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_FE_CONVOLVE_MATRIX));
            if (convolveOp.
                  getEdgeCondition(
                    ) ==
                  java.awt.image.ConvolveOp.
                    EDGE_NO_OP)
                feConvolveMatrixDef.
                  setAttributeNS(
                    null,
                    SVG_EDGE_MODE_ATTRIBUTE,
                    SVG_DUPLICATE_VALUE);
            else
                feConvolveMatrixDef.
                  setAttributeNS(
                    null,
                    SVG_EDGE_MODE_ATTRIBUTE,
                    SVG_NONE_VALUE);
            java.lang.StringBuffer filterAttrBuf =
              new java.lang.StringBuffer(
              URL_PREFIX);
            filterAttrBuf.
              append(
                SIGN_POUND);
            filterAttrBuf.
              append(
                filterDef.
                  getAttributeNS(
                    null,
                    SVG_ID_ATTRIBUTE));
            filterAttrBuf.
              append(
                URL_SUFFIX);
            filterDesc =
              new org.apache.batik.svggen.SVGFilterDescriptor(
                filterAttrBuf.
                  toString(
                    ),
                filterDef);
            defSet.
              add(
                filterDef);
            descMap.
              put(
                convolveOp,
                filterDesc);
        }
        return filterDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwcRxWfO387/k5iu/mwE8cOchLuGmiQjNNS+2I7DucP" +
       "7NQCp81lbnfubuO93c3urH126KdUNfxThTRJA1L9l6sKVNoKUQESrYwq0VYF" +
       "pJYIKKgBiX9KIaIRUvkjfL2Z2a/b8yUEwUk7tzvz5s28N7/3e2/3xeuoyjJR" +
       "F9FojC4bxIqNaHQamxaREyq2rOPQl5KercB/Pfnh5EAUVc+jphy2JiRskVGF" +
       "qLI1j3YqmkWxJhFrkhCZzZg2iUXMRUwVXZtHWxVrPG+oiqTQCV0mTGAOm0nU" +
       "iik1lbRNybijgKKdSdhJnO8kPhQeHkyiBkk3ln3xzoB4IjDCJPP+WhZFLcnT" +
       "eBHHbaqo8aRi0cGCifYburqcVXUaIwUaO60eclxwLHmoxAU9rzR/cvN8roW7" +
       "YDPWNJ1y86wZYunqIpGTqNnvHVFJ3jqDHkEVSbQpIExRb9JdNA6LxmFR11pf" +
       "CnbfSDQ7n9C5OdTVVG1IbEMU7S5WYmAT5x0103zPoKGWOrbzyWDtLs9aYWWJ" +
       "iZf2xy8+e7LluxWoeR41K9os244Em6CwyDw4lOTTxLSGZJnI86hVg8OeJaaC" +
       "VWXFOek2S8lqmNpw/K5bWKdtEJOv6fsKzhFsM22J6qZnXoYDynmqyqg4C7a2" +
       "+7YKC0dZPxhYr8DGzAwG3DlTKhcUTaaoOzzDs7H3iyAAU2vyhOZ0b6lKDUMH" +
       "ahMQUbGWjc8C9LQsiFbpAECTom1llTJfG1hawFmSYogMyU2LIZCq445gUyja" +
       "GhbjmuCUtoVOKXA+1ycPP31WO6pFUQT2LBNJZfvfBJO6QpNmSIaYBOJATGzY" +
       "l7yM2187F0UIhLeGhIXM97964/4DXetvCZntG8hMpU8TiaaktXTTuzsS/QMV" +
       "bBu1hm4p7PCLLOdRNu2MDBYMYJh2TyMbjLmD6zM/+cpj3yZ/iqL6cVQt6aqd" +
       "Bxy1SnreUFRijhGNmJgSeRzVEU1O8PFxVAP3SUUjoncqk7EIHUeVKu+q1vkz" +
       "uCgDKpiL6uFe0TK6e29gmuP3BQMhVAMXaoCrD4kf/6foy/GcnidxLGFN0fT4" +
       "tKkz+604ME4afJuLpwH1C3FLt02AYFw3s3EMOMgRd2AxmyVafHZuDEJokeF+" +
       "yogxhBn/R90FZtfmpUgEXL4jHPAqxMpRXZWJmZIu2sMjN15KvSPAxALA8QhF" +
       "fbBcTCwX48vFxHKxouVQJMJX2cKWFYcKR7IAwQ3s2tA/+9CxU+d6KgBNxlIl" +
       "+JOJ9hRlmYTPAC5tp6SX2xpXdl87+EYUVSZRG5aojVWWNIbMLNCRtOBEbEMa" +
       "8o+fBnYF0gDLX6YuERlYqFw6cLTU6ovEZP0UbQlocJMUC8d4+RSx4f7R+pWl" +
       "x+cevTuKosXMz5asAtJi06cZX3u83BuO+I30Nj/14ScvX35Y92O/KJW4GbBk" +
       "JrOhJ4yDsHtS0r5d+NXUaw/3crfXATdTDLEEtNcVXqOIWgZdmma21ILBGd3M" +
       "Y5UNuT6upzlTX/J7OEBb+f0WgMUmFmudcPU7wcf/2Wi7wdoOAWiGs5AVPA3c" +
       "O2s89+uf//Gz3N1uxmgOpPpZQgcDLMWUtXE+avVhe9wkBOQ+uDL9zKXrT53g" +
       "mAWJPRst2MvaBLATHCG4+cm3zrz/u2trV6M+zimkaTsN1U7BM5L1o/pbGAmr" +
       "7fX3AyynAhsw1PQ+oAE+lYyC0yphgfX35r6Dr/756RaBAxV6XBgduL0Cv/+u" +
       "YfTYOyf/1sXVRCSWZX2f+WKCujf7modMEy+zfRQef2/nN97Ez0ESAOK1lBXC" +
       "uTTixDrbVCdF+2/BJA6166ZTYPCDPsRn3s3be5iTuD7ExwZY02cFA6Y4JgMV" +
       "VEo6f/XjxrmPX7/BLSwuwYL4mMDGoIAka/YWQH1HmNCOYisHcvesTz7Yoq7f" +
       "BI3zoFECYramTCDTQhGaHOmqmt/8+I32U+9WoOgoqld1LI9iHpioDiKCWDng" +
       "4YLxhfsFIJZqoWnhpqIS40s62KF0b3zcI3mD8gNa+UHH9w6/sHqNI9MQOrYH" +
       "FX6KNfs9jPJfdTgLBjFapMFEO8sVKrzIWnvi4qo89fxBUU60FSf/Eahtv/PL" +
       "f/w0duX3b2+Qf+qobnxaJYtEDawZZUsW5Y8JXsP5HPZB04U//LA3O3wnqYP1" +
       "dd0mObDnbjBiX/lUEN7Km098tO34fblTd5AFukPuDKv81sSLb4/tlS5EecEq" +
       "EkBJoVs8aTDoWFjUJFCZa8xM1tPIYb/HA0A3O9heuAYcAAxszMQbYMfjt3JT" +
       "Q1EddU7UYYkuDmW8RGNKHirl2LCdYTlGHmdPU4Yr1uaJzQDaoUhXCd/S3C04" +
       "40HWfImiKqoD5fwntDSqqFDvHyGWZCqG+3LyedbMiLi597+MWdaREMZMlDp9" +
       "zPHc2J07vdzUkFtC1HxXyOl+YceXVG7h1DxrZNep7OGk7yXyv/BSgaLGomKT" +
       "MV5nyfureOeSXlptru1YfeBXPPC996IGCOGMraqBCAhGQ7VhkozC7WkQCUAY" +
       "blPUUQYekNnFDd82FfKw1ZawPLiG/wflzlJU78uBKnETFHmEogoQYbePeqj/" +
       "TDmsDqWh1gOW8zDLvAUlG+SjSCnb87PZeruzCdD7niK2418YXGayxTcGKNZX" +
       "j02evfG550X1Jal4ZYW/kcILtigEPXbbXVabq6v6aP/Nplfq+qIOyFrFhn34" +
       "bw8gMAFA5pjYFipNrF6vQnl/7fDrPztX/R4kmBMoginafCLwfi9eZqG+sSGt" +
       "nEj6iSXwhYrXTIP931y+70DmL7/liRSJF5kd5eVT0tUXHvrFhc41qK02jaMq" +
       "yIWkMI/qFevIsgbEtWjOo0bFGinAFkGLgtVxVGtryhmbjMtJ1MTgi9m3B+4X" +
       "x52NXi+r3SnqKfnIsMEbDxQdS8Qc1m1N5nwPmcjvKfr04SYI2zBCE/we7yi3" +
       "lNqeko58rflH59sqRiEEi8wJqq+x7LSXfIJfQ/xs1CLY7V/wi8D1T3axQ2cd" +
       "7B+SQML5MrDL+zQA1Y0Yq0glJwzDla3/yBBB9HXWPFNg/RRF9jm9AUpkj5f5" +
       "+pf4LWuu/Btr30TIGRUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6N/83v2/87bfeOlr+T3gfwOMoEfBkyAAAA==");
}
