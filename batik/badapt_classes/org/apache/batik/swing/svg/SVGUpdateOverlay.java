package org.apache.batik.swing.svg;
public class SVGUpdateOverlay implements org.apache.batik.swing.gvt.Overlay {
    java.util.List rects = new java.util.LinkedList();
    int size;
    int updateCount;
    int[] counts;
    public SVGUpdateOverlay(int size, int numUpdates) { super();
                                                        this.size = size;
                                                        counts = (new int[numUpdates]);
    }
    public void addRect(java.awt.Rectangle r) { rects.add(r);
                                                if (rects.size() >
                                                      size) rects.
                                                              remove(
                                                                0);
                                                updateCount++; }
    public void endUpdate() { int i = 0;
                              for (; i < counts.length - 1; i++) {
                                  counts[i] =
                                    counts[i +
                                             1];
                              }
                              counts[i] = updateCount;
                              updateCount = 0;
                              int num = rects.size();
                              for (i = counts.length - 1; i >= 0;
                                   i--) { if (counts[i] > num) { counts[i] =
                                                                   num;
                                          }
                                          num -= counts[i]; }
                              counts[0] += num; }
    public void paint(java.awt.Graphics g) { java.util.Iterator i =
                                               rects.
                                               iterator(
                                                 );
                                             int count = 0;
                                             int idx = 0;
                                             int group = 0;
                                             while (group < counts.
                                                              length -
                                                      1 &&
                                                      idx ==
                                                      counts[group])
                                                 group++;
                                             int cmax = counts.length -
                                               1;
                                             while (i.hasNext()) {
                                                 java.awt.Rectangle r =
                                                   (java.awt.Rectangle)
                                                     i.
                                                     next(
                                                       );
                                                 java.awt.Color c;
                                                 c =
                                                   new java.awt.Color(
                                                     1.0F,
                                                     (cmax -
                                                        group) /
                                                       (float)
                                                         cmax,
                                                     0,
                                                     (count +
                                                        1.0F) /
                                                       rects.
                                                       size(
                                                         ));
                                                 g.
                                                   setColor(
                                                     c);
                                                 g.
                                                   drawRect(
                                                     r.
                                                       x,
                                                     r.
                                                       y,
                                                     r.
                                                       width,
                                                     r.
                                                       height);
                                                 count++;
                                                 idx++;
                                                 while (group <
                                                          counts.
                                                            length -
                                                          1 &&
                                                          idx ==
                                                          counts[group]) {
                                                     group++;
                                                     idx =
                                                       0;
                                                 }
                                             } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALUZC3BU1fXu5kNIyFcIGCBACGKC7qrVIo2iEALELpAmmJku" +
                                                              "n/Dy9m7yyNv3Hu/dTTax+GHaEdspYymidSSdaVHUolCnTmutltapn9HaqrRq" +
                                                              "HcXWjtUqo4yj7dS29px739v32Q/DWHbm3X177znn3vM/9+zhk6TMMkkz1ViE" +
                                                              "jRvUinRprEcyLZroVCXL2ghzA/LtJdJHW99ZvyxMyuOkZliy1smSRVcrVE1Y" +
                                                              "cTJX0SwmaTK11lOaQIwek1rUHJWYomtxMkOxulOGqsgKW6cnKAL0S2aM1EuM" +
                                                              "mcpgmtFumwAjc2Nwkig/SXRFcLkjRqbJujHugs/ygHd6VhAy5e5lMVIX2y6N" +
                                                              "StE0U9RoTLFYR8YkSwxdHR9SdRahGRbZrl5mi+Ca2GU5Img5WvvJp7cO13ER" +
                                                              "nCNpms44e1YvtXR1lCZipNad7VJpytpBriclMVLlAWakNeZsGoVNo7Cpw60L" +
                                                              "Baevplo61alzdphDqdyQ8UCMLPATMSRTStlkeviZgUIFs3nnyMDt/Cy3gssc" +
                                                              "Fm9bEt13+9a6h0pIbZzUKlofHkeGQzDYJA4CpalBalorEgmaiJN6DZTdR01F" +
                                                              "UpUJW9MNljKkSSwN6nfEgpNpg5p8T1dWoEfgzUzLTDez7CW5Qdm/ypKqNAS8" +
                                                              "Nrq8Cg5X4zwwWKnAwcykBHZno5SOKFqCkXlBjCyPrV8GAECdkqJsWM9uVapJ" +
                                                              "MEEahImokjYU7QPT04YAtEwHAzQZaSpIFGVtSPKINEQH0CIDcD1iCaCmckEg" +
                                                              "CiMzgmCcEmipKaAlj35Orr9iz3XaWi1MQnDmBJVVPH8VIDUHkHppkpoU/EAg" +
                                                              "TmuP7ZcaH9sdJgSAZwSABcxPv3bq6guajz0tYGbngdkwuJ3KbEA+OFjzwpzO" +
                                                              "tmUleIwKQ7cUVL6Pc+5lPfZKR8aACNOYpYiLEWfxWO+TX73xfvpemFR2k3JZ" +
                                                              "V9MpsKN6WU8ZikrNNVSjpsRooptMpVqik693kynwHlM0KmY3JJMWZd2kVOVT" +
                                                              "5Tr/DSJKAgkUUSW8K1pSd94NiQ3z94xBCJkCD7kInsVEfPg3I1ujw3qKRiVZ" +
                                                              "0hRNj/aYOvJvRSHiDIJsh6ODYPUjUUtPm2CCUd0cikpgB8PUWRgDC4pao2BM" +
                                                              "/WuuNRLAxoZRaqrSeATtzDjrO2SQx3PGQiEQ/5yg86vgN2t1NUHNAXlfemXX" +
                                                              "qQcHnhWGhc5gS4eRJbBpRGwa4ZtG+KYR2DQS3JSEQnyv6bi5UDMoaQTcHeLt" +
                                                              "tLa+Ldds291SAvZljJWChBG0xZd3Ot2Y4ATyAflIQ/XEgjcufiJMSmOkQZJZ" +
                                                              "WlIxjawwhyBAySO2D08bhIzkJob5nsSAGc3UZZqAuFQoQdhUKnRgBecZme6h" +
                                                              "4KQtdNBo4aSR9/zk2B1jN/XfcFGYhP25ALcsgzCG6D0YwbORujUYA/LRrb35" +
                                                              "nU+O7N+pu9HAl1ycnJiDiTy0BK0hKJ4BuX2+9PDAYztbudinQrRmEngXBMLm" +
                                                              "4B6+YNPhBG7kpQIYTupmSlJxyZFxJRs29TF3hptpPX+fDmZRhd43G54ltjvy" +
                                                              "b1xtNHCcKcwa7SzABU8MV/YZB155/t0vcHE7OaTWk/z7KOvwxC0k1sAjVL1r" +
                                                              "thtNSgHu9Tt6vnvbyZs3cZsFiIX5NmzFsRPiFagQxPyNp3e8euKNg8fDrp0z" +
                                                              "SNzpQah/MlkmcZ5UFmESdjvPPQ/EPRUiA1pN67Ua2KeSVKRBlaJj/bt20cUP" +
                                                              "v7+nTtiBCjOOGV1wegLu/LkryY3Pbv1HMycTkjHvujJzwUQwP8elvMI0pXE8" +
                                                              "R+amF+d+7ynpAKQFCMWWMkF5dA1zGYT9vo7+1JcetMAvlRSoYdROVJf0bJN3" +
                                                              "t/b8VSShc/MgCLgZ90a/3f/y9ue4kivQ83Ee+a72+DVECI+F1QnhfwafEDz/" +
                                                              "xQeFjhMi4Dd02llnfjbtGEYGTt5WpE70MxDd2XBi5K53HhAMBNNyAJju3vfN" +
                                                              "zyJ79gnNidplYU754MUR9YtgB4dleLoFxXbhGKv/dmTno/fuvFmcqsGfibug" +
                                                              "0Hzgj/95LnLHm8/kSQAlil1/XoqmnA3c0/26EQytuqX2F7c2lKyGmNFNKtKa" +
                                                              "siNNuxNeilB6WelBj7LcmohPeFlDxTASagcd4MTlfLyMn+Wi7IkIPxHha2tx" +
                                                              "WGR546dfX54Se0C+9fiH1f0fPn6K8+yv0b3hYp1kCIHX43AeCnxmML+tlaxh" +
                                                              "gLv02PrNdeqxT4FiHCjKkLOtDSZk2IwvuNjQZVP+9KsnGre9UELCq0mlqkuJ" +
                                                              "1RKP02QqBEhqDUNyzhhXXS3iw1gFDHWcVZLDfM4E+ui8/N7flTIY99eJn838" +
                                                              "yRWHJt/ggcoQNGZz/FKsF3yJmd/03Nxw/0tL/3DoO/vHhD0V8Y4A3qx/bVAH" +
                                                              "d/3lnzki56kwj8ME8OPRw3c1dS5/j+O7OQmxWzO5NQ7kdRf3kvtTH4dbyn8T" +
                                                              "JlPipE62b1b9kprGSB+H24TlXLfg9uVb998MRBnckc25c4Ie69k2mA29jlDK" +
                                                              "fEZf788NLfCcb+eG84MJMET4S5yjLOZjOw4Xeu0hS6q0CClGykwsOUHjc/NE" +
                                                              "215pjN8/BuTNi+saW5d91GIHtjywnovKnkd/Ho8vrpMFcL64H7ig3HuoQn4t" +
                                                              "9SSP+3iupVkOavDADfDcZ3Nwn4jVmz9n6QxocGOGQAka3aikaAJv7HhQuzQ/" +
                                                              "q/R5EPE5mCvoH42oKz64/J4rhewWFPAtF/6Rr7z5woGJI4dF6MZUCEV7oR5D" +
                                                              "bmMDq8FFRSpaV6kfr/nSsXff6t/i6KgGh4SwtVmM1HiDoqhB1GDewJ9ddvmG" +
                                                              "YzcOmwSJWMFIt9Fvzk3wtNnG0FbAM3YIz8BhS64zFMJmomzhySZwSPMsHJIL" +
                                                              "ArJNVZpfojr1tMby7T1+hnvXw9Nu791eYO+dRQVUCJvhDR1OaVn5QwCvBYW1" +
                                                              "bK568pfWD99+yLGWQb9H4xltdsQ3I5s+p8ehpUtjLDpE9VS0B274cH8bYsOO" +
                                                              "Q59N8ujPRZzII5bJexY+f8Pkwj/zEqFCsSBXQJWap+3jwfnw8In3Xqye+yC/" +
                                                              "iXEPt2snf78stx3m63JxLdTi8HVRTuUUddyUBIBtJd/Kn2DC+BqB1JFUNEnl" +
                                                              "1JaBaahcIPhrOQ63GG5d4lwC7Fghrg+YTSOdqq5RvIk4a6J5oOiRbGsRFjM5" +
                                                              "h/XlKwig6zirbrp/vWbvW4+0Dq08k64BzjWfpi+Av+eBvtoLqzt4lKd2/b1p" +
                                                              "4/LhbWfQAJgXsIYgyfvWHX5mzXny3jDvXoo6JKfr6Ufq8FcflSZlaVPzF94L" +
                                                              "XfO4xQ0QS7iCi9TdB4qsfR+HO8FWZFS0sIsi4D/ILWVxotfwVL3Fksn1RWJl" +
                                                              "xsNSNhrxTzkJNP88Mc9TF4ccG20p0BQbGmURuxeGIWFuoVYuv5Qd3LVvMrHh" +
                                                              "7oudCHk1g8JfNy5U6ShVPbuW8Pf9/v5IKxEtS+J8e2O8K5MAs9muQyHUgGZC" +
                                                              "frYbuGtCEIz0QugE7wXHxKWHiyj0ERyOMjJFSiQQiwN1cIsS+rgKsu6oriRc" +
                                                              "Hf74dPmu+NVH2Es+oWFTaanN+dIzF1oh1CLcP1Vk7Rkcfs14B1u0UXHiUVcO" +
                                                              "T5wtOSyAp9tmpvvM5VAItbjx1GeNZ40pGcOKbPGtjheR0Cs4/A5ihwHXPBaQ" +
                                                              "zu//H9LJMFIX7GLj3XlWzl9l4u8d+cHJ2oqZk9e+LHKx8xfMNEgQybSqem93" +
                                                              "nvdyw6RJhbM0Tdz1REfjTUaaCrfXGXj+qLg5nhDwbzHSmB8eZMS/vdBvA29B" +
                                                              "aIDj3164dxmpdOEgj4sXL8j7cBYAwdeThqPQOjeJiytxJuSJWrbMuapmnE5V" +
                                                              "WRRvixXzKv9j08mB6R77ynNk8pr115364t2ixSur0sQEUqmCikd0m7N5dEFB" +
                                                              "ag6t8rVtn9YcnbrIicL14sCuF8z2GGQv2LOB9tEU6H9ardk26KsHr3j8t7vL" +
                                                              "X4QKbxMJSVDsbMptHmSMNKSHTbHcJhrUHLwx29F25/jyC5IfvMbbM0SUPHMK" +
                                                              "ww/Ixw9teWnvrIPNYVLVTcogwdAM72qsGtcg8I6acVKtWF0ZOCJQgcrK16Gr" +
                                                              "QVOW8C9PLhdbnNXZWfyDAPJebnMy92+VSlUfo+ZKuCckkAzUqVXujO8fV9s9" +
                                                              "KtOGEUBwZzzF6yqRNVAbYI8DsXWG4fRuw0cN7tFdBYuEEI9UXfgW+h884q3e" +
                                                              "9CAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vJVB9xZquhhXZssmmqqxp9h9rmai1FrAGS8YsY3FvLU2TJ9lBX7rBZzreiHj" +
       "CTvDbOComTkJaTHVkb1CKYpZrOWaKYyFWX3mw12eGrU1cz7nF60R4vEyjrHG" +
       "FM1xLO0QlEl0myaYpoSeOtHQIRJtE3Q34gxhXdU5dguLq3FMxRxPGt0hFeiN" +
       "cXc1mW/n83Bi1whiLlclw/S0TmsyX3Bal8A80a11GHgRRSxHt1N3zQEw4JX2" +
       "LMy7W39c46cpOhlMjd4UrmdaqxFrbC1E2DnJtpeWqtjL5W4qkY6+GOhSXeMx" +
       "haM2HY8bJCK2DgeV0Yqrdac8SvG9qZPFjY1Rn3cZV5zOJFKhw5AWK7QsBzUc" +
       "4dvx2tpSC0LvDKrpWkbHYW2FtWdZW7WGU3jZ07ZSpBoUw9tjc7qm1gtrmG7F" +
       "JNGzTjvjx7VutbXRh7lJuZu6E/DtgYTO1+tdO+pP3amsz0cOp3UUaW0rDR0b" +
       "TUOZ7biYyHM4nJu1DrJl4aUq9QcrfVKrt2kp0HJi0OhWV8lmzEXb+QpgGedv" +
       "0Lozr4ybbMWLcLJtIZnkUEbXmGXVzqiqjyisEy1rFXzSba/ycBPJhjP1Obvn" +
       "aMsOQ9tYp1FZsRMgYtP0psPVLPJs3qLSbN1PKQ6oYdZHdS/0JsuK2rXXnC5j" +
       "6KCOWeE2zjZIGrIkIY2kRGzyebszbzECvFp3kDpYAVZjiew1x+JsYcJ5czSO" +
       "k5SomkjQ3go04od6yPIaGeGzsBE78SZbB6i0DvrGcFln7bwfcBOjL2rTdJKx" +
       "Hqq0lGjEai2163vVnGdzbyrqMGOZtrSuz/t2j5e38WQyhXsTbm60EY9tNOdi" +
       "baTwwojrWCK1hTdhrSrNJ3Gz4sxCo0Nsx+OBgCSKRkcwbfrZCp1sYoRkMmlm" +
       "bsk42lJ5Mp8mk5Zixcyw6i17La4i2v2KXGlmjtceTfsEs1gwZr8ut5F8sJrh" +
       "sdusIJSkhEw7tjjeXcncWKDU6oZi0RDetASe1yWY0QhaW+NVEUZVOMMjBTON" +
       "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" +
       "3d80OjkleeaerR23dYV84duPfu6h549B");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "8NE9w6emfYa3d939Lk3P9sLy9kv+z97+T97791/9g3Lz/X8DH81anborAAA=";
}
