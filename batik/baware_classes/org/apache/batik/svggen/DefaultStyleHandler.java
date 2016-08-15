package org.apache.batik.svggen;
public class DefaultStyleHandler implements org.apache.batik.svggen.StyleHandler, org.apache.batik.util.SVGConstants {
    static java.util.Map ignoreAttributes = new java.util.HashMap();
    static { java.util.Set textAttributes = new java.util.HashSet();
             textAttributes.add(SVG_FONT_SIZE_ATTRIBUTE);
             textAttributes.add(SVG_FONT_FAMILY_ATTRIBUTE);
             textAttributes.add(SVG_FONT_STYLE_ATTRIBUTE);
             textAttributes.add(SVG_FONT_WEIGHT_ATTRIBUTE);
             ignoreAttributes.put(SVG_RECT_TAG, textAttributes);
             ignoreAttributes.put(SVG_CIRCLE_TAG, textAttributes);
             ignoreAttributes.put(SVG_ELLIPSE_TAG, textAttributes);
             ignoreAttributes.put(SVG_POLYGON_TAG, textAttributes);
             ignoreAttributes.put(SVG_POLYGON_TAG, textAttributes);
             ignoreAttributes.put(SVG_LINE_TAG, textAttributes);
             ignoreAttributes.put(SVG_PATH_TAG, textAttributes); }
    public void setStyle(org.w3c.dom.Element element, java.util.Map styleMap,
                         org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        java.lang.String tagName =
          element.
          getTagName(
            );
        java.util.Iterator iter =
          styleMap.
          keySet(
            ).
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            java.lang.String styleName =
              (java.lang.String)
                iter.
                next(
                  );
            if (element.
                  getAttributeNS(
                    null,
                    styleName).
                  length(
                    ) ==
                  0) {
                if (appliesTo(
                      styleName,
                      tagName)) {
                    element.
                      setAttributeNS(
                        null,
                        styleName,
                        (java.lang.String)
                          styleMap.
                          get(
                            styleName));
                }
            }
        }
    }
    protected boolean appliesTo(java.lang.String styleName, java.lang.String tagName) {
        java.util.Set s =
          (java.util.Set)
            ignoreAttributes.
            get(
              tagName);
        if (s ==
              null) {
            return true;
        }
        else {
            return !s.
              contains(
                styleName);
        }
    }
    public DefaultStyleHandler() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lzgsdaHj5jTDzvYwLE/ZnUN++o07f3fyh4dHRdBvyc1svnEz/7FJie79098z" +
       "/MI5LUtC4hsfCZ15ZFbbqg/5eIdc2OjmVGawAoJ2xt52OvFpoKnohQAqjqAa" +
       "yUqR+7GSZOc6AmmhaefNkEZ7+r0pnshnWtPkOdtPbK5p/bTmBEmoM2lWr/Rh" +
       "sJy5cBl8IQuDIT8G8xCvdPEhi3jZwoqlaXYxeQ6eSuvksCibQifcdCAH1wyS" +
       "vj2ZgII5DgpYLOtNRk26GY/y5HJA2nZLTUPz3Z80CRg0ZpF1ZaH7n/lVJHJL" +
       "jSSEm7Ip9mafp06WSG8nzr8vBtyUZYCQqz8V+n7/m7te5fRewsJ5n21YV7CG" +
       "sO8KGzVpw1QxO9TCd9kyzGVBu9v+xxwLhsHVSk7AbSDUJydIjF3t2B6sHO5L" +
       "1c9JynOAHac9Nqys/uiun9wjzDo/x9l15J/++uULx8bPnREBhJkXsrtcl9HM" +
       "GzBLGxZOkfo4APl03VcnP3ivf3vAovwqVvQLCM+kqNKhMyBP1rgjTXt5adqa" +
       "7oWJ0Lz2u9W/PlCX3wE5SScqSary7iTpjHlPY7GZjLpw49y5nBNaw4pgioVm" +
       "ivIWA2eKtIOVd7Fig1jsymycncpxVln1Vuec8r+iKeKPi6YDtmmacyXb7izb" +
       "Fm7KEOY27e1fl342YPCZk+s+ye/CJ/YeOh7b9OhyAaI67x2tXU0mHv/9v14N" +
       "Hr38cparQSnV9FsVMkIUz148ZAOI7eZXbYe/36k6+N7TzYNrvkg+z9oab5Cx" +
       "s99zYROLc4PUv5QX9/5lVt+qoZ1fIDWf6zOnX+VPu8+8vG6RdDDA3xVEYMl4" +
       "j/AOavUCuMwgNGmoXsgu8AaVVfBtsIDV5Q8qDpgXsWIwM3Z05Rjqy9vyuUfz" +
       "bcBNY4AbvV0KxrRE0GIp1rXFFsh5VwRMWjmvZljPSXyV90+RKO5lxShFJcBT" +
       "HP7mlAlKjwEUSuURiylCe+reHX7kyuNWRMu47niEycSh730e3H9IYFy8IS3I" +
       "eMZxjxHvSG4yMd0UnGUWPqLjz+f2PHNqzz6bGTWKCkY0OeYwT2oK5vkvskXW" +
       "sEbn7Wba7Q2sby582y23b58CMVlykFLd0CjENBLzpSGVU+j0eTbgJboaHgNY" +
       "FhYUD22s/Qhfx+EpMPEwK34AK8K6rsjE7NPM7BmIz8G39eyUJpp73rft3mf5" +
       "jP37tqs+QVFxVNMUglV/SGI/oynHUQf+H45KwaHK8o7Ckv6ZGY+14oFROnu8" +
       "umTG8S1vcvpMPwJWABHGk4riTktd9SLdIHGZ771CJKki5p2iaEaOQ8tyT17h" +
       "iz8p5B8D1/nlKSrk/91yZykqc+RAlai4RX5GUT6IsOqTehZciOw8leeKLchl" +
       "//ob2T89xH23Z7TBH8ttwCR7rOzo3PGujfdd+8qj4m1BUvD4ONNSDgmFeMFI" +
       "R4D5ObXZuorWt1yveqJ0oQ03z9uGe20cBQAu/g4wy3fZNpvTd+63Tqx87rWJ" +
       "oteBoLaiPAyo2Zp5j0npSQi9W8OZiRNES/4K0Nry8NiqpfGP3uY3RZRxP/TL" +
       "D0gXT25/4+DME40BVN6JCoHBSIpfsNaOqZuJNGJEUKVstqdgiaBFxoonK6ti" +
       "4MTsdHO7WOasTLeyRydIYzKJNvOpDm7Vo8RYoyXVmJXXlTstnld8O4gmdd03" +
       "wGlx3R+wOP3MG4DHgXC3rtsvNmWv6fyYRrNTAStf4FVWnP8PxYmVfEgbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KMrm/wMyQ9B4+SQAAA==");
}
