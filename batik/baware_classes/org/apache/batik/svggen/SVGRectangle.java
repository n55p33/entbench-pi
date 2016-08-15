package org.apache.batik.svggen;
public class SVGRectangle extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGLine svgLine;
    public SVGRectangle(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        svgLine =
          new org.apache.batik.svggen.SVGLine(
            generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Rectangle2D rect) {
        return toSVG(
                 (java.awt.geom.RectangularShape)
                   rect);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.RoundRectangle2D rect) {
        org.w3c.dom.Element svgRect =
          toSVG(
            (java.awt.geom.RectangularShape)
              rect);
        if (svgRect !=
              null &&
              svgRect.
              getTagName(
                ) ==
              SVG_RECT_TAG) {
            svgRect.
              setAttributeNS(
                null,
                SVG_RX_ATTRIBUTE,
                doubleString(
                  java.lang.Math.
                    abs(
                      rect.
                        getArcWidth(
                          ) /
                        2)));
            svgRect.
              setAttributeNS(
                null,
                SVG_RY_ATTRIBUTE,
                doubleString(
                  java.lang.Math.
                    abs(
                      rect.
                        getArcHeight(
                          ) /
                        2)));
        }
        return svgRect;
    }
    private org.w3c.dom.Element toSVG(java.awt.geom.RectangularShape rect) {
        if (rect.
              getWidth(
                ) >
              0 &&
              rect.
              getHeight(
                ) >
              0) {
            org.w3c.dom.Element svgRect =
              generatorContext.
                domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_RECT_TAG);
            svgRect.
              setAttributeNS(
                null,
                SVG_X_ATTRIBUTE,
                doubleString(
                  rect.
                    getX(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_Y_ATTRIBUTE,
                doubleString(
                  rect.
                    getY(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_WIDTH_ATTRIBUTE,
                doubleString(
                  rect.
                    getWidth(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_HEIGHT_ATTRIBUTE,
                doubleString(
                  rect.
                    getHeight(
                      )));
            return svgRect;
        }
        else {
            if (rect.
                  getWidth(
                    ) ==
                  0 &&
                  rect.
                  getHeight(
                    ) >
                  0) {
                java.awt.geom.Line2D line =
                  new java.awt.geom.Line2D.Double(
                  rect.
                    getX(
                      ),
                  rect.
                    getY(
                      ),
                  rect.
                    getX(
                      ),
                  rect.
                    getY(
                      ) +
                    rect.
                    getHeight(
                      ));
                return svgLine.
                  toSVG(
                    line);
            }
            else
                if (rect.
                      getWidth(
                        ) >
                      0 &&
                      rect.
                      getHeight(
                        ) ==
                      0) {
                    java.awt.geom.Line2D line =
                      new java.awt.geom.Line2D.Double(
                      rect.
                        getX(
                          ),
                      rect.
                        getY(
                          ),
                      rect.
                        getX(
                          ) +
                        rect.
                        getWidth(
                          ),
                      rect.
                        getY(
                          ));
                    return svgLine.
                      toSVG(
                        line);
                }
            return null;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYa4wUxxHu3ePed9yDxx2vA44DxMO7xoZE5DAYlgMO7z3E" +
                                                              "YaIsMUvvbO/uwOzMMNNzt3e2ExsrgiiSRTDG2DL8wkJGxDiJnYcUW0RWYltO" +
                                                              "ItkmDycyef1x4qAYRXGikFdVz8zO7OzuEaR4pemZ7a6q7qqu+qq6L10ntaZB" +
                                                              "epjKI3xSZ2ZkQOWj1DBZOqZQ09wLfUnpqRr6lwMfDG8Mk7oEmZmj5pBETbZD" +
                                                              "ZkraTJBFsmpyqkrMHGYsjRyjBjOZMU65rKkJMkc2B/O6IksyH9LSDAn2USNO" +
                                                              "OijnhpyyOBt0BHCyKA4riYqVRLcGh/vjpEXS9EmPvNtHHvONIGXem8vkpD1+" +
                                                              "iI7TqMVlJRqXTd5fMMgaXVMms4rGI6zAI4eUDY4Jdsc3lJmg98W2j2+eyLUL" +
                                                              "E8yiqqpxoZ65h5maMs7ScdLm9Q4oLG8eIV8gNXHS7CPmpC/uThqFSaMwqaut" +
                                                              "RwWrb2WqlY9pQh3uSqrTJVwQJ0tLhejUoHlHzKhYM0ho4I7ughm0XVLU1tay" +
                                                              "TMUn10RPPXWg/Rs1pC1B2mR1DJcjwSI4TJIAg7J8ihnm1nSapROkQ4XNHmOG" +
                                                              "TBV5ytnpTlPOqpRbsP2uWbDT0pkh5vRsBfsIuhmWxDWjqF5GOJTzrzaj0Czo" +
                                                              "OtfT1dZwB/aDgk0yLMzIUPA7h2XGYVlNc7I4yFHUse8+IADW+jzjOa041QyV" +
                                                              "QgfptF1EoWo2Ogaup2aBtFYDBzQ4mV9VKNpap9JhmmVJ9MgA3ag9BFSNwhDI" +
                                                              "wsmcIJmQBLs0P7BLvv25Przp8QfVXWqYhGDNaSYpuP5mYOoJMO1hGWYwiAOb" +
                                                              "sWV1/DSd+8rxMCFAPCdAbNN8+6Eb967tufKGTbOgAs1I6hCTeFI6n5r59sLY" +
                                                              "qo01uIwGXTNl3PwSzUWUjToj/QUdEGZuUSIORtzBK3t++LlHLrIPw6RpkNRJ" +
                                                              "mmLlwY86JC2vywozdjKVGZSz9CBpZGo6JsYHST18x2WV2b0jmYzJ+CCZoYiu" +
                                                              "Ok38BxNlQASaqAm+ZTWjud865TnxXdAJIfXwkBZ4lhH7J96cfDaa0/IsSiWq" +
                                                              "yqoWHTU01N+MAuKkwLa5aAq8/nDU1CwDXDCqGdkoBT/IMXdgPJtlanRs3849" +
                                                              "wAdOpbAIOpj+yYkuoFazJkIhMPjCYLgrECm7NCXNjKR0yto2cOOF5Fu2K6H7" +
                                                              "O/YAgILZIvZsETFbxJ4t4p+NhEJiktk4q72jsB+HIbIBWltWjT2w++Dx3hpw" +
                                                              "JX1iBhgTSXtLUkzMC38Xs5PS5c7WqaXX1r0WJjPipJNK3KIKZoytRhawSDrs" +
                                                              "hGtLCpKPlwOW+HIAJi9Dk1gaIKhaLnCkNGjjzMB+Tmb7JLgZCmMxWj0/VFw/" +
                                                              "uXJm4tF9X7wzTMKlsI9T1gJiIfsognURlPuC4V5JbtuxDz6+fPphzQv8kjzi" +
                                                              "pr8yTtShN+gGQfMkpdVL6MvJVx7uE2ZvBGDmFAIJMK8nOEcJrvS7GI26NIDC" +
                                                              "Gc3IUwWHXBs38ZyhTXg9wj87xPdscItmDLQueNY6kSfeODpXx7bL9mf0s4AW" +
                                                              "IgfcM6af/cVP/nC3MLebLtp8eX6M8X4fRKGwTgFGHZ7b7jUYA7r3z4w+8eT1" +
                                                              "Y/uFzwLFskoT9mEbA2iCLQQzf+mNI+/9+tr5q2HPzznkaCsFpU6hqCT2k6Zp" +
                                                              "lITZVnjrAYhTIMrQa/ruV8E/5YxMUwrDwPpn2/J1L//p8XbbDxTocd1o7a0F" +
                                                              "eP3ztpFH3jrwtx4hJiRhivVs5pHZuD3Lk7zVMOgkrqPw6DuLnn6dnoUMAKhr" +
                                                              "ylNMAGnIiXVcVDcna6YBEgfXNcOpLsRGbxCcd4p2PRpJyCNibCM2y01/wJTG" +
                                                              "pK98Skonrn7Uuu+jV28IDUvrL79/DFG933ZJbFYUQHxXENB2UTMHdOuvDH++" +
                                                              "XblyEyQmQKIEsGyOGIClhRJvcqhr63/5/dfmHny7hoR3kCZFo+kdVAQmaYSI" +
                                                              "YGYOYLigb7nXdoiJBmjahaqkTPmyDtyUxZW3eyCvc7FBU9/pemnThXPXhGfq" +
                                                              "towFRSReWILEoor3wODiu5/+6YWvnp6w64BV1REwwNf9jxEldfR3fy8zucC+" +
                                                              "CjVKgD8RvfTs/NjmDwW/B0LI3Vcoz2YA5B7vXRfzfw331v0gTOoTpF1yquZ9" +
                                                              "VLEwtBNQKZpuKQ2Vdcl4adVnlzj9RZBdGARA37RB+POyKHwjNX63BhAPywyy" +
                                                              "EJ6VDhisDCJeiIiP+wTLStGuxuYOF2DqdUOGkxULIEzzNEKBCUIPCyY3NhdP" +
                                                              "E5tIZ+Mutp/BJm5Pdk8lj7WHVmKzprgk8asL1lR+0PNckmDcLapW9oqS/fzR" +
                                                              "U+fSI8+ts52ys7SUHICT0td+9q8fRc785s0K9Uwj1/Q7FDbOFN+cNThlSRgM" +
                                                              "iROB51Pvzzz5++/2ZbfdTi2CfT23qDbw/2JQYnX1yAou5fWjf5y/d3Pu4G2U" +
                                                              "FYsD5gyKfH7o0ps7V0gnw+L4Yzt72bGplKm/1MWbDAbnPHVviaMvKzrALNzY" +
                                                              "bnjWOw6wvnJqr+A7xYRZjTWQJgJpZ57ARjrBI1mm5SPFkvWu7WLK7DRJRmxq" +
                                                              "ipNarkEcuAJnYaxM3C1F0iAOD/bMOZGL0JCmCY3/AcyxI6aL/gPlxtviWGDL" +
                                                              "7RuvGuv0xusJGE+z1HTQgoVpLPgQNqZrQfyT90zFPwFTCbCZB8+Io+/ILUw1" +
                                                              "XA6b1Vhvz1S2lSyFGmM5qjMx77FpTPUVbI5WMdVj/w9TFThp8R/asHLoLrsE" +
                                                              "si8upBfOtTV0nbv/5wLvipcLLYBcGUtR/LnN912nGywjC3Va7Eyni9cTnHRV" +
                                                              "yTBQIdsfYtUnbfrTnLQH6cEy4u2ne5qTJo8ORNkffpJnOakBEvw8q7t7tW66" +
                                                              "UtSgek6W7NQPZQLgNIeyLlSaoYo7M+dWO+NLastKMF7c0rl4bNn3dHDmPbd7" +
                                                              "+MEbn3rOPsRICp2aQinNcVJvn6eKmL60qjRXVt2uVTdnvti4POy4WIe9YC8C" +
                                                              "Fvj8Lwa+rKNLzA9U+GZfsdB/7/ymV398vO4dSKv7SYgCFu4vr5YKugXJdH/c" +
                                                              "S6e+W15x9Ohf9czk5rWZP/9K1KOkrAoN0ielqxceePdk93k4ojQPklqoAFhB" +
                                                              "lHHbJ1Vw53EjQVplc6AASwQpMlUGSYOlykcsNpiOk5novRTv74RdHHO2Fnvx" +
                                                              "CMxJb9lFXYWLA6jdJ5ixDWFQZDnIv15PyfWhmxYtXQ8weD3FrZxdrntS2v7l" +
                                                              "tu+d6KzZARFYoo5ffL1ppYop13+j6OXgdhvg/gO/EDz/xgc3HTvwDRVvzLld" +
                                                              "W1K8XoNDgj1Wk4wP6bpL2/Rb3Y6hy9h8vYD9nIRWO70+VMS/L4n5vyk+sfnW" +
                                                              "fwEhPo95XRgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qB/cIoFNa9bBvoRd27br0ax41cFxSf47d/Lm4ehp5uFxFZTtRB+80eVQvgv9" +
       "xDufflaiP1na2TvmA7vdWwPH/QVTjmTzCKnTgNKTN95xU/nd2OHx01fe+S/3" +
       "s2/Q3vISDuIfPsHnSZK/Qz33td6rxd/cgU4fHEZdc2t3HOnK8SOoC54chJ7N" +
       "HjuIevBAs3dnGrsPPNU9zVavfxh+/VOo3Aq2c3/iFPXEqewr8+MSIQ52Vdmx" +
       "dg+uR8pYjv22m5zB/lpWpAF0NnAmXG+f4N3ZYVVcEXclQC67Upb3bn9zA3vr" +
       "TzoWODpI3hBfq5E37mnkjT8TjTx0QiNOaEsn1fKBm6jlQ1nx3n21ZB/vOpT/" +
       "fT+F/C/PGl8JHnpPfvqlyt/5/8i/FT00BW+iCa6ck/j4TeT/7ax45gbyf/Sl" +
       "yL8JoNuOXtll9w/3XfMXgO21tfi5Zy/ecu+z07/Ob60OrpZvJaFblNA0jx79" +
       "Hqmfcz1Z0XO2b90eBLv569MBdO8NDl2zo9C8krP7qS387wbQpZPwQAP5+yjc" +
       "5wLowiEcILWtHAX5vQA6DUCy6hfd/Tkp3ezuxBNcTRe3J+OoY0eyF8je5tTx" +
       "yHswA3f9pBk4EqwfPxZi8/9o7IfDcPsvjavi558lhm99of7J7a2baAppmlG5" +
       "hYTOby8AD0Lqozektk/rXP+JF+/4wq2v2g//d2wZPjTrI7w9fP0rro7lBvml" +
       "VPqH9/7+6z717LfzY9//BU0bFOk8IwAA");
}
