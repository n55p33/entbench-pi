package org.apache.batik.svggen;
public class SVGArc extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGLine svgLine;
    private org.apache.batik.svggen.SVGEllipse svgEllipse;
    public SVGArc(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Arc2D arc) { double ext =
                                                                  arc.
                                                                  getAngleExtent(
                                                                    );
                                                                double width =
                                                                  arc.
                                                                  getWidth(
                                                                    );
                                                                double height =
                                                                  arc.
                                                                  getHeight(
                                                                    );
                                                                if (width ==
                                                                      0 ||
                                                                      height ==
                                                                      0) {
                                                                    java.awt.geom.Line2D line =
                                                                      new java.awt.geom.Line2D.Double(
                                                                      arc.
                                                                        getX(
                                                                          ),
                                                                      arc.
                                                                        getY(
                                                                          ),
                                                                      arc.
                                                                        getX(
                                                                          ) +
                                                                        width,
                                                                      arc.
                                                                        getY(
                                                                          ) +
                                                                        height);
                                                                    if (svgLine ==
                                                                          null) {
                                                                        svgLine =
                                                                          new org.apache.batik.svggen.SVGLine(
                                                                            generatorContext);
                                                                    }
                                                                    return svgLine.
                                                                      toSVG(
                                                                        line);
                                                                }
                                                                if (ext >=
                                                                      360 ||
                                                                      ext <=
                                                                      -360) {
                                                                    java.awt.geom.Ellipse2D ellipse =
                                                                      new java.awt.geom.Ellipse2D.Double(
                                                                      arc.
                                                                        getX(
                                                                          ),
                                                                      arc.
                                                                        getY(
                                                                          ),
                                                                      width,
                                                                      height);
                                                                    if (svgEllipse ==
                                                                          null) {
                                                                        svgEllipse =
                                                                          new org.apache.batik.svggen.SVGEllipse(
                                                                            generatorContext);
                                                                    }
                                                                    return svgEllipse.
                                                                      toSVG(
                                                                        ellipse);
                                                                }
                                                                org.w3c.dom.Element svgPath =
                                                                  generatorContext.
                                                                    domFactory.
                                                                  createElementNS(
                                                                    SVG_NAMESPACE_URI,
                                                                    SVG_PATH_TAG);
                                                                java.lang.StringBuffer d =
                                                                  new java.lang.StringBuffer(
                                                                  64);
                                                                java.awt.geom.Point2D startPt =
                                                                  arc.
                                                                  getStartPoint(
                                                                    );
                                                                java.awt.geom.Point2D endPt =
                                                                  arc.
                                                                  getEndPoint(
                                                                    );
                                                                int type =
                                                                  arc.
                                                                  getArcType(
                                                                    );
                                                                d.
                                                                  append(
                                                                    PATH_MOVE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      startPt.
                                                                        getX(
                                                                          )));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      startPt.
                                                                        getY(
                                                                          )));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    PATH_ARC);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      width /
                                                                        2));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      height /
                                                                        2));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    '0');
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                if (ext >
                                                                      0) {
                                                                    if (ext >
                                                                          180)
                                                                        d.
                                                                          append(
                                                                            '1');
                                                                    else
                                                                        d.
                                                                          append(
                                                                            '0');
                                                                    d.
                                                                      append(
                                                                        SPACE);
                                                                    d.
                                                                      append(
                                                                        '0');
                                                                }
                                                                else {
                                                                    if (ext <
                                                                          -180)
                                                                        d.
                                                                          append(
                                                                            '1');
                                                                    else
                                                                        d.
                                                                          append(
                                                                            '0');
                                                                    d.
                                                                      append(
                                                                        SPACE);
                                                                    d.
                                                                      append(
                                                                        '1');
                                                                }
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      endPt.
                                                                        getX(
                                                                          )));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      endPt.
                                                                        getY(
                                                                          )));
                                                                if (type ==
                                                                      java.awt.geom.Arc2D.
                                                                        CHORD) {
                                                                    d.
                                                                      append(
                                                                        PATH_CLOSE);
                                                                }
                                                                else
                                                                    if (type ==
                                                                          java.awt.geom.Arc2D.
                                                                            PIE) {
                                                                        double cx =
                                                                          arc.
                                                                          getX(
                                                                            ) +
                                                                          width /
                                                                          2;
                                                                        double cy =
                                                                          arc.
                                                                          getY(
                                                                            ) +
                                                                          height /
                                                                          2;
                                                                        d.
                                                                          append(
                                                                            PATH_LINE_TO);
                                                                        d.
                                                                          append(
                                                                            SPACE);
                                                                        d.
                                                                          append(
                                                                            doubleString(
                                                                              cx));
                                                                        d.
                                                                          append(
                                                                            SPACE);
                                                                        d.
                                                                          append(
                                                                            doubleString(
                                                                              cy));
                                                                        d.
                                                                          append(
                                                                            SPACE);
                                                                        d.
                                                                          append(
                                                                            PATH_CLOSE);
                                                                    }
                                                                svgPath.
                                                                  setAttributeNS(
                                                                    null,
                                                                    SVG_D_ATTRIBUTE,
                                                                    d.
                                                                      toString(
                                                                        ));
                                                                return svgPath;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwUxxWfO+Pvb/NhF7ANxlAZyF0IoRWY0JjDBpOzcTFx" +
       "1aPhmNubu1u8t7vsztlnp6QBpYL+E1FKCI0SV5UcoSKaRFWjtlITuYraJEpb" +
       "KQn9SKvQqv0nbYoaVDX9oF9vZvb7fEb5oyft7NzMe2/mvXnv997stZuo0jRQ" +
       "F1FphM7oxIwMqnQMGyZJxxRsmkdgLCk9WYH/cuy90Z1hVJVATTlsjkjYJEMy" +
       "UdJmAnXKqkmxKhFzlJA04xgziEmMKUxlTU2glbI5nNcVWZLpiJYmjGACG3HU" +
       "iik15FSBkmFLAEWdcdhJlO8kOhCc7o+jBknTZ1zyDg95zDPDKPPuWiZFLfET" +
       "eApHC1RWonHZpP1FA23RNWUmq2g0Qoo0ckLZYZngYHxHiQl6Xmj+8Pb5XAs3" +
       "wXKsqhrl6pmHiakpUyQdR83u6KBC8uZJ9AiqiKN6DzFFvXF70SgsGoVFbW1d" +
       "Kth9I1EL+ZjG1aG2pCpdYhuiaL1fiI4NnLfEjPE9g4QaaunOmUHbdY62QssS" +
       "FZ/YEr345LGWb1Wg5gRqltVxth0JNkFhkQQYlORTxDAH0mmSTqBWFQ57nBgy" +
       "VuRZ66TbTDmrYlqA47fNwgYLOjH4mq6t4BxBN6MgUc1w1Mtwh7L+VWYUnAVd" +
       "V7m6Cg2H2DgoWCfDxowMBr+zWJZNymqaou4gh6Nj7wNAAKzVeUJzmrPUMhXD" +
       "AGoTLqJgNRsdB9dTs0BaqYEDGhStLiuU2VrH0iTOkiTzyADdmJgCqlpuCMZC" +
       "0cogGZcEp7Q6cEqe87k5uvvxh9UDahiFYM9pIils//XA1BVgOkwyxCAQB4Kx" +
       "YXP8El710rkwQkC8MkAsaL7z+Vv3b+1aeE3QrFmE5lDqBJFoUppPNb25Nta3" +
       "s4Jto0bXTJkdvk9zHmVj1kx/UQeEWeVIZJMRe3Lh8I8+++hV8n4Y1Q2jKklT" +
       "Cnnwo1ZJy+uyQoz9RCUGpiQ9jGqJmo7x+WFUDf24rBIxeiiTMQkdRssUPlSl" +
       "8f9gogyIYCaqg76sZjS7r2Oa4/2ijhCqhgc1wNOLxI+/Kfp0NKflSRRLWJVV" +
       "LTpmaEx/MwqIkwLb5qIp8PrJqKkVDHDBqGZkoxj8IEfsialslqjR8Yn9A4YU" +
       "Ya6l/z+EFpkmy6dDITDy2mCIKxAdBzQlTYykdLGwd/DWc8k3hPswl7dsQFEX" +
       "rBMR60T4OhGxTkSsg0IhLn4FW0+cH1h/EuIYgLShb/yhg8fP9VSA4+jTy8B0" +
       "jLTHl1BibrDbCJ2Unm9rnF1/Y9srYbQsjtqwRAtYYflhwMgC8kiTVnA2pCDV" +
       "uIi/zoP4LFUZmkTSADjlkN+SUqNNEYONU7TCI8HORyzyouWzwaL7RwuXp09P" +
       "fOHuMAr7QZ4tWQn4xNjHGDQ7ENwbDO7F5Daffe/D5y+d0tww92UNO9mVcDId" +
       "eoIOEDRPUtq8Dr+YfOlULzd7LcAwxRA2gHBdwTV8KNJvIzLTpQYUzmhGHits" +
       "yrZxHc0Z2rQ7wj2zlfdXgFvUs7BqhWe7FWf8zWZX6axtF57M/CygBUf8+8b1" +
       "Z3750z9s5+a2k0OzJ6uPE9rvASQmrI1DT6vrtkcMQoDu3ctjX3ni5tmj3GeB" +
       "YsNiC/ayNgZABEcIZv7iayff+c2N+eth188pZORCCgqboqMkG0d1SygJq21y" +
       "9wOApkD8M6/pfVAF/5QzMk4phAXWv5o3bnvxT4+3CD9QYMR2o613FuCOf2wv" +
       "evSNY3/r4mJCEkuors1cMoHSy13JA4aBZ9g+iqff6vzqq/gZwHvAWFOeJRw2" +
       "Q1ass011ULRlCQixUFwzrFqCH/QOznk3b+9lRuLyEJ/byZqNpjdg/DHpKZaS" +
       "0vnrHzROfPDyLa6hv9ry+scI1vuFS7JmUxHEtwcB7QA2c0B378Lo51qUhdsg" +
       "MQESJYBi85ABKFr0eZNFXVn9qx+8sur4mxUoPITqFA2nhzAPTFQLEUHMHABw" +
       "Uf/U/cIhpmugaeGqohLlSwbYoXQvftyDeZ3yA5r9bvu3d1+Zu8E9Uxcy1nD+" +
       "MMsJPiTmNbsLBlff/uTPrnz50rTI+n3lETDA1/HPQ0rqzO/+XmJyjn2LVCQB" +
       "/kT02tOrY3ve5/wuCDHu3mJpHgMgd3nvuZr/a7in6odhVJ1ALZJVI09gpcBC" +
       "OwF1oWkXzlBH++b9NZ4oaPodkF0bBEDPskH4c/Mn9Bk16zcGEI8VFWgtPH0W" +
       "GPQFES+EeOcBzvJx3m5mzV02wFTrhgz3KBJAmPolhAIThB4rj+zY7F4iNhmd" +
       "wF3W7mJNXCx2X1mPHfRr2ANPxNpMpIyGE0JD1oyWqlKOm6I62Omgosi66WjT" +
       "s4Q2FmlAoc8soVDR3dgWZ2P8VxUsCb0o7sYYYkDSWa5q5zeO+TMX59KHnt0m" +
       "oqzNXwkPwkXvmz//948jl3/7+iKlWS3V9LsUMkUUz5qswur0xfUIv9C4QfJu" +
       "04Xff683u/ejFFdsrOsO5RP73w1KbC4PFcGtvHrmj6uP7Mkd/wh1UnfAnEGR" +
       "3xi59vr+TdKFML+9iegtufX5mfr9MVtnELimqkd8kbvBcYDl7GA74NllOcCu" +
       "xWuVRXzHqQDKsQbyXiCPigyMp2kkS7Q8ZGHpnn18MX2JfMkrg0mKKqkGQeCI" +
       "YoEyvV2KpEEQ+yJBrE8JPCiUO0X50nmJDcT0IpRA4o7AElVHyRcGcSuWnptr" +
       "rmmfe/AX3Budm2sD+FWmoCheKPX0q3SDZGSuX4MAVp2/HqGovQwEwG5Eh+/3" +
       "lKA/TVFLkB5Mxd9euscAbVw6ECU6XpKzFFUACeue020zb1uq8jGwnpMlkWkg" +
       "K0EUUagiQn78cM5k5Z3OxAM5G3wRyD8B2dFSEB+B4Io1d3D04VufeFbUzJKC" +
       "Z2eZlPo4qhbluxNx68tKs2VVHei73fRC7caw5XOtYsNuHKzxOGQMPFpnLrE6" +
       "UFCavU5d+c787pd/cq7qLQC9oyiEwV+Plibnol4AqDsad8HO8wmRV7r9fU/N" +
       "7Nma+fOvefljgePa8vRJ6fqVh96+0DEPFXH9MKoEfCZFXjXsm1EPE2nKSKBG" +
       "2RwswhZBioyVYVRTUOWTBTKcjqMm5r2YfRzidrHM2eiMshsX5KiSr0CL3FOh" +
       "VJwmxl6toKY5BgE6uiO+b1M2aBV0PcDgjjhHuaJU96S070vN3z/fVjEEEehT" +
       "xyu+2iykHED0fq5yEbJFwNx/4ReC5z/sYYfOBtgbCqyY9elmnfPtBmpSMVeR" +
       "jI/ouk1b9w9dxNBTrHm6yMYpCm22Rj3YyP5+ja8/x7us+fr/AGN4f7y6FgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU5acwsWVX1vjdvZZj3ZgZmxnH2eYPMNH5V1Vt181Cptdfq" +
       "vaq7C+FRXXvXvnVVN44CLkzEINE3OEYY/0BUMiwxEk0MZoxRIBATDHFLBGJI" +
       "RJHI/BCNqHir+tvfMhJjJ3X71q1zzj3n3HPOPffcl74NnQkDqOC51lqz3GhX" +
       "SaPdpVXZjdaeEu62u5WBGISKTFpiGE7A2DXpiU9f+u73Pqhf3oHOCtC9ouO4" +
       "kRgZrhOOlNC1VorchS4djtKWYocRdLm7FFciHEeGBXeNMLrahV5zBDWCrnT3" +
       "WYABCzBgAc5ZgPFDKID0WsWJbTLDEJ0o9KGfhk51obOelLEXQY8fJ+KJgWjv" +
       "kRnkEgAK57N3HgiVI6cB9NiB7FuZbxD4+QJ8/dfecfl3T0OXBOiS4YwzdiTA" +
       "RAQmEaA7bcVeKEGIy7IiC9DdjqLIYyUwRMvY5HwL0D2hoTliFAfKgZKywdhT" +
       "gnzOQ83dKWWyBbEUucGBeKqhWPL+2xnVEjUg632Hsm4lZLJxIOBFAzAWqKKk" +
       "7KPcYRqOHEGPnsQ4kPFKBwAA1HO2EunuwVR3OCIYgO7Zrp0lOho8jgLD0QDo" +
       "GTcGs0TQg7ckmunaEyVT1JRrEfTASbjB9hOAupArIkOJoNefBMspgVV68MQq" +
       "HVmfb/fe8oF3OU1nJ+dZViQr4/88QHrkBNJIUZVAcSRli3jnM90Pifd99rkd" +
       "CALArz8BvIX5/Z965a1veuTlz29hfvgmMP3FUpGia9JHF3d9+SHy6frpjI3z" +
       "nhsa2eIfkzw3/8Hel6upBzzvvgOK2cfd/Y8vj/5s/u6PK9/agS62oLOSa8U2" +
       "sKO7Jdf2DEsJGoqjBGKkyC3oguLIZP69BZ0D/a7hKNvRvqqGStSC7rDyobNu" +
       "/g5UpAISmYrOgb7hqO5+3xMjPe+nHgRB58AD3QmeK9D2l/9H0BDWXVuBRUl0" +
       "DMeFB4GbyR/CihMtgG51eAGs3oRDNw6ACcJuoMEisANd2f+w0jTFgcd8Aw+k" +
       "3cy0vP8PomkmyeXk1Cmg5IdOurgFvKPpWrISXJOuxwT9yievfXHnwOT3dBBB" +
       "j4B5drfz7Obz7G7n2d3OA506lZN/XTbfdv2A9k3gxyDC3fn0+O3tdz73xGlg" +
       "OF5yB1BdBgrfOtCSh57fyuObBMwPevmF5D38zyA70M7xiJnxCIYuZuiDLM4d" +
       "xLMrJz3lZnQvve+b3/3Uh551D33mWAjec+UbMTNXfOKkNgNXUmQQ3A7JP/OY" +
       "+Jlrn332yg50B/BvENMiEdggCBePnJzjmEte3Q9vmSxngMCqG9iilX3aj0kX" +
       "Iz1wk8ORfJnvyvt3Ax2/JrPRrFPaM9r8P/t6r5e1r9uaRbZoJ6TIw+ePjb2P" +
       "/PWf/2MpV/d+pL10ZO8aK9HVI96dEbuU+/HdhzYwCRQFwP3dC4Nfff7b73tb" +
       "bgAA4smbTXgla0ng1WAJgZp//vP+33ztqx/9ys6h0URge4sXliGlB0Jm49DF" +
       "2wgJZnvDIT8gOljAmTKrucI5tisbqiEuLCWz0v+89BT6mX/+wOWtHVhgZN+M" +
       "3vTqBA7Hf4iA3v3Fd/zbIzmZU1K2Ox3q7BBsG/LuPaSMB4G4zvhI3/MXD//6" +
       "58SPgOAJAlZobJQ8Bp3ac5yMqddHUOE2/rgXEt1gb2POFxrOMZ/J291MSTk9" +
       "KP9WyppHw6MOc9wnj2Qe16QPfuU7r+W/80ev5BIeT12O2gcrele3Jpk1j6WA" +
       "/P0no0NTDHUAV36595OXrZe/BygKgKIE4lrYD0BISo9Z0x70mXN/+8d/ct87" +
       "v3wa2mGgi5YryoyYOyZ0AXiEEuogmqXeT7x1axDJedBczkWFbhB+a0gP5G9Z" +
       "8vf0rWMSk2Ueh279wH/0rcV7//7fb1BCHo1usuGewBfglz78IPnj38rxD8NC" +
       "hv1IemOYBlnaIW7x4/a/7jxx9k93oHMCdFnaSwF50YozZxNA2hPu54UgTTz2" +
       "/XgKs92vrx6EvYdOhqQj054MSIfbA+hn0Fn/4okYlO2Z0EPgeXrPPZ8+GYNO" +
       "QXkHz1Eez9srWfMj+y5/zguMFdjf93z+++B3Cjz/nT0ZsWxguxvfQ+6lBI8d" +
       "5AQe2LnOAcfIMoF9z3n0Np6TwW2jYtaWs4bYTozd0p7eclzaJ8Czuyft7i2k" +
       "ZW8hbdalcxUyEXQRsEVbluGFB6w/cRvW90BPcN97Ve7z2dJTQNNnirvYLpK9" +
       "8zfn73TWfSOIwmGe9gMM1XBEa5/h+5eWdGV/DXhwDADucGVpYfvcX849OTO8" +
       "3W3ufIJX5n/NK/DUuw6JdV2Qhr//Gx/80i8/+TXgTm3ozCozdeBFR2bsxdnJ" +
       "5Bdeev7h11z/+vvzTQUonH/3U/+S53ni7STOGiFr3rYv6oOZqOM8A+uKYcTm" +
       "+4Ai59LeNooMAsMG2+VqL+2Gn73na+aHv/mJbUp9MmScAFaeu/6L39/9wPWd" +
       "IweZJ284SxzF2R5mcqZfu6fhAHr8drPkGMw/fOrZP/ztZ9+35eqe42k5DU6d" +
       "n/jL//rS7gtf/8JN8sQ7LPf/sLDRnd9olsMWvv/r8nN1mnBpOlX7hcFqAfd0" +
       "BsN7qYULawZpuaPpHGkvKcLrb6QJk6LiQLd78SJG41qErcJNZDledUh4826B" +
       "RpkO2ULGfIWT3HFHHDHTZWS1JvE8ENu0t+gMnfq4sxr6K8RZzF2Rp2Z1l6mv" +
       "hNUCU+lFxV2rEdbbsEoRtlczZ1WvY2EkxC6yHA0ZlPF0FnPTVsL6zpBtrIV2" +
       "mo5C25S1LmnWp/MmLMXrOiKgOt/m8cnECpfmct6m2TUnt23cmXV80047OrOx" +
       "2jhSTrWNQdtsh0utCVfUrEWr4vQkfip0PaM9t5cNnGyUmpxhmGiFGROmzXRx" +
       "eipLst62+jWzr5MS5haWhOlMBHSzprR6ZUMNqM5gEE8Ngemq9ETBvSaJjqau" +
       "0xS8AcrgxdKoN+Vsv6ghQ9dFJLMrzAVHmzfTpjG0qjN7WagNFpUZHpaSWSf0" +
       "9cCqenbTEE2PWw/lUa0UVzsEWYuFdh03fKPTq1IbhlnNGAwZa2HD5ZnFFJU7" +
       "kV5voXS3ICwbqNgoeqQnz/XYELuoarTKPQcwtxzQda08FMXY6dtccyHPq8Vh" +
       "GI4ZAZ7TQalc6TamC3SqVbSRb0V8GulIu2cyujkczq3+aJJSeBOx7fHEJ6bM" +
       "sII5hLbm45FQrU4WE8oO5paPlzG1l2jzbn/ZLNt+NSoTKdGrshonoQnKRomO" +
       "dQv8dM45OC/zmF0ltWKzSGnulFSp1E1YIihspm2ht7Z90Y3Lml7tLbGkh+Od" +
       "Da9w7Y0dDDhWn1F4w510/bbWG4UyUZcnIUKI/pymGvo46hoxV+SDJmJM+qYx" +
       "2axxSrbbGulbXkyyAolIrtYQJNrDhlWJ9pUaZlbi1SrV6xwl6gYzZ+tey7BC" +
       "GJ7hKMFrfTNZpyQ+JMqddD4b1GgLQ5HATIYmWWNNPBS72KbAr0qLAioqdGkY" +
       "MDZdsSifaDMu53mD3qJY6UViKSy3IxdZzCZtU16Z9U3T5peomcLcUKGnCt8S" +
       "2uxIKXX1WqtWKBR0vuaU5+iwuOyY1oR0nMRFhfa6EK+H7qY+IrmGZwzry4bf" +
       "tl0sLUwZjlKL5YBopYphTNihKY/CkBtYY6um1jVXW7fmpOhrWDUUlmMsKPbF" +
       "Mlw0ljrp6xpYnF6/m7YKcEf1kF5HtcajUXfa5vnuxLNFOoXZxG+ZSXdR8Vte" +
       "bRC0/Y7JU02K8BuC6abLWotWQ0O0Qstfjmpzp46X59xcrFrwpkAznmmvqzLV" +
       "mlDrok22OikuE5uhNZmvTbnbSGSYmko1s6QPwsTC5HDI0LOAYEdVZFLu6410" +
       "Yo5DDWnpXafMTJGC1ER1mI5bc6071hfwWtdq6qDOj/FyYTlZ1whk2Z00LZQw" +
       "FgG1INtFcKCoBw6DwvN6GMwXw3AZ+ckIj+Zz1dITViNrwEh4Bwc+Q/Fxy4A3" +
       "7qDcZTjBNidjnFpaZq8w5vxej573exw2IVu1Zn+03qzdeLpJwOKPknjmIfWB" +
       "2m/GLB5gQ6EcTYdOOe0tmw1qiNG9ZEH1MaZCiaqqwFRlXZCRKEnqRa7Xr9u8" +
       "RLVkxW31aWo04CK/RgWFudq3uO5GxroSnqQjvKg1CTmZ8LVOr71qbcCqDOfc" +
       "xtYbTSMK14GQNiVEKAZDLFkWN5YqzzRmxYUY4etTBWOmam0zFWZVMY2YCsbC" +
       "5FojOLVWqC1QoYRVkE09rBTEoon0N+1qDKJEsMLHQztoodSkugoiU2KHLhWX" +
       "pGg5KzlGJbKXpYZCzMOeQcLiuqcJOEFLLWGFGeJaVQtSsVdQIh2t1TyhPyJJ" +
       "zV+4Pms2EBkdr7W2X0TX9aSPeyZVY6uwp/I4A1eGG9Ysezo+m64qbmnhrNJJ" +
       "uVAiqfpwzo6KbhUtMTHZV4vJSlmNe/MSHJTtNkmbsRuEqMS6zfEaLbXxskgI" +
       "da1g+KpaXW18H9aEpLnCp0xfaY+S4hAVwxBBUa47ssihkXJMsgkYn2zCw/7G" +
       "MYEP161R3F3TbXixFvyet5Q1mGp6HUEcIysnaG5GfXVArbtiVV/Vg3UhlFro" +
       "KmbGWNvm0iYdJRKBDfGihBAlrNZ1K6jP6XKosUN63J4TRq2CEx0mQBShx8x4" +
       "p+6nhVoYA1FSzh20Jj7YMBx9gw8mzLBLc022iRMJp8IcLLV0z441UWn4rt61" +
       "xgnYTWfDlRqtKUUorfFKUF+s4pKMFoS4Rte5VFqjDlVg2bA9MCZ2bxF2CUtV" +
       "4XgyCJxNBQkmrYJTsugJhaNwczBEAn/Thwszu71eOsUuTw4J2JwgxagfzEsr" +
       "pQInMUk145Ld9poaq8klZxULASxihlN1ZbD/onhXaPMtpK55EkH2EwZ1p+Zs" +
       "YxHNQmFR7wllVxy4sskgC4KmBqHZLEsw69QJE61upAbdqvHMVIsGTWTaGIAI" +
       "MC7QSl8iNqt2WrIr9oZHigkzCXRtU+oQbdweuJaOtyY6UQ6Whc0cY8pGT7fl" +
       "hClNMbvdm5FpcYbag6Y6Cop4b5D2PNZrrRs00qZQdz31rU7frraqxb6tuaFR" +
       "rU6Xk7A8LDK2hbtSLXR5alSStalQHNT4lAvJBeJi4Xw+N6nxVKz4lY3SL0zY" +
       "WaXeaToRYrv+pjdLzEFizlb2Bobr5drSKsFYwehY03GJr3dDjjU5blPxwyQO" +
       "kFTlWqs6WR6q7Rgpz4Cxgo0eVpYMI4dBP+xXRgOslKCdBVkeMFIjWjUDewl8" +
       "E2NNGU50lHNU3KEbo1JqVOqroDCROwzbLdQNRYtidVax1aDO8pFDdw3bN+Wa" +
       "uVgR0pyysAaOlXuW1ZfIOJ3G/Gi2afpDqhMOF+uZQQ4Mbc16RdMcY8Oa0Gh6" +
       "joPW2FmxrbJmoCF2ByRUjaFCtuYuvV7xxY5H08PCuk0EdK09IA2uj8wqiGO3" +
       "KWmCtLwRXnYxnLb45nokNaRxPHW8KAhsG4RBfFYiYtkuhlSBmdouqSudwQzx" +
       "S2NKaIzjWZnFea8IN/2GuxomdNKo0HoBLlkdHJ7wTNckKmwq15U4lPAFn1Rp" +
       "kqvOvA7IjDicVGIFKSKbBRr7tWUjcTzWMqem1kFojhM1Y+hgNYmtmBWh1E9x" +
       "ttIoJaM1VSOKMjOmiQJRbrmoXKKQMh+rCrPgNu0OKRQVwRq4ZV9fWHHaS6u1" +
       "qBMWeb6pGFhJHZGYJCaVWT8CMTFudjZpvzFkB4zndAO6yjGkuOIqckHCapgn" +
       "w5KP+d0hWXfXBp3whYFlLBzXKuM+FYoy2FtqiT3isaCucnAP69liQe2vFNVa" +
       "aspArK1G7arq83q9WkAoesDMmnW249IqKTCz5Sy0UXpAF53OuEM0iqMkTHSB" +
       "MNw1P+dHE64/nRCTjrT0WbsSFOfqaGPIQZMtKgYb6uGs0jHGAUJ2S0wf+HNi" +
       "p1Y1cjvzCqHR1djoFxYoWxQJHhlIlLZc6s1YbHP16hjBkFWvtIFVfknTtKJP" +
       "0nVcKBprs0lTiOpX1vSizSS9FC6PFLKygYEXqX0i0hakv57XFct21EFE2N6Y" +
       "5ZXRsgW7sYku6kldTnvEJGja1TU790i7WBwtS/P1oFJYijU4xeKwoAYw3uiV" +
       "VWxdZTQcz447wQ924rw7P1wf3FKBg2b24e0/wElr++nxrHnqoGSR/86evNk4" +
       "Wj89LJBB2enx4VtdPuUnx4++9/qLcv9j6M5eYdGOoAuR6/2opawU6wip7AT/" +
       "zK1PyWx+93ZY8Prce//pwcmP6+/8AUr/j57g8yTJ32Ff+kLjDdKv7ECnD8pf" +
       "N9wKHke6erzodTFQojhwJsdKXw8faPbeTGMPgOfNe5p988li0OHa3bwS9Mbt" +
       "2p+o256oA28ryGIS7WqKa+/igVSkcrznblPv/aWs+dkIOhO5Y75xQCqrLiUl" +
       "aVcGhLLLamXvXjk3rZ97tUP8sbpqBJ3dXgxlVe4HbrhW3l6FSp988dL5+1/k" +
       "/iq/Gzm4rrzQhc6rsWUdLTAe6Z/1AkU1cjkubMuNXv73fATdf4v6WFayyjs5" +
       "o9e38C9E0OWT8EAl+f9RuN+IoIuHcIDUtnMU5MUIOg1Asu5vevvqRG9XoQ9E" +
       "Tzekbf2VdJ2VEkRKkJ467m0Hur/n1XR/xEGfPOZW+b3/vgvE25v/a9KnXmz3" +
       "3vVK9WPbux3JEjebjMr5LnRue8104EaP35LaPq2zzae/d9enLzy17/J3bRk+" +
       "NO4jvD1684sU2vai/Opj8wf3/95bfuvFr+bluf8ByFJ6E5AhAAA=");
}
