package org.apache.batik.svggen;
public class SVGEllipse extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGLine svgLine;
    public SVGEllipse(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Ellipse2D ellipse) {
        if (ellipse.
              getWidth(
                ) <
              0 ||
              ellipse.
              getHeight(
                ) <
              0) {
            return null;
        }
        if (ellipse.
              getWidth(
                ) ==
              ellipse.
              getHeight(
                ))
            return toSVGCircle(
                     ellipse);
        else
            return toSVGEllipse(
                     ellipse);
    }
    private org.w3c.dom.Element toSVGCircle(java.awt.geom.Ellipse2D ellipse) {
        org.w3c.dom.Element svgCircle =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_CIRCLE_TAG);
        svgCircle.
          setAttributeNS(
            null,
            SVG_CX_ATTRIBUTE,
            doubleString(
              ellipse.
                getX(
                  ) +
                ellipse.
                getWidth(
                  ) /
                2));
        svgCircle.
          setAttributeNS(
            null,
            SVG_CY_ATTRIBUTE,
            doubleString(
              ellipse.
                getY(
                  ) +
                ellipse.
                getHeight(
                  ) /
                2));
        svgCircle.
          setAttributeNS(
            null,
            SVG_R_ATTRIBUTE,
            doubleString(
              ellipse.
                getWidth(
                  ) /
                2));
        return svgCircle;
    }
    private org.w3c.dom.Element toSVGEllipse(java.awt.geom.Ellipse2D ellipse) {
        if (ellipse.
              getWidth(
                ) >
              0 &&
              ellipse.
              getHeight(
                ) >
              0) {
            org.w3c.dom.Element svgCircle =
              generatorContext.
                domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_ELLIPSE_TAG);
            svgCircle.
              setAttributeNS(
                null,
                SVG_CX_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getX(
                      ) +
                    ellipse.
                    getWidth(
                      ) /
                    2));
            svgCircle.
              setAttributeNS(
                null,
                SVG_CY_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getY(
                      ) +
                    ellipse.
                    getHeight(
                      ) /
                    2));
            svgCircle.
              setAttributeNS(
                null,
                SVG_RX_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getWidth(
                      ) /
                    2));
            svgCircle.
              setAttributeNS(
                null,
                SVG_RY_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getHeight(
                      ) /
                    2));
            return svgCircle;
        }
        else
            if (ellipse.
                  getWidth(
                    ) ==
                  0 &&
                  ellipse.
                  getHeight(
                    ) >
                  0) {
                java.awt.geom.Line2D line =
                  new java.awt.geom.Line2D.Double(
                  ellipse.
                    getX(
                      ),
                  ellipse.
                    getY(
                      ),
                  ellipse.
                    getX(
                      ),
                  ellipse.
                    getY(
                      ) +
                    ellipse.
                    getHeight(
                      ));
                if (svgLine ==
                      null)
                    svgLine =
                      new org.apache.batik.svggen.SVGLine(
                        generatorContext);
                return svgLine.
                  toSVG(
                    line);
            }
            else
                if (ellipse.
                      getWidth(
                        ) >
                      0 &&
                      ellipse.
                      getHeight(
                        ) ==
                      0) {
                    java.awt.geom.Line2D line =
                      new java.awt.geom.Line2D.Double(
                      ellipse.
                        getX(
                          ),
                      ellipse.
                        getY(
                          ),
                      ellipse.
                        getX(
                          ) +
                        ellipse.
                        getWidth(
                          ),
                      ellipse.
                        getY(
                          ));
                    if (svgLine ==
                          null)
                        svgLine =
                          new org.apache.batik.svggen.SVGLine(
                            generatorContext);
                    return svgLine.
                      toSVG(
                        line);
                }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO+NvG3/w5fJhgzFENuQuTkIragKBw4DJ2TgY" +
                                                              "kHo0HHN7c3cLe7vL7px9dpoWkCLIP5RSIKRK/JcjFEoCihq1lZqIKmqTKG2l" +
                                                              "JPQjrUKr9p+0KWpQ1aQq/Xozs993Z4rUnLSzczNv3pv35r3fe7OXb6Jq00Cd" +
                                                              "RKUROqkTMzKo0lFsmCQdU7Bp7oGxpPR0Ff7rgQ9H1odRTQLNzWFzWMIm2SYT" +
                                                              "JW0m0DJZNSlWJWKOEJJmK0YNYhJjHFNZUxNogWwO5XVFlmQ6rKUJI9iHjThq" +
                                                              "w5QacqpAyZDFgKJlcdhJlO8kujk4PRBHTZKmT7rkHR7ymGeGUeZdWSZFrfFD" +
                                                              "eBxHC1RWonHZpANFA63RNWUyq2g0Qoo0ckhZZ5lgZ3xdiQm6r7Z8cvt0rpWb" +
                                                              "YB5WVY1y9czdxNSUcZKOoxZ3dFAhefMI+iqqiqNGDzFFPXFbaBSERkGora1L" +
                                                              "BbtvJmohH9O4OtTmVKNLbEMUrfAz0bGB8xabUb5n4FBHLd35YtB2uaOt0LJE" +
                                                              "xXNromefPtD6chVqSaAWWR1j25FgExSEJMCgJJ8ihrk5nSbpBGpT4bDHiCFj" +
                                                              "RZ6yTrrdlLMqpgU4ftssbLCgE4PLdG0F5wi6GQWJaoajXoY7lPWvOqPgLOi6" +
                                                              "0NVVaLiNjYOCDTJszMhg8DtryZzDspqmqCu4wtGx5xEggKW1eUJzmiNqjoph" +
                                                              "ALULF1Gwmo2OgeupWSCt1sABDYoWV2TKbK1j6TDOkiTzyADdqJgCqnpuCLaE" +
                                                              "ogVBMs4JTmlx4JQ853NzZMOpx9UdahiFYM9pIils/42wqDOwaDfJEINAHIiF" +
                                                              "TX3x83jhqyfDCAHxggCxoPnuV249vLbz2puCZkkZml2pQ0SiSWkmNfedpbHe" +
                                                              "9VVsG3W6Zsrs8H2a8ygbtWYGijogzEKHI5uM2JPXdv/4S0cvkY/CqGEI1Uia" +
                                                              "UsiDH7VJWl6XFWJsJyoxMCXpIVRP1HSMzw+hWujHZZWI0V2ZjEnoEJqj8KEa" +
                                                              "jf8HE2WABTNRA/RlNaPZfR3THO8XdYRQLTyoCZ4VSPz4m6K90ZyWJ1EsYVVW" +
                                                              "teiooTH9zSggTgpsm4umwOsPR02tYIALRjUjG8XgBzliT4xns0SNju3bPqgo" +
                                                              "sm6SCHMv/bNiXGQazZsIhcDYS4OhrkCU7NCUNDGS0tnClsFbLyXfFm7EXN+y" +
                                                              "BUXdICsiZEW4rIiQFXFloVCIi5jPZIqzhJM4DDENoNrUO/bYzoMnu6vAifSJ" +
                                                              "OWBGRtrtSy4xN/BttE5KV9qbp1bc6H89jObEUTuWaAErLFdsNrKAQtJhK1Cb" +
                                                              "UpB2XPRf7kF/lrYMTSJpAJ9KWcDiUqeNE4ONUzTfw8HOTSwKo5UzQ9n9o2sX" +
                                                              "Jo7t+9p9YRT2Az4TWQ1YxZaPMph24LgnGOjl+Lac+PCTK+ef0NyQ92UQO/GV" +
                                                              "rGQ6dAedIGiepNS3HL+SfPWJHm72eoBkiiGEAO06gzJ8iDJgozPTpQ4UzmhG" +
                                                              "HitsyrZxA80Z2oQ7wr2zjffng1s0shBbAE+fFXP8zWYX6qxdJLyZ+VlAC47+" +
                                                              "D43pz/3qZ398gJvbThQtngw/RuiAB5wYs3YOQ22u2+4xCAG6Dy6MfvPczRP7" +
                                                              "uc8CxcpyAntYGwNQgiMEMz/55pH3f3tj5nrY9XMK2bmQgiKn6CjJxlHDLEqC" +
                                                              "tNXufgDcFMAB5jU9e1XwTzkj45RCWGD9s2VV/yt/PtUq/ECBEduN1t6ZgTv+" +
                                                              "uS3o6NsHPu3kbEISS66uzVwygdjzXM6bDQNPsn0Uj7277Jk38HOA/YC3pjxF" +
                                                              "OISGrFhnm+qgaM0sMGIhumZYdQU/6HV85X28fZAZifNDfG49a1aZ3oDxx6Sn" +
                                                              "cEpKp69/3Lzv49ducQ39lZfXP4axPiBckjWri8B+URDQdmAzB3QPXhv5cqty" +
                                                              "7TZwTABHCSDZ3GUAkhZ93mRRV9f++oevLzz4ThUKb0MNiobT2zAPTFQPEUHM" +
                                                              "HIBwUd/0sHCIiTpoWrmqqET5kgF2KF3lj3swr1N+QFPfW/SdDRenb3DP1AWP" +
                                                              "JQ4SL/UhMa/fXTC49N4Xfn7xG+cnRAXQWxkBA+s6/rFLSR3//d9LTM6xr0x1" +
                                                              "ElifiF5+dnFs40d8vQtCbHVPsTSXAZC7a++/lP9buLvmR2FUm0CtklUv78NK" +
                                                              "gYV2AmpE0y6ioab2zfvrPVHcDDgguzQIgB6xQfhzcyj0GTXrNwcQjxUYaCk8" +
                                                              "qywwWBVEvBDinUf4knt428eae22AqdUNGe5UJIAwjbMwhUUQeqxUsmOza5bY" +
                                                              "ZHQCd1n7RdbEhbCHynmsmLqHNWucLfFfTbCa8oKe65KIxd2ySgUvL9Znjp+d" +
                                                              "Tu96vl84Zbu/iByEO9KLv/jXTyIXfvdWmWqmnmr6vQoZJ4pHZhUT6QuDYX4X" +
                                                              "cH3qg7ln/vD9nuyWu6lF2FjnHaoN9r8LlOirHFnBrbxx/E+L92zMHbyLsqIr" +
                                                              "YM4gyxeGL7+1fbV0JswvPsLZSy5M/kUDfhdvMAjc8NQ9Pkdf6TjAPHawHfD0" +
                                                              "Ww7QXz61l/EdJ2FWWhpIE4G0IxAcT9BIlmj5iFWw3r+VC8zOkmL4kaYoqqYa" +
                                                              "RIHNbh6LlIkHpEiaMyN5Yt3EeWBIswTG/wDlbCCm8/EDjv48frrg2WTpv+kO" +
                                                              "phspRYJKS8ubjv3Nca7FWewzxRrIoI3cPjHZkMS9Ku+ag35W5lgOz6OWTo/e" +
                                                              "vTkqLb2TOZ6cxRwnWHOUoiZuDsvNAvY49v+wR5GiBlcCS/8dJd9wxHcH6aXp" +
                                                              "lrpF03t/yUHL+TbQBPCTKSiKN0F5+jW6QTIy16lJpCudv74OsVQhTUCZKzp8" +
                                                              "z6cE/RmKWoP0EE387aU7B/q4dMBKdLwkFyiqAhLWfUa3I7F/tnrSwHpOlkT+" +
                                                              "hlwPYEuhNgv504xzLgvudC6ezLTSB9T8I5sNqgXxmQ0urtM7Rx6/9fnnxU1E" +
                                                              "UvAUD5bGOKoVlyIHmFdU5GbzqtnRe3vu1fpVYcvP2sSGXSdf4nHCGLirzlxi" +
                                                              "caBMN3ucav39mQ2v/fRkzbuQG/ejEAZI219a8hT1AmTE/XE3J3o+0vL7w0Dv" +
                                                              "tyY3rs385Te8qEQlpWSQPildv/jYe2c6ZuCe0TiEqiGNkyKvxbZOqruJNG4k" +
                                                              "ULNsDhZhi8BFxsoQqiuo8pECGUrH0VzmvZh9fuN2sczZ7IyyeyxF3SXf2crc" +
                                                              "/qEAnyDGFq2gpnmqgiTqjvi+/tm5raDrgQXuiHOU80t1T0pbn2r5wen2qm0Q" +
                                                              "gT51vOxrzULKyZveD4JuIm0VGPYf+IXg+Td72KGzAfaGsjVmfRxb7nwdg0pf" +
                                                              "zFUl48O6btM2fKqLGPo2a14ssnGKQn3WaAD4rnL5V3iXNS//F4WtKSwcGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
