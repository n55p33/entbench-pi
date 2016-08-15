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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gkSnmP2CeMXmxX8Dn2QIW64ZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeezsRn33+yV5L3k53ksCIQRyv1CSpT/vrtd7EI54vafX" +
       "9tre027h4Xu9PtfH2muaAlELqEgE0QCpRNJ/QFAaCEVFbVVRpapaQKBKVKiX" +
       "VEBtpUIpEvkDWjVt6dj7u98RRVRdybPeme9853vNZ74zs8/9CLou8KGC51ob" +
       "3XLDXTUJd5cWuhtuPDXYJUiUEf1AVXBLDIIxqLsoP/DFcz996SOL8zvQaQG6" +
       "XXQcNxRDw3UCTg1ca60qJHTusLZtqXYQQufJpbgW4Sg0LJg0gvBRErrxSNcQ" +
       "ukDuiwADEWAgApyLAGOHVKDTzaoT2XjWQ3TCYAX9KnSKhE57ciZeCN1/nIkn" +
       "+qK9x4bJNQAcrs9+T4FSeefEh+470H2r8yUKf6wAP/WJd57/0jXQOQE6Zzij" +
       "TBwZCBGCQQToJlu1JdUPMEVRFQG61VFVZaT6hmgZaS63AN0WGLojhpGvHhgp" +
       "q4w81c/HPLTcTXKmmx/JoesfqKcZqqXs/7pOs0Qd6HrHoa5bDTtZPVDwrAEE" +
       "8zVRVve7XGsajhJC957scaDjhQEgAF3P2Gq4cA+GutYRQQV029Z3lujo8Cj0" +
       "DUcHpNe5ERglhO66ItPM1p4om6KuXgyhO0/SMdsmQHVDboisSwi9+iRZzgl4" +
       "6a4TXjrinx/Rb/nwu52es5PLrKiylcl/Peh0z4lOnKqpvurI6rbjTY+QHxfv" +
       "+MoHdyAIEL/6BPGW5g9+5cXH3nTPC1/b0rzuMjRDaanK4UX5U9It33o9/nDj" +
       "mkyM6z03MDLnH9M8D39mr+XRxAMz744Djlnj7n7jC9xf8O/9nPrDHehsHzot" +
       "u1Zkgzi6VXZtz7BUv6s6qi+GqtKHblAdBc/b+9AZ8E4ajrqtHWpaoIZ96For" +
       "rzrt5r+BiTTAIjPRGfBuOJq7/+6J4SJ/TzwIgs6AB7oJPG+Etp/8O4Q0eOHa" +
       "KizKomM4Lsz4bqZ/AKtOKAHbLmAJRL0JB27kgxCEXV+HRRAHC3WvQfINRVfh" +
       "0bTbUXGgT6axmsEEYNDM23azePP+30ZKMp3Px6dOAXe8/iQYWGAe9VxLUf2L" +
       "8lNRs/3iFy5+Y+dgcuxZK4QQMPjudvDdfPDd7eC7VxkcOnUqH/NVmRBb9wPn" +
       "mQAGAEDe9PDoHcS7PvjANSDuvPhaYPmMFL4yTuOHwNHP4VEG0Qu98HT8vul7" +
       "ijvQznHAzQQHVWez7kwGkwdweOHkRLsc33Mf+P5Pn//44+7hlDuG4HtIcGnP" +
       "bCY/cNLEviurCsDGQ/aP3Cd++eJXHr+wA10L4AFAYiiCEAZoc8/JMY7N6Ef3" +
       "0THT5TqgsOb6tmhlTfuQdjZc+G58WJP7/pb8/VZg4xuzEH8DeOC9mM+/s9bb" +
       "vax81TZWMqed0CJH37eOvGf+9i9/gOTm3gfqc0eWvpEaPnoEHDJm53IYuPUw" +
       "Bsa+qgK6f3ia+c2P/egDv5QHAKB48HIDXsjKLLqAC4GZf/1rq7/77nc+9e2d" +
       "w6AJweoYSZYhJwdKZvXQ2asoCUZ7w6E8AFwsMO2yqLkwcWxXMTRDlCw1i9L/" +
       "OvdQ6cv/9uHz2ziwQM1+GL3p5Rkc1r+2Cb33G+/893tyNqfkbHE7tNkh2RYx" +
       "bz/kjPm+uMnkSN73V3f/1lfFZwD2ArwLjFTNIQzKbQDlToNz/R/Jy90TbaWs" +
       "uDc4GvzH59eRJOSi/JFv//jm6Y//5MVc2uNZzFFfU6L36Da8suK+BLB/zcmZ" +
       "3hODBaCrvED/8nnrhZcARwFwlAGaBUMfYE5yLDL2qK878/d/+md3vOtb10A7" +
       "Heis5YpKR8wnGXQDiG41WAC4Sry3P7Z1bnw9KM7nqkKXKL8NijvzX9cAAR++" +
       "Mr50siTkcIre+Z9DS3riH//jEiPkyHKZtfdEfwF+7pN34W/7Yd7/cIpnve9J" +
       "LsVhkLAd9i1/zv7JzgOn/3wHOiNA5+W9bHAqWlE2cQSQAQX7KSLIGI+1H89m" +
       "tkv3owcQ9vqT8HJk2JPgcoj/4D2jzt7PHsWTn4HPKfD8T/Zk5s4qtmvobfje" +
       "Qn7fwUrueckpMFuvK+/WdotZ/7fnXO7PywtZ8QtbN2WvbwTTOsjTUNBDMxzR" +
       "ygd+LAQhZskX9rlPQVoKfHJhadVyNq8GiXgeTpn2u9tcbgtoWVnOWWxDAr1i" +
       "+Lx5S5WvXLccMiNdkBZ+6J8/8s0nH/wu8CkBXbfO7A1ceWREOsoy5fc/97G7" +
       "b3zqex/KUQpA1PTXXrrrsYwreTWNs6KdFZ19Ve/KVB3liz8pBiGVA4uq5Npe" +
       "NZQZ37AB/q730kD48du+a37y+5/fpngn4/YEsfrBp37jZ7sffmrnSGL94CW5" +
       "7dE+2+Q6F/rmPQv70P1XGyXv0fmX5x//488+/oGtVLcdTxPbYBf0+b/+72/u" +
       "Pv29r18mG7nWcn8Ox4Y3/7hXCfrY/ocs8WI5npSSWWEeMUi50kS7KdbdGMNa" +
       "e4DR9Nzk+QpDFKyuNBt4KNlTnFq10kvrFYpCtDAZs4QxHXRow2ta+KjY9vjV" +
       "kJ+V6TY3dVOJZqsVAxW7pjVZcMWUHXATDya6JU5fDWymsPSdVpAOa8M0KorF" +
       "8QihEa3bQFG0lqaOBstVVC60xcG4TReDZNKLuJ7S5bvD0lwdx+VxMnYnoufV" +
       "XLxuMNMpxaRIzKvwDMNNhfAny9Jww60ouyoMpHba7W64jkCPrRlhS2UqmTe7" +
       "63qHEtyEI+31iiJM326UiLnQtmxNcSmex9kG2zdjaRCNOr0JmpTKsVuZcYOu" +
       "w4/bY5MEGX+3TA3sGc2U+4O0pvUbtUV30iM8MpptJlaj0MQUt9qeWOiUnbUE" +
       "dNZw9SrC0UOBYOkmaopcpe51N8lcwmprfN5rjhCm5JTKlQLXX89bTWmwWnUX" +
       "mm2zDFUi2KSjR+OhryKTcoeop01Ub456I2HaswlmFpC0izd5OhYHw1CsTGpk" +
       "tbsSLXOxkagKX7UnFoK35t0N04mIsV4WQ3peNNJya+EQUXlTsfXanKRCQZxG" +
       "Il+gRtXi0HZa4Rj2iOWkJVDVGYe0axMjxtkq2erTrdmYHLRIqtGxhwmvDHTW" +
       "x3r2qDPmhGrcb5TcjW5P64tRG0HapLISioKrl+bTRrNHtcv9zTRJZYPvJCoW" +
       "rOu+MQqKmMSXI0kQO46wYJIFP5CZ7rKldxDaGgsuMhDdzdjTKkKXC6VaPGna" +
       "ndVM6CXtzSYujapzluXc0MAXkzHPdrG5t8JMjqQxXI9lB9dNnyulqyln2zjH" +
       "4RzjWwUxNsyByy5lzHVkuGSwC7otiu31yKtV5sO1okQDNzID2sRJXq4kBB5V" +
       "YdzgS4UNTwctPe0ScUssk6XyGh+HQ9uqxB2c7RnRuGGMCooz98NCunacqjIJ" +
       "7QlXFdaRviDW3T7dnIVraVTh68iMD5NuJFYFSufhDUIkm7UfmpJYBOzHFt3t" +
       "68WOI/d8vSTW1cKmV5MrzYni0aPRFDxyk9OrrKVMrUViVm3KpTedKLA7kw2t" +
       "8MtEsvrdWrkjCFNhPU+TiApRWgAotCqxY7gyJCsrDJ9PWaJW64slNEEcrc/V" +
       "hdoMH3WsOtFcqSSK+S042RTNOj3oWzN+MZgS0ympcGuxa8BdluwaPLHmigTH" +
       "MsDfNDdqmljsNW2ijU3kZatZ63f9fsCyZIuthbVuX+GxhpgSGM9SnTLFCe31" +
       "0IFDdD4SGSaoi30DpxSDSUxX7qNlcbKiulzPU7peDYWnTt9uiCzFtPh5RJrF" +
       "cqzSTZHB9VmrtCKbZYV3muzUGM+dCi4G9TYTc267q/dVvxSnEYIgsdoOkkq7" +
       "ojnxTOUa3ZnfSyeV+aDDwhhXnRHLVB5vBkmo4UJT4BWiTwhVA1+Jc8Wgmgk+" +
       "o8u2WhvqK2FjFvlNGhNYOlTciRk0nWQ66PX4WbAqUTNBZzZKyjRXstLne3SJ" +
       "rdjqWGFQs0DBNbbYpyTMGLHOiI433ECn0VRd1jcqrzVnTKqZxdIaqfZVbT5P" +
       "N1pQsgxxY1YK44FDWC5bCbTOvIZwg1FpU1ikpqBFUjKN/BiboQk37HFNM0AK" +
       "NNkkVnKsK9LI7OmFoWiK7KC1NAt+xC4XSylq6EaFdpfIkMXJwXIzXRUwoiwr" +
       "E3hIuGalFjLYWjVaQ60zIhZIy3YdGFH8FBYJOg1Rgq+OS+140zOkRb3BzkRa" +
       "93V+HjoBlZitCB4zDQSpGeUVXWvOhCZvzgrNaZQkLNXssyyiwUgpLsCFiuxP" +
       "UB4n5bhCMNysExmGQnFkbaROKC4gVqtG2sCa9VXcHPVtMN2nFO70CMUDm+1K" +
       "wKBqiJBLGamjkxm8YPtttVmUfKlaw2rTQuxwSa1eb2m2OxP7upMGapBO67FR" +
       "UOwIdaSW21biXsHuIVZt4yiaO5voc5bu2gzVblcTcoFtBnhozvl1sVu0kdJy" +
       "XidsTzU7Giyh9ZCj26pjopPGarFE0YLk89JcWqB8qdRqzCWyt1gEG5euRhq6" +
       "mZlzeqJg0pou1mpoVdDcrtiMu0uuzwa05WDtsh2gzcUIVSewVp37KausOxyF" +
       "WWVzEnZAvh8N2CK/wmiE6mHd7hhojZSpjlKLZdvxFoPATJiV3OpJcVEr6FUz" +
       "decpwK6CtNGkZYCok5k+JpUiyfRX8z5CRzrYNXUKHgMraF0QrXjUJHFv4rj+" +
       "SFTXy6IwSNdVvjRrgwUWYEHNFclGfQbD9akUp/QEqdujGb6qeeHGCpa4rdIA" +
       "vDZiIhdxakWjKoOs6o2G3Et93glDtN8NBjBKmCMG3tQ7/QY/85w5PLXQWqFd" +
       "JxuNuCSvsVm3V/ZStFSwxrAbaa1uas1HKx5zJ5viJt1Y62CjllSuSBqJS1Wd" +
       "9jSVR2pX79U6nInRXUK3Cz1BwmhdRtBZyg+VVkee2ku/tVIqadzQWdopy1Nc" +
       "1Q2aMlfrEU5PiA1jpcsE62HtZcm11IVRwdCgYJTbIVzueXFQKztzTisXIhWR" +
       "JDqqFhRNntiRl7KCw48Ia1mlPHwBUHXSsBHKVKq0uWIkdIBTo6IQ9oN1r+/W" +
       "sCBMS/i8q/Zwh9Um3GxM1DANH6J9Xh6xbKGnKs0h6yA2DhKVLgaPm2STtOxm" +
       "hLZTmW/3W6xrd4eJgVE6Ea9GcRlRzF65X3f4obeizF6VNPRlxShKyLQxKaxn" +
       "41IQIPZy2C9EaNMrVSqc1oqra5+YRBVCgI3acM0U5oxVdNbEFG6446nBCpW+" +
       "RcNKvdoJW7UkqY7QVJONEZUOnMTEJqxRlQsrGW5HidQqxy1mOl6rFU8da1rD" +
       "kll4XOlW1kTc891xaWMG86DeWs0BJkzXdYOaaanfjEo9t+jXEkSpw8Ua6csB" +
       "WR+wPgwnc9+qVIdIL9GDeaPaQYelxbza9cgazkp+EZ2kJVqPWKZardfX4x5S" +
       "jMNWQ28X3ZC2JTGe2bRdpBZ8mXGKcrwgKV9mh4IZ18ej9ZCSlFFBlfA00u3x" +
       "eCx745UTVxLJW5Z5ThJWotELNxULqc41GwHQvy4YUQsl0kq/E21ilmZ4floA" +
       "U3AaxURrKAubsevP48Ga61O1lttv6DLWFKctTBr74nCg8YqcuEm95W5QLFCi" +
       "RUFJColeZ3R6aTh8SPsy4bFtF0O4ViVu6h2X2ZSbnOb2UqsuxILFBHLbx4u4" +
       "IbUJgwdrwKxVLqLLerHsdqKOjaETrNYYCgO6rtQHGxhkGrYUYK0BP0MdpxZo" +
       "hZ5H4yop+AubR4oVpiBLDjxVRo5nByu0jkRco1bRNwONCVdNr0J66KiDNerr" +
       "KRaV2OLMqky11aq0mXEybKIpNUBxtd9dzoy0Zfj4HGbkpaQ51nAUjNbTcnVg" +
       "Fr15y+IEslTlZDSe6ABWHbC5delEGXTUMlaTpUlzaJTqbLPaUrEqqdetqIwq" +
       "nU7kjlKcXis2r9GTxIg2Uduqm8680gchMym0Ohul3OCqDbg+c/y24YJ1v4+H" +
       "U7YplpZIZZIsInKj06Yyr4qVEl1eaf506QWdTSuc9RAFRzYx6Sqjdqmn42kR" +
       "UVpUKUg6NaXsSSMYrjpLr1xvMWrR5BYiYfgFtbVi5qVWFUUHk6Wt1odoDVt0" +
       "QlKvhisErXndWimQYc2EZXYWl+fThGcMQmF8Daarmj2ut6dBdSVZFFbSV7Pe" +
       "SJwGtaUBcsh2IuibcRcsiGOKmrF8SFmjdOVPJsGkGrcX00agNARTXbfHTbC5" +
       "H04bVh1JK7q2FoetYRks9yXBoxFLAWmkiPArsTSOoqpUYYSK4bK9oGXPwpXR" +
       "GDbJqDif9apmoBbrc08LcU03R47NlHGVmtvJvN5yymx/Vq0IYIf31mzr945X" +
       "tvu+NT9oOLhBApvurKH3Cnad26b7s+Khg8PJ/HP65K3D0cPJwxMrKNtJ332l" +
       "i6F8F/2pJ556Vhl+urSzd9I3D6EbQtf7RUtdq9aJw69HrnxiQOX3YocnUF99" +
       "4l/vGr9t8a5XcK5+7wk5T7L8Heq5r3ffIH90B7rm4Dzqkhu7450ePX4KddZX" +
       "w8h3xsfOou4+sOxtmcXuAU9lz7KVy59tXzYKTuVRsPX9VQ5Sg6u0RVnhhNBN" +
       "uhqSrixa9J7ovcNwcV/ukOIo07zCvFQ/Yk8/4v9GvzM5wZn9A7SHrnTTs73U" +
       "2bsW3qe+PaOOEXlXce3dvdufrOmJfYL7L2Gnr8Pdri96C0MOaFdR9ymLl1Bm" +
       "YSrG4a5hi2B8X3UU1c8O1nc7hhWq/n7H1+YHcBmhrgIpOFUG0aNbarl17CDq" +
       "eNBzYpzPpIvyH7Hf+9Yz6fPPbc+ZJDFQQ6hwpdv6S/8wkF35PHSVa6vDe9yf" +
       "dN/8wg/+afqO/bl644Fr7808+QB4mD3XMiddu6/rzYen5ZSYtz2Z83rPVQLz" +
       "o1mRgsCUfVUM1a3xsrr3Hwbmu3+OwHwwqyyD58k96Z98BYG5AwDL890QOE1V" +
       "chS+bJDubInz0MqK9+ZUz1xF69/Oik+E0DnZddaqHw49Nb9D2rfkm14m3A7u" +
       "NLnIUg8N9fQrMVQSQq+7ygVpdttz5yX/ztj+o0D+wrPnrn/Ns5O/ye8ID279" +
       "byCh67XIso4ezh95P+35qmbk+t+wPar38q/PhtBrrjCvQ+j09iWX/jNb+t8N" +
       "ofMn6UPouvz7KN0XQujsIR1gtX05SvJ7IXQNIMlev+TtG//tVwIZTApCX5TD" +
       "zGp5nB4cHB+zXHLq+DJ54J7bXs49R1bWB4/N2vzPNPtrV8TsgcPzzxL0u1+s" +
       "fnp74ylbYppmXK4noTPby9eD9e/+K3Lb53W69/BLt3zxhof25/8tW4EPJ8cR" +
       "2e69/PVi2wbbz+xCMP3D1/z+Wz7z7HfyO4b/BZFh19vlJAAA");
}
