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
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO+NvG3/w5fJhgzFENuQuTkIragKBw4DJ2TgY" +
                                                              "kHo0HHN7c3cLe7vL7px9dpoWkCLIP5RSIKRK/JcjFEoCihq1lZqIKmqTKG2l" +
                                                              "JKRtWoVW7T9pU9SgqmlV+vVmZr/vzhSpOWln52bevDfvzXu/92Yv30TVpoE6" +
                                                              "iUojdFInZmRQpaPYMEk6pmDT3ANjSenpKvyXAx+NrA+jmgSam8PmsIRNsk0m" +
                                                              "StpMoGWyalKsSsQcISTNVowaxCTGOKaypibQAtkcyuuKLMl0WEsTRrAPG3HU" +
                                                              "hik15FSBkiGLAUXL4rCTKN9JdHNweiCOmiRNn3TJOzzkMc8Mo8y7skyKWuOH" +
                                                              "8DiOFqisROOySQeKBlqja8pkVtFohBRp5JCyzjLBzvi6EhN0X2359PbpXCs3" +
                                                              "wTysqhrl6pm7iakp4yQdRy3u6KBC8uYR9FVUFUeNHmKKeuK20CgIjYJQW1uX" +
                                                              "CnbfTNRCPqZxdajNqUaX2IYoWuFnomMD5y02o3zPwKGOWrrzxaDtckdboWWJ" +
                                                              "iufWRM8+faD15SrUkkAtsjrGtiPBJigISYBBST5FDHNzOk3SCdSmwmGPEUPG" +
                                                              "ijxlnXS7KWdVTAtw/LZZ2GBBJwaX6doKzhF0MwoS1QxHvQx3KOtfdUbBWdB1" +
                                                              "oaur0HAbGwcFG2TYmJHB4HfWkjmHZTVNUVdwhaNjzyNAAEtr84TmNEfUHBXD" +
                                                              "AGoXLqJgNRsdA9dTs0BarYEDGhQtrsiU2VrH0mGcJUnmkQG6UTEFVPXcEGwJ" +
                                                              "RQuCZJwTnNLiwCl5zufmyIZTj6s71DAKwZ7TRFLY/hthUWdg0W6SIQaBOBAL" +
                                                              "m/ri5/HCV0+GEQLiBQFiQfPdr9x6eG3ntTcFzZIyNLtSh4hEk9JMau47S2O9" +
                                                              "66vYNup0zZTZ4fs051E2as0MFHVAmIUORzYZsSev7f7xl45eIh+HUcMQqpE0" +
                                                              "pZAHP2qTtLwuK8TYTlRiYErSQ6ieqOkYnx9CtdCPyyoRo7syGZPQITRH4UM1" +
                                                              "Gv8PJsoAC2aiBujLakaz+zqmOd4v6gihWnhQEzwrkPjxN0V7ozktT6JYwqqs" +
                                                              "atFRQ2P6m1FAnBTYNhdNgdcfjppawQAXjGpGNorBD3LEnhjPZokaHdu3fVBR" +
                                                              "ZN0kEeZe+mfFuMg0mjcRCoGxlwZDXYEo2aEpaWIkpbOFLYO3Xkq+LdyIub5l" +
                                                              "C4q6QVZEyIpwWREhK+LKQqEQFzGfyRRnCSdxGGIaQLWpd+yxnQdPdleBE+kT" +
                                                              "c8CMjLTbl1xibuDbaJ2UrrQ3T6240f96GM2Jo3Ys0QJWWK7YbGQBhaTDVqA2" +
                                                              "pSDtuOi/3IP+LG0ZmkTSAD6VsoDFpU4bJwYbp2i+h4Odm1gURitnhrL7R9cu" +
                                                              "TBzb97X7wijsB3wmshqwii0fZTDtwHFPMNDL8W058dGnV84/obkh78sgduIr" +
                                                              "Wcl06A46QdA8SalvOX4l+eoTPdzs9QDJFEMIAdp1BmX4EGXARmemSx0onNGM" +
                                                              "PFbYlG3jBpoztAl3hHtnG+/PB7doZCG2AJ4+K+b4m80u1Fm7SHgz87OAFhz9" +
                                                              "HxrTn/vlz/7wADe3nShaPBl+jNABDzgxZu0chtpct91jEAJ0H14Y/ea5myf2" +
                                                              "c58FipXlBPawNgagBEcIZn7yzSMf/ObGzPWw6+cUsnMhBUVO0VGSjaOGWZQE" +
                                                              "aavd/QC4KYADzGt69qrgn3JGximFsMD6Z8uq/lf+dKpV+IECI7Ybrb0zA3f8" +
                                                              "c1vQ0bcP/K2TswlJLLm6NnPJBGLPczlvNgw8yfZRPPbusmfewM8B9gPemvIU" +
                                                              "4RAasmKdbaqDojWzwIiF6Jph1RX8oNfxlffx9kFmJM4P8bn1rFllegPGH5Oe" +
                                                              "wikpnb7+SfO+T167xTX0V15e/xjG+oBwSdasLgL7RUFA24HNHNA9eG3ky63K" +
                                                              "tdvAMQEcJYBkc5cBSFr0eZNFXV37qx++vvDgO1UovA01KBpOb8M8MFE9RAQx" +
                                                              "cwDCRX3Tw8IhJuqgaeWqohLlSwbYoXSVP+7BvE75AU19b9F3NlycvsE9Uxc8" +
                                                              "ljhIvNSHxLx+d8Hg0ntfeP/iN85PiAqgtzICBtZ1/GOXkjr+u7+XmJxjX5nq" +
                                                              "JLA+Eb387OLYxo/5eheE2OqeYmkuAyB3195/Kf/XcHfNj8KoNoFaJate3oeV" +
                                                              "AgvtBNSIpl1EQ03tm/fXe6K4GXBAdmkQAD1ig/Dn5lDoM2rWbw4gHisw0FJ4" +
                                                              "VllgsCqIeCHEO4/wJffwto8199oAU6sbMtypSABhGmdhCosg9FipZMdm1yyx" +
                                                              "yegE7rL2i6yJC2EPlfNYMXUPa9Y4W+K/mmA15QU91yURi7tllQpeXqzPHD87" +
                                                              "nd71fL9wynZ/ETkId6QXf/6vn0Qu/PatMtVMPdX0exUyThSPzCom0hcGw/wu" +
                                                              "4PrUh3PP/P77Pdktd1OLsLHOO1Qb7H8XKNFXObKCW3nj+B8X79mYO3gXZUVX" +
                                                              "wJxBli8MX35r+2rpTJhffISzl1yY/IsG/C7eYBC44al7fI6+0nGAeexgO+Dp" +
                                                              "txygv3xqL+M7TsKstDSQJgJpRyA4nqCRLNHyEatgvX8rF5idJcXwI01RVE01" +
                                                              "iAKb3TwWKRMPSJE0Z0byxLqJ88CQZgmM/wHK2UBM5+MHHP15/HTBs8nSf9Md" +
                                                              "TDdSigSVlpY3Hfub41yLs9hnijWQQRu5fWKyIYl7Vd41B/2szLEcnkctnR69" +
                                                              "e3NUWnonczw5izlOsOYoRU3cHJabBexx7P9hjyJFDa4Elv47Sr7hiO8O0kvT" +
                                                              "LXWLpvf+goOW822gCeAnU1AUb4Ly9Gt0g2RkrlOTSFc6f30dYqlCmoAyV3T4" +
                                                              "nk8J+jMUtQbpIZr420t3DvRx6YCV6HhJLlBUBSSs+4xuR2L/bPWkgfWcLIn8" +
                                                              "DbkewJZCbRbypxnnXBbc6Vw8mWmlD6j5RzYbVAviMxtcXKd3jjx+6/PPi5uI" +
                                                              "pOApHiyNcVQrLkUOMK+oyM3mVbOj9/bcq/WrwpaftYkNu06+xOOEMXBXnbnE" +
                                                              "4kCZbvY41foHMxte++nJmnchN+5HIQyQtr+05CnqBciI++NuTvR8pOX3h4He" +
                                                              "b01uXJv58695UYlKSskgfVK6fvGx9850zMA9o3EIVUMaJ0Vei22dVHcTadxI" +
                                                              "oGbZHCzCFoGLjJUhVFdQ5SMFMpSOo7nMezH7/MbtYpmz2Rll91iKuku+s5W5" +
                                                              "/UMBPkGMLVpBTfNUBUnUHfF9/bNzW0HXAwvcEeco55fqnpS2PtXyg9PtVdsg" +
                                                              "An3qeNnXmoWUkze9HwTdRNoqMOw/8AvB82/2sENnA+wNZWvM+ji23Pk6BpW+" +
                                                              "mKtKxod13aZteF8XMfRt1rxYZOMUhfqs0QDwXeXyr/Aua17+L/sg3DQcGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
