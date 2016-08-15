package org.apache.batik.extension.svg;
public class BatikHistogramNormalizationElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public BatikHistogramNormalizationElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_HISTOGRAM_NORMALIZATION_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikHistogramNormalizationElementBridge(
                                                            );
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
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
        org.apache.batik.ext.awt.image.renderable.Filter sourceGraphics =
          (org.apache.batik.ext.awt.image.renderable.Filter)
            filterMap.
            get(
              SVG_SOURCE_GRAPHIC_VALUE);
        java.awt.geom.Rectangle2D defaultRegion;
        if (in ==
              sourceGraphics) {
            defaultRegion =
              filterRegion;
        }
        else {
            defaultRegion =
              in.
                getBounds2D(
                  );
        }
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        float trim =
          1;
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            BATIK_EXT_TRIM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            try {
                trim =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { BATIK_EXT_TRIM_ATTRIBUTE,
                  s });
            }
        }
        if (trim <
              0)
            trim =
              0;
        else
            if (trim >
                  100)
                trim =
                  100;
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          in;
        filter =
          new org.apache.batik.extension.svg.BatikHistogramNormalizationFilter8Bit(
            filter,
            trim /
              100);
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
        handleColorInterpolationFilters(
          filter,
          filterElement);
        return filter;
    }
    protected static int convertSides(org.w3c.dom.Element filterElement,
                                      java.lang.String attrName,
                                      int defaultValue,
                                      org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            attrName);
        if (s.
              length(
                ) ==
              0) {
            return defaultValue;
        }
        else {
            int ret =
              0;
            try {
                ret =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGInteger(
                      s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s });
            }
            if (ret <
                  3)
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s });
            return ret;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Y6kT2RX2Soc//htPnpkmox0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LHZJY9qUxmTLzEKv0eSyHdlUc3wYkeaGXlcZ11g40+5Ii8fzgVcbyTtrM5Ax" +
       "M2SoTtNvVDDFSjW4bjCJmARbdJ4YwWC82UpL1pmQQawvJFjW1eqiuxjpagX3" +
       "drCspktRH7W4SCDzPh510FEokpQ3iduUAjfwBY5hOYxqRsdqDHdEhBAiYaBB" +
       "YMT9PtJtLxzOGLRiRZu2l6RP8QHjBUolICjU9sgJtxV1BrHwAYOsYBxXKZHP" +
       "ulwEZkzHb8pZdwSz2QIfU2ECN9WsxW9MdroY7Zq7bddsO6N5bx2LyErcBbRS" +
       "r89TYdZszC2B8fSUT6dtZiUyO1rrsaIvNV08wI3GHN9JdsWarFir3c1jLfSb" +
       "oUDl1ZY6NmEP19IIrVqLulTvpkp/YQy7nWZ10fY6reXY3OBDJuN1JgljJ3FV" +
       "YTvj6pNRj5iC54zAJ2tFMJUqb2yc4UxMlnAjXztBnZe3G0lWOrIZ0Iy+XPRJ" +
       "Q6OJ+tBbGWhVQioVzHV2yaJd5UQuF2ym38omfK01GLuLeCUgmZ/hrTXXHCM2" +
       "vEq96aTpMuI0z0gkZ4xcqNVjY2zZQhoqeJJSmykXW9iy119oIopW2ytbSWIW" +
       "nidKYComrOxyWFAdoploi6iK2Y1wNQ64YS0xXQ3WxkMs77JYZeHTO5tGFtik" +
       "JVmL7sqfZjiNzDodv5cgZrVhqii8aRHaGGko0jqYV6qsIznIpFdJZZNj+k3U" +
       "9SZhK2zCy4qaVpZqQ6nVBcJb5OvNbplM/TAepco0m1P1eLVubcMJ3R935VRo" +
       "dleR1pl1ZcKYBH276vtWZ5v31iNeEAbsMgupBR/txOZo0yBHVtr3F/3hJsPQ" +
       "Kprj9qQxngymXW60YSbZlhgMMalWc43YyzrUriqpY5fXybo8Wylq10CGcK2z" +
       "qXq2Y8lIPV8GXtvHEN93wzWOUMHcmqkE4y4mKb+aKW1eJYx06w3kUG3Ws9Fo" +
       "0Jitmys/UDv+UEX8tM4v/MVwtApQRVzhQjbrEEbCDQYEEXnDyaa/9ow6Em41" +
       "Zbm16zS2WlPcsO6uw3QTdphEHS8HYi905rVJPdjthIg2697C55vrXt2jJPDy" +
       "iKdxFeUZ1qPE9pIxBZWKqxM+WfADbi04S0lPevPcM5ZkNMprWaz027xc85VG" +
       "bSuIVtpbNHbZoipOMgM8i5eB2aWH1W3qDqn1OHDVdTXlnOlk6TBcR2y2wVvu" +
       "NgpCYAkstFb+bNOYLZSFB1c4dtzOpIW9cuSERMXG0JpVos1MVQdYY64mck9s" +
       "Tnm9sVTn/TqmYXUc27WjtKWuZ0IN5PJ8Iel91pYaVh9Lq6mH+2tKxl15DUtr" +
       "r12Hm+vNrMb1Kj1PMHgtqE0ZWuZYbTmKNXWeOhGzSvw6hzrw0qDXKeZhBqxm" +
       "OCI5KEuO0tl4XKeaWcj0OVRpIlVKmeLkYN5X6uZMZXDaEjYjcdXMqM06RzQ3" +
       "dTMdRpWuNcLsIWUkCM36rfmolonDno+0Mh0jqXE6Ge2iRd/ebQ2nskhd0+uF" +
       "nFLz+ZHdVnifrfL1ttNjlUWTd2Y9g09dK/L8Oil6Y2+kUV2rwvOtQccK25P5" +
       "mJdibMmyq3Q9ICl/FIH6Zdudb0V32QyEis6hY2I255VJHo2HE385nM0iSU6J" +
       "qijnTUVqUK7d3jA+3t/MKOCIFqfMBnqX2RjDebYhGAI8HhkpI/FRg8bdaMix" +
       "VrfPdnxGymecHkrwgK5KHAV7m6rkYDt3VsNyyUVdM1robJMyahuJbCA+GxqW" +
       "qOnOAG9oqsYG1Zo4mO4sNs8pK5iOtUqUYy1CH1NLzE/MmVGPx8Nsi6sj0Y+w" +
       "RTjTVvM8HsP+bjRh+1t5vOiLCO1PfEfTDDbdzcaNVq6nSDTuR4xEwtPGlDc6" +
       "ODVRRK6ylTJ7t/OJEbyAiU4geCTeqttRolrbtVMn8B1aEfKF6kzhsTNjcNzJ" +
       "qzWMSbVeZDWzlR4lVVbsKqum46EUHY4aZh8HxcI6tFsb1O7rFsPqK95Zz0dy" +
       "c+cGVDNYbvR2kteHuJp6jDNqbnueAyO1Kob0hV6HaiNdeolnmzRjFL03rSxj" +
       "Mkq7hhZ4qMVM+7SxG4rLeqs723K10Om3uhHSG4+YbV2qtGoqtmZH2JrJfR0b" +
       "t7J52GbUKCdlR0QFWKUQDG502BZOO3Nj5fUHg9VM3m4rW6w3FNeC79vBVrZW" +
       "1fo0wpwhorcFuTFXXFYgDE1wtnQVvELFlWVnOahKuCaPt7u0i7BYq2lrHCgZ" +
       "+jWb7BAStlbweWuiJUutMxTMarsf41ttAao/OrISzY/WqYVXMC61ePA+uM0G" +
       "eZ9ExjOq4S1nlV0LU5lmXotaAUuAmnYUNSo6MfBJjlK5QcwMLHAZ2N62Nhjo" +
       "PcHk25Zp6/3ZZNDuetyq3sjrczva4QOMb7ABbQ+nDQ+JdWk7Wq2RjjXV21E2" +
       "WYwsLoe3xLaHRrrn2DnFoVyAz9FNIjeXJrFrw4jiOKv5rtcfWNNFf4UCjOCX" +
       "taknw7ARj11/43h5FbwMv/nNxWvy217eSsVD5aLM8U6dZWPFQPdlvKHvh54s" +
       "mqePF3LL36WjXZ2j/9MLuSerexeOFoCqX8zuBZ3Hxxu0xXLFo7fbuSuXKj7y" +
       "rudfUEY/hlw8XE5dxtB9sed/na2mqn1Kh2KX+o23X5bhyo3Lk2W+333XPzwy" +
       "+wbj7S9j8+Lxc3qeF/lR7sXfY75K/oGL0F3Hi343bameZXr27FLflVCNk9Cd" +
       "nVnwe/Q4JA8XEXgSHM3DkDRvvYFwy/S5UKbPPmnusFqd3GEsKxo/hq7qajwE" +
       "Wkcg0KrA98p8O0m14AstBp2WW3Y4Z018DBxvOjTxTV9+E995h7HvKJpvjaEH" +
       "gImsJ0v28DA6p+x77ku171FwkIf2kV9++77vDmPfXzTviaH7gX1HSXg0eR+7" +
       "afKu93ub+x3FEwd895cjwKtDB6y+PA64XBJcPrLl6TvbcvhtxhH1KwvqrC4f" +
       "KJ5zcLiNWgy9cETw5E3i9DQ+YELJN0w5GnrKsRNviYAHUhYfmI4E7h+qrqKG" +
       "xQ7VQce0YzU8YnxduZJdEOoq0IJXZRAc3VZr1JkV3bPAxoNqqUDLG/IvTz7z" +
       "qQ/vPv7ifsF2LUVqDFVu98nMzV/tFHunT99h//fkY4p/Zb7+pb//6/nbjvD4" +
       "/uPQPl5E8ilw3DgM7Y3zoT2y9RUn206cVI79VCnrR+6QuR8rmg+AmQleX6RY" +
       "3Tuv6PvRk8T8oS8hMV9XdD4Njo8eav/Rl5GYF8FDyQ+9GARNVYpu+pZJendJ" +
       "fHeZWiegMi1J9/osYuguc598HypF/PIdXPLrRfNzcflNUKqG8dQ8zMNfOXHJ" +
       "z78cl+Qx9DVf7AcGxW7pa2/6Mmr/NY/8sReu3vuaF4Q/KffYj7+4uY+F7tUS" +
       "2z69uXXq/JIfqppZWnbffqvLL/9++1bQdKauAE4DbWnOb+15PhFDj9yeB0Tr" +
       "+Pw01ydj6Np5rhi6p/w/TfcHMXTlhC6GLu1PTpN8CugESIrTP/SP8v4tt0Ml" +
       "Yh3FoSTH0zmzT+zjLZszPs8vnCp4DjO4jPLDXyjKxyyn9/qLaV5+AndU0CTj" +
       "QzT5+Av94bd8Dv2x/bcGsi3tdoWUe1no8v6zh+Oi6MnbSjuSdan7zOcf/Jn7" +
       "nj4CjAf3Cp/MplO6PX7rjX3a8eNyK373S6/5+Tf9+At/We7u/R/Hq6anmygA" +
       "AA==");
}
