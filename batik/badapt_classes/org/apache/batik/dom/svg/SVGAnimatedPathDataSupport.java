package org.apache.batik.dom.svg;
public abstract class SVGAnimatedPathDataSupport {
    public static void handlePathSegList(org.w3c.dom.svg.SVGPathSegList p,
                                         org.apache.batik.parser.PathHandler h) {
        int n =
          p.
          getNumberOfItems(
            );
        h.
          startPath(
            );
        for (int i =
               0;
             i <
               n;
             i++) {
            org.w3c.dom.svg.SVGPathSeg seg =
              p.
              getItem(
                i);
            switch (seg.
                      getPathSegType(
                        )) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CLOSEPATH:
                    h.
                      closePath(
                        );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_MOVETO_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegMovetoAbs s =
                          (org.w3c.dom.svg.SVGPathSegMovetoAbs)
                            seg;
                        h.
                          movetoAbs(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_MOVETO_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegMovetoRel s =
                          (org.w3c.dom.svg.SVGPathSegMovetoRel)
                            seg;
                        h.
                          movetoRel(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoAbs s =
                          (org.w3c.dom.svg.SVGPathSegLinetoAbs)
                            seg;
                        h.
                          linetoAbs(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoRel s =
                          (org.w3c.dom.svg.SVGPathSegLinetoRel)
                            seg;
                        h.
                          linetoRel(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                            seg;
                        h.
                          curvetoCubicAbs(
                            s.
                              getX1(
                                ),
                            s.
                              getY1(
                                ),
                            s.
                              getX2(
                                ),
                            s.
                              getY2(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoCubicRel s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                            seg;
                        h.
                          curvetoCubicRel(
                            s.
                              getX1(
                                ),
                            s.
                              getY1(
                                ),
                            s.
                              getX2(
                                ),
                            s.
                              getY2(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs)
                            seg;
                        h.
                          curvetoQuadraticAbs(
                            s.
                              getX1(
                                ),
                            s.
                              getY1(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel)
                            seg;
                        h.
                          curvetoQuadraticRel(
                            s.
                              getX1(
                                ),
                            s.
                              getY1(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_ARC_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegArcAbs s =
                          (org.w3c.dom.svg.SVGPathSegArcAbs)
                            seg;
                        h.
                          arcAbs(
                            s.
                              getR1(
                                ),
                            s.
                              getR2(
                                ),
                            s.
                              getAngle(
                                ),
                            s.
                              getLargeArcFlag(
                                ),
                            s.
                              getSweepFlag(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_ARC_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegArcRel s =
                          (org.w3c.dom.svg.SVGPathSegArcRel)
                            seg;
                        h.
                          arcRel(
                            s.
                              getR1(
                                ),
                            s.
                              getR2(
                                ),
                            s.
                              getAngle(
                                ),
                            s.
                              getLargeArcFlag(
                                ),
                            s.
                              getSweepFlag(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_HORIZONTAL_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoHorizontalAbs s =
                          (org.w3c.dom.svg.SVGPathSegLinetoHorizontalAbs)
                            seg;
                        h.
                          linetoHorizontalAbs(
                            s.
                              getX(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_HORIZONTAL_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoHorizontalRel s =
                          (org.w3c.dom.svg.SVGPathSegLinetoHorizontalRel)
                            seg;
                        h.
                          linetoHorizontalRel(
                            s.
                              getX(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_VERTICAL_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoVerticalAbs s =
                          (org.w3c.dom.svg.SVGPathSegLinetoVerticalAbs)
                            seg;
                        h.
                          linetoVerticalAbs(
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_VERTICAL_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegLinetoVerticalRel s =
                          (org.w3c.dom.svg.SVGPathSegLinetoVerticalRel)
                            seg;
                        h.
                          linetoVerticalRel(
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs)
                            seg;
                        h.
                          curvetoCubicSmoothAbs(
                            s.
                              getX2(
                                ),
                            s.
                              getY2(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel)
                            seg;
                        h.
                          curvetoCubicSmoothRel(
                            s.
                              getX2(
                                ),
                            s.
                              getY2(
                                ),
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothAbs s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothAbs)
                            seg;
                        h.
                          curvetoQuadraticSmoothAbs(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
                    {
                        org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothRel s =
                          (org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothRel)
                            seg;
                        h.
                          curvetoQuadraticSmoothRel(
                            s.
                              getX(
                                ),
                            s.
                              getY(
                                ));
                        break;
                    }
            }
        }
        h.
          endPath(
            );
    }
    public SVGAnimatedPathDataSupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Yb2wcRxWfO/93bJ99iZ2Qxk5iO5GcpneN0kAjh1LbseML" +
                                                              "Z8ey00h1aC5ze3N3G+/tbmbn7LODoa2EkiIRouC2AVF/clVAbVMQFSBoZVSJ" +
                                                              "tiogtURAQU2R+ED4E9EIqXwIUN7M7N7u7fkclQ+cdHN7M2/e//m9N/v8TVRj" +
                                                              "UdRFdBZh8yaxIsM6m8DUIqkhDVvWcZhLKE9X4X+cujF+MIhqp1FLFltjCrbI" +
                                                              "iEq0lDWNOlXdYlhXiDVOSIrvmKDEInQWM9XQp1G7asVypqYqKhszUoQTnMA0" +
                                                              "jtowY1RN5hmJ2QwY6oyDJlGhSXTAv9wfR02KYc675Fs85EOeFU6Zc2VZDLXG" +
                                                              "z+BZHM0zVYvGVYv1Fyi62zS0+YxmsAgpsMgZ7YDtgqPxA2Uu6H4p9OHtS9lW" +
                                                              "4YKNWNcNJsyzJollaLMkFUchd3ZYIznrLPoCqoqjDR5ihnrjjtAoCI2CUMda" +
                                                              "lwq0byZ6PjdkCHOYw6nWVLhCDO0sZWJiinM2mwmhM3CoZ7btYjNYu6NorbSy" +
                                                              "zMQn744uPX2q9XtVKDSNQqo+xdVRQAkGQqbBoSSXJNQaSKVIahq16RDsKUJV" +
                                                              "rKkLdqTDlprRMctD+B238Mm8SaiQ6foK4gi20bzCDFo0Ly0Syv5Xk9ZwBmzt" +
                                                              "cG2VFo7weTCwUQXFaBpD3tlbqmdUPcXQdv+Ooo29nwUC2FqXIyxrFEVV6xgm" +
                                                              "UFimiIb1THQKUk/PAGmNAQlIGdpakSn3tYmVGZwhCZ6RProJuQRUDcIRfAtD" +
                                                              "7X4ywQmitNUXJU98bo4funhOH9WDKAA6p4iicf03wKYu36ZJkiaUwDmQG5v2" +
                                                              "xJ/CHa9cCCIExO0+Yknzg8/fenBv1+obkuauNWiOJc8QhSWUlWTL29uG+g5W" +
                                                              "cTXqTcNSefBLLBenbMJe6S+YgDAdRY58MeIsrk7+7OFHv0P+GkSNMVSrGFo+" +
                                                              "B3nUphg5U9UIPUJ0QjEjqRhqIHpqSKzHUB08x1WdyNlj6bRFWAxVa2Kq1hD/" +
                                                              "wUVpYMFd1AjPqp42nGcTs6x4LpgIoVb4onb47kfyI34ZSkezRo5EsYJ1VTei" +
                                                              "E9Tg9ltRQJwk+DYbTULWz0QtI08hBaMGzUQx5EGW2AspIxe1ZiGVThwZ0NUc" +
                                                              "t2ICBB/GDE/lTdOgADmQb+b/TVKB27xxLhCAcGzzg4EG52jU0FKEJpSl/ODw" +
                                                              "rRcTb8lE44fD9hZD+0F4RAqPCOEREB4B4ZHKwlEgIGRu4krI8EPwZgAGAIeb" +
                                                              "+qYeOXr6QncV5J05Vw2e56TdJfVoyMUKB+ATytVw88LO6/teC6LqOApjheWx" +
                                                              "xsvLAM0AcCkz9tluSkKlcgvGDk/B4JWOGgpJAV5VKhw2l3pjllA+z9AmDwen" +
                                                              "nPGDG61cTNbUH61emXvsxBfvDaJgaY3gImsA3vj2CY7sRQTv9WPDWnxD5298" +
                                                              "ePWpRcNFiZKi49TKsp3chm5/Vvjdk1D27MAvJ15Z7BVubwAUZxhOHQS5yy+j" +
                                                              "BIT6HUDnttSDwWmD5rDGlxwfN7IsNebcGZGubXxol5nLU8inoKgFn54yn/nt" +
                                                              "L/+8X3jSKRshT72fIqzfA1WcWViAUpubkccpIUD33pWJrz158/xJkY5A0bOW" +
                                                              "wF4+DgFEQXTAg1964+y7719fuRZ0U5hBrc4noeUpCFs2fQSfAHz/w78cXviE" +
                                                              "hJnwkI11O4pgZ3LJu13dAPY0AASeHL0P6ZCGalrFSY3w8/Ov0K59L//tYqsM" +
                                                              "twYzTrbsvTMDd/4Tg+jRt079s0uwCSi87Lr+c8kklm90OQ9Qiue5HoXH3un8" +
                                                              "+uv4GagKgMSWukAEuCLhDyQCeED44l4x3udb+xQfdlneHC89Rp72KKFcuvZB" +
                                                              "84kPXr0ltC3tr7xxH8Nmv8wiGQUQtg/ZQwnY89UOk4+bC6DDZj9QjWIrC8zu" +
                                                              "Wx3/XKu2ehvEToNYBcDYOkYBMgslqWRT19T97qevdZx+uwoFR1CjZuDUCBYH" +
                                                              "DjVAphMrC2hbMD/zoNRjrt4pRQVU5qGyCR6F7WvHdzhnMhGRhR9u/v6h55av" +
                                                              "i7Q0JY+7vAx3i7GPD3vFfJA/3sNQPU4COoCyhaLfxCe0jt9K2VPUWamPET3Y" +
                                                              "yuNLy6ljz+6T3Ua4tDcYhtb3hV//++eRK394c40S1MAM8x6NzBLNI5MXjc6S" +
                                                              "ojEmWjwXuN5rufzHH/VmBj9OveBzXXeoCPz/djBiT2X896vy+uN/2Xr8gezp" +
                                                              "jwH9233u9LP89tjzbx7ZrVwOin5Won5ZH1y6qd/rWBBKCTTuOjeTzzSLg9NT" +
                                                              "TIAwD2wMvgftBDjoPzgSo9dNrFpLXCnctBLp0rYOVx9kBCU78X8L1Bzejczt" +
                                                              "V7xNCG8+pkiGnwCHrKesaTH53YdGOO0o1lOAvkL9h9dBqAQfJhlqy4oNXjEU" +
                                                              "9a1zk6RqDsrOrN2LRxfD789888YLMvP9jbuPmFxY+vJHkYtL8hTI201P2QXD" +
                                                              "u0fecITCrXyI8LO4cz0pYsfIn64u/vhbi+eDtrFHGaqeNVR5Q7qfD1MyaIf+" +
                                                              "R7ziE4NmAe5RlftEDmpbyi6p8mKlvLgcqt+8/NBvxPEtXn6a4CCm85rmyWNv" +
                                                              "TtealKRVYVGTLASm+OG3lUqNLENVMAoLcpL6LDR9a1EDJYxeSsZQq5+SoRrx" +
                                                              "66WbY6jRpYNzIR+8JAvAHUj44znTSeRWAfn8ghqRt7FCoBzW75ct0x3C5YHq" +
                                                              "npLkFS8THJTJy9cJ0G0vHx0/d+uTz8oeS9HwwoK4fMJdWnZyRaTaWZGbw6t2" +
                                                              "tO92y0sNu5xkK+nxvLqJpAFsF/3QVl/TYfUWe493Vw69+osLte/AMTmJApih" +
                                                              "jSc9V3npKehc8lAiTsbdIuF5GSW6of6+b8w/sDf999+LimkXlW2V6RPKtece" +
                                                              "+dXlLSvQNW2IoRo4R6QwjRpV6/C8PkmUWTqNmlVruAAqAhcVazFUn9fVs3kS" +
                                                              "S8VRC09izF8zCL/Y7mwuzvLmm6Hu8uNefmWB7mKO0EEjr6cEdkNVcWdK3nI4" +
                                                              "YA8nzrfBnSmGclO57Qnl8BOhn1wKV43AQSwxx8u+zsoni4XE++LDrSw2Oske" +
                                                              "uCoRHzNNpyeu+64pM/4rkobPwyVyjz3LcSUgiz7/e0mw+6p45MPl/wI0MgKJ" +
                                                              "0xQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
