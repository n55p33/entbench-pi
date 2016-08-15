package org.apache.batik.svggen;
public class DefaultImageHandler implements org.apache.batik.svggen.ImageHandler, org.apache.batik.svggen.ErrorConstants, org.apache.batik.util.XMLConstants {
    public DefaultImageHandler() { super(); }
    public void handleImage(java.awt.Image image, org.w3c.dom.Element imageElement,
                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getWidth(
                    null)));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getHeight(
                    null)));
        try {
            handleHREF(
              image,
              imageElement,
              generatorContext);
        }
        catch (org.apache.batik.svggen.SVGGraphics2DIOException e) {
            try {
                generatorContext.
                  errorHandler.
                  handleError(
                    e);
            }
            catch (org.apache.batik.svggen.SVGGraphics2DIOException io) {
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  io);
            }
        }
    }
    public void handleImage(java.awt.image.RenderedImage image,
                            org.w3c.dom.Element imageElement,
                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getWidth(
                    )));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getHeight(
                    )));
        try {
            handleHREF(
              image,
              imageElement,
              generatorContext);
        }
        catch (org.apache.batik.svggen.SVGGraphics2DIOException e) {
            try {
                generatorContext.
                  errorHandler.
                  handleError(
                    e);
            }
            catch (org.apache.batik.svggen.SVGGraphics2DIOException io) {
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  io);
            }
        }
    }
    public void handleImage(java.awt.image.renderable.RenderableImage image,
                            org.w3c.dom.Element imageElement,
                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getWidth(
                    )));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getHeight(
                    )));
        try {
            handleHREF(
              image,
              imageElement,
              generatorContext);
        }
        catch (org.apache.batik.svggen.SVGGraphics2DIOException e) {
            try {
                generatorContext.
                  errorHandler.
                  handleError(
                    e);
            }
            catch (org.apache.batik.svggen.SVGGraphics2DIOException io) {
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  io);
            }
        }
    }
    protected void handleHREF(java.awt.Image image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            image.
              toString(
                ));
    }
    protected void handleHREF(java.awt.image.RenderedImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            image.
              toString(
                ));
    }
    protected void handleHREF(java.awt.image.renderable.RenderableImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            image.
              toString(
                ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FOo+EI/YXPsvvOdDzzEbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVae+zrVn33vbe9bW8f97alj3WlL27L2rCfkzjOY+UVJ3Fi" +
       "x3Gc2IkTb3DxM3biV/yKbSgDpq0dSAVBgU6Cjj9gG6w8NIG2CTEVTQwQDIkJ" +
       "DTZpgKZJY2No9I+xaWxjx87vfR9VRYnkk5Nzvud7zvdzvt/v+fp88+yPoKt9" +
       "Dyq4jpksTCfYUeNgZ2miO0Hiqv4OSaGM6Pmq0jJF3+dA2wX5gc+c/clP36Of" +
       "OwmdFqBbRdt2AjEwHNsfq75jRqpCQWcPWjumavkBdI5aipEIh4FhwpThB49S" +
       "0PWHhgbQeWpvCTBYAgyWAOdLgJsHVGDQjaodWq1shGgH/hp6K3SCgk67cra8" +
       "ALr/KBNX9ERrlw2TSwA4XJv9ngKh8sGxB923L/tW5osEfn8BfuqDbzz3J6eg" +
       "swJ01rDZbDkyWEQAJhGgGyzVklTPbyqKqgjQzbaqKqzqGaJppPm6BegW31jY" +
       "YhB66j5IWWPoql4+5wFyN8iZbF4oB463L55mqKay9+tqzRQXQNbbD2TdSohn" +
       "7UDAMwZYmKeJsro35KqVYSsBdO/xEfsynu8DAjD0GksNdGd/qqtsETRAt2z3" +
       "zhTtBcwGnmEvAOnVTghmCaC7Lss0w9oV5ZW4UC8E0J3H6ZhtF6C6LgciGxJA" +
       "tx0nyzmBXbrr2C4d2p8f0a9+8s12zz6Zr1lRZTNb/7Vg0D3HBo1VTfVUW1a3" +
       "A294hPqAePsXnjgJQYD4tmPEW5o/fcvzr3/VPc99ZUvzy5egGUpLVQ4uyB+V" +
       "bvrm3a2HG6eyZVzrOr6Rbf4RyXP1Z3Z7Ho1dYHm373PMOnf2Op8b/9X8bZ9Q" +
       "f3gSOkNAp2XHDC2gRzfLjuUapup1VVv1xEBVCOg61VZaeT8BXQPqlGGr29ah" +
       "pvlqQEBXmXnTaSf/DSDSAIsMomtA3bA1Z6/uioGe12MXgqBrwAM1wPNKaPt5" +
       "KCsC6I2w7lgqLMqibdgOzHhOJr8Pq3YgAWx1WAJav4J9J/SACsKOt4BFoAe6" +
       "utcRLRaqDbdVTQzNgLCAEvREWwFS7WR65v7CZ4gzGc9tTpwA8N993PhNYDc9" +
       "x1RU74L8VIh1nv/Uha+d3DeGXXQCqAAm3dlOupNPurOddOcSk0InTuRzvSyb" +
       "fLvNYJNWwNyBI7zhYfYN5JueeOAU0C93cxVAOCOFL++PWwcOgsjdoAy0FHru" +
       "6c3bp79ZPAmdPOpYswWDpjPZcCZzh/tu7/xxg7oU37OP/+Ann/7AY86BaR3x" +
       "1LsWf/HIzGIfOA6t58iqAnzgAftH7hM/d+ELj50/CV0F3ABwfYEIVBV4lXuO" +
       "z3HEch/d84KZLFcDgTXHs0Qz69pzXWcC3XM2By35nt+U128GGF+fqfI94HnV" +
       "rm7n31nvrW5WvmyrI9mmHZMi97KvYd0Pf+cb/4LkcO855LOHjjhWDR495AQy" +
       "Zmdzc7/5QAc4T1UB3T88zbzv/T96/NdzBQAUr7jUhOezsgWMH2whgPm3v7L+" +
       "u+9996PfOnmgNAE4BUPJNOR4X8isHTpzBSHBbA8drAc4EROYWaY15ye25SiG" +
       "ZoiSqWZa+j9nHyx97t+ePLfVAxO07KnRq16YwUH7L2HQ2772xv+8J2dzQs4O" +
       "sQPMDsi2nvHWA85NzxOTbB3x2//m5b/3ZfHDwMcCv+YbqZq7KijHAMo3Dc7l" +
       "fyQvd471lbLiXv+w8h+1r0PBxgX5Pd/68Y3TH//F8/lqj0Yrh/d6ILqPbtUr" +
       "K+6LAfs7jlt6T/R1QFd5jv6Nc+ZzPwUcBcBRBt7LH3rA18RHNGOX+upr/v6L" +
       "f3n7m755CjqJQ2dMR1RwMTcy6Dqg3aqvAzcVu697/XZzN9eC4lwuKnSR8Ful" +
       "uDP/dQos8OHL+xc8CzYOTPTO/x6a0jv+8b8uAiH3LJc4Y4+NF+BnP3RX67U/" +
       "zMcfmHg2+p74Yv8LArODseVPWP9x8oHTXzoJXSNA5+TdqG8qmmFmOAKIdPy9" +
       "UBBEhkf6j0Yt2yP60X0Xdvdx93Jo2uPO5cDvg3pGndXPHPYnPwOfE+D5v+zJ" +
       "4M4atmflLa3dA/u+/RPbdeMTwFqvLu/UdorZ+NflXO7Py/NZ8crtNmXVXwFm" +
       "7efhJhihGbZo5hO/PgAqZsrn97hPQfgJ9uT80qzlbG4DAXeuTpn0O9uYbevQ" +
       "srKcs9iqBHpZ9fm1LVV+ct10wIxyQPj3rn96z9ff/YrvgT0loaujDG+wlYdm" +
       "pMMsIv6dZ9//8uuf+v67ci8FXNT0bQ/+ex5fUFeSOCs6WYHviXpXJiqbH/aU" +
       "6AeD3LGoSi7tFVWZ8QwL+N9oN9yDH7vle6sP/eCT21DuuN4eI1afeOqdP9t5" +
       "8qmThwLoV1wUwx4esw2i80XfuIuwB91/pVnyEfg/f/qxz//RY49vV3XL0XCw" +
       "A952Pvm3//v1nae//9VLRCFXmc7PsbHBjZ/pVXyiufehpoJa3kzi2NKGNVhr" +
       "ozVzPq12k047dDqYJJBet4uFku11qabEWzKRImhY4WuFYhgiTLnMroJxx9Hh" +
       "+cCQm4bbdck+QTvrETYyxfWgzup+qV3lAxNjS+pIZ9ezwoQxW+3+egoX21Ij" +
       "CmylXCs3sCqxNi00lGBRkgpSLeULhRg2BKvKtejOQpogFsEVvEGb4R2NWIik" +
       "E5T6jVFRKZLatLeuLxl0iVSQoFsZrmRnVCTXK5TAu1xDdgeGsFoK/a5vucm6" +
       "sxwig1hqdyaD7gBdxZwHgiOWXplWWnaRMW5ao4IzmMxbYWKNHbY4GVRoleNo" +
       "XioEC3KId6Y6yfc3K2Q4hZHxSm8IfYureYacIgYiVJA+aSZoSqDivCI7w0HR" +
       "HopJx6kRZAgPul12CjSBa01mS0KQdGfE9DE9bElCh1bHTV+TJHfV8O2VX2wt" +
       "dHMy5SZh2qaRAU5zsbnyR64nI3oVd+WkjZLhiupQa2bQl4OOKrPyYCOOF5Yi" +
       "xiWXb5fak5h2a05pPkIRGp+tO0aVWCU8ytrjdZFkA2Fl+F1uPJEbQXkwNvyZ" +
       "kJRKHpGkda43dXi714BnML4RxLGjcxJRXQ7C8RzryKS+wka4uTYx05omaXdu" +
       "DFfj+YzuWWKXw6ZoEtTcqUkP1yRrzzVf4alm6nF0Ox2aBqb5RKCbrsEH3ZKX" +
       "VAiSa6yTflhscvNhEJZKUn+DwxG2wR0Bt6ROX2sPeyZRINd+zOkSOi6PA4mp" +
       "J61Be7TWuSXLFmtTyew782GR18fjNekQ7Q1TKjVZYmrpzREx5NQJPyWCedWU" +
       "BWex4scrrooSqj9l6QlB9JoEWWPq8xXB1WiijiQo2gg1q7FCer0SVSu1muSG" +
       "dJccTm7g2WSzHhQRsalSgwqDDaVmt7QuDOy+mM7SFU822Y4AWx1KsDRtyPCL" +
       "aiR5Xuwm8iYi2oOK6mAk01or3XKpLhRxJK7Pk1lHLHnuKpHs6hBV+5O2YkbD" +
       "5aCqkkuBnyOVQcjWI4paNsS6Ai97NRFtTxou3WenDNtXsbFRZU0FN/XYFK2B" +
       "Qyd46Nv0JKGVeYTA4qhvG8MkWafqZraUBSrRzFZorEsEF226xrCvN42up/NT" +
       "aWlFQ3+CViZpbCkdnMB7NWLMRPK4Wq7jtJv6rUQt4c2AM8R1snb4XruJBHSd" +
       "WciTOVYujys4voDxpVgKmp1Juxt0gaJhWNG2IkxnSHIhIj5l0H1kA+vsyCEK" +
       "64HUXOvtlKvBq0FXGsfxarRoMs2ojjUKmIzSdlXqWFh36gZDSS2jiuGhQWfk" +
       "M4tKcUhWg0XRbZbEiT7oeoTVHvNzszlqzddVYUhZpVTCyDnSljcKzCubNEIk" +
       "CS7TRFIh5cJkVCGcwpK1qSVX05xOjOI9Vw6D9pSmvHWjQU2WfaLKTtllTOOj" +
       "zXIG3ECPHBUFF9YLZpdgu+iCH27INrYctzslY6BhVDzqdzxxKnbLcrdhD5Ji" +
       "lcFa06AyGjD4oihhDWHgCYk4rDE13jKaJOrPWzZFtBBsMewVCcaOZpParKJN" +
       "OnpUbHQku7QpaBM9jSb4UO7hxjxAiaDbde1NqaD2KTbxZ0VdXXh6w8Fr7dnC" +
       "4yy8uOGH/qAIjyvVtDobyXTDZdsjqUezNI7PUnOOp9SqMi9XtDlheSKBombT" +
       "SJ26xiMbni9qY7hLS2XNKw+qsUgU6/XSSm/6g5kOT2wEjmi7IZMhWZwXwxEJ" +
       "+8OBgnh13HA9fFxdx+Is4JxBvKKCshAuJ/NUZWp6V8bmpqmzgh/X5hKMTX1C" +
       "btcT0u8hMOwUPMsbCZrda5KIqnOJXUx5drixA5Yf6LTJh0Mfi6pqUyi2+WDY" +
       "YBdCI5n1xWXLH7YbYsFC+UAr0FEsOH6vFY0qNO42hM00hMtyeVWnoxoc2Fap" +
       "ya3a7TB0DXTuzlO7gK9rS2IwdGwvwWJUKXQ4qdG0CTZp9lPgRFix3o878w6F" +
       "u90K1xCLbA2JtLDeWPh0DVmlaUmzo43Td8uVgt1r15yGFrFT3kKDhaop1cVw" +
       "reBeecMLHawxY+rp2mKslTXikYZZaKiSyYbISB0QIsk1K8K6jXnLHqil0tDq" +
       "rxeNAhx4PqwWJiu+Ga2nk2I3DM2K2xp3rSYyQJkFzzFVM64WaVs1uq5rzVmP" +
       "HKTVqLnB1Wlv6akmUcXLGAPPuGEd9UObKoZ8X5CGoVDDlWovFR0fqY81d8xI" +
       "drceIaUNLagkStkGN/dqWhUeKZXxDNd7/mCUDhNL3Cyj5ZiZYctaaY4TU32M" +
       "iOVuLHX0lRzKqr2sSN00gUu+K/D2IF1iKOG04EItKMAtF0E3JR9vmj5dgrka" +
       "zklDnIBdk9NNbrUQO4RlAE2LaKFWr1QiEOeWkE6lvPEKxWF9JMDUhlhOdZGh" +
       "oqoZMb3NrCAFWquFwkmllSQEUJzqlIndCrouB/0qy42EzpRPOyaFRsOewrnY" +
       "eG7RY2MFJ2vR4Ip0JRoFCTILZxomSDC9mfE9e+a0W7ygop6vj2xk4CbJNHVS" +
       "fawQpFTr8VUhaTJkQyAdweBbVm8ah3Eilqsk0lUqjdK8NhjPBnFEEl4vXOm9" +
       "uhTz8xmJTEmZr/pjMLdTHJGiv3BbeG+p6ITGBFy1qCwRqZQUE+ANCj2kVaOX" +
       "RSWt0D2hUDa6helYjpK+zkTdvl/srIIgWLZhnKm06syK0YLmsEZhbKUhhMO0" +
       "odkdZFQc+YLQsVxhvnLVqFEsKBjFpHGR7i6XAx8jC9LC4muzOXAUgjSzgDeE" +
       "x2qZ7JlJrRqhFBMmXYkhaCStRRixoql6GcVMW07AiTARDKeDs7pTx7R+bTCx" +
       "+uFco+pdrc9vhmhE9MKYCOWB2MA61dgbF2pqod01FhvgS5NeO9XbTUIhjUpR" +
       "Z3ShVRc6bL9d7adql+1jVRRLFuWKF4QFLEkdThebq9nY8zlLMxTYozv0cjJg" +
       "N91+AacorDidNoUyXqmrstor921NJLAwraZKmaT7XMOZtIsuWxDsAB4xDWu0" +
       "cq1Bp7PymDlDK5zlBGsmKDcYrrpqozGFdtXA7KDKSC3Y/qbXwNmxI08wW2ti" +
       "qlfZOMwybbH4pimENlvppQvEJ9NgWNYnsMJwOoOPTbFHxlGhjqG1VW3BEDAd" +
       "T6nFjHFhEBtiVRxe4AuGq9VMdFqd8Q0BLVb5mGsISRoilajowT4+3TTIHhUH" +
       "fbJSN7CIM1m3m2zCVoNZe7zbwUv1SE77dkJ3W6sAr3aIAE4ECu6yGq3Z5rDv" +
       "s8i0UJk1yaKHVdc+VoUJKl25zRiva3gJSW0rrVN6BR5bSS1ykoWWtkZhE64W" +
       "axWholSMsjSQB+NpIIBTYo1Q1bVeLKhJuTaClUIQA5MyZnjbMTdmSdHxsdDY" +
       "aEK7J5ATvjz0/HVhGYR02pj7Stwf4OCEpzzGVgsENqbE5nLpF4CbHFshImwi" +
       "qSGjgQprfJzYsm423HZTH8/9upJO+I2O8dO4u1r3mHEXUZl2fV0cTspuUUHQ" +
       "oD7vzeq1uNC3QPjaKNWzK6CeK/qzRlQro3ScTkhqBs7VfkKW5oLDTZJQ5NnZ" +
       "pLeqi3RHIRZWWhT4FumsRJvlqh63tjebVHOXHaVPoP1xxWBLG1/F/YSRDHNU" +
       "mMy1FTrXULyrsEinns69/mza7bvuouu1a7KFjmoyOUMjXlHqzSBRaybHpNK8" +
       "0edjIGBkgihuFfWopizX0vW6nhZFSmrW8apnbCqeLk8sS8Yb2FroEZthtWax" +
       "UcDCazxkNL/MbmyUabJeNEPRTgEfOoUOAc9njB9FQ6Wdph0JvKG9Jnt1e8OL" +
       "e3u+Ob8o2M/0gJfmrKP3It4at133Z8WD+5eL+ef0XlZg7/vw5eLhG6fdS4nz" +
       "l7s1P3xdvkf80OWIO57nePs5wD3yBy4iz9+gZwNqnzR7IX/55fJI+cv4R9/x" +
       "1DPK8GOlk7sXhrMAui5w3F811Ug1D0l0GnB65PIXD4M8jXZwkfXld/zrXdxr" +
       "9Te9iOv5e4+t8zjLjw+e/Wr3Ifm9J6FT+9daFyX4jg569Ohl1hlPDULP5o5c" +
       "ab386BV5EzyV3Q1GLn1FfkllPJEr41YFj93HnjqqEturJXETbHVgr/nWbDc3" +
       "iLyjONZOlkNWd9O9t10h98JOu7vXbLl+ZOnZfAnJFa6E354VQQBdr+fad7AI" +
       "9pBZ8AF0VeQYyoG9hC90y3J4nrxhfTGyzC6yw18IsnfvI2tkQu2MVVtRPVXJ" +
       "Rcxo3pIVb81ZPXkFhN6bFb97FKGs6bcO0HjnS4GGuYvG6heCxsPH0PByNLL0" +
       "xC4wWfVS0HzoCtB8JCs+eEVonv45oLkpa2yB54ldaB5/MdAA1+V6TqDKgapc" +
       "CaHsZ3pM6D8+RnpiNzO5C2bxShboia5uyH65TQw7say6maPLmX4yKz4WQGe2" +
       "aPXGHfwYWH/wUoD11C5Y73uxevTxF0Lp3cdQ+vNLo5T9/FRO8Pms+OyVJP7c" +
       "SyHxR3Yl/v2XXOIPH5P4Sy8k8Zez4rkrSfzFFyNxDE6CS2TUs/TgnRf9bWf7" +
       "VxP5U8+cvfaOZybfzpPK+38HuY6CrtVC0zyczTlUP+16qmbkIly3ze24+dc3" +
       "AuiOyyh7lprJK/mq/3pL/80AOnecPoCuzr8P030LQHRAB1htK4dJvh1ApwBJ" +
       "Vv2Oe4m0zjapFZ84FJbsqkiO8y0vhPP+kMM55yyUyf82tRd2hNs/Tl2QP/0M" +
       "Sb/5+erHtjlv2RTT3GlcS0HXbNPv+6HL/ZfltsfrdO/hn970mese3Auzbtou" +
       "+EBdD63t3ksnmMHLbpCnhNM/u+Ozr/7DZ76bZ5n+H/zQiyDPJgAA");
}
