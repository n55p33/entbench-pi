package org.apache.batik.gvt.event;
public class GraphicsNodeKeyEvent extends org.apache.batik.gvt.event.GraphicsNodeInputEvent {
    static final int KEY_FIRST = 400;
    public static final int KEY_TYPED = KEY_FIRST;
    public static final int KEY_PRESSED = 1 + KEY_FIRST;
    public static final int KEY_RELEASED = 2 + KEY_FIRST;
    protected int keyCode;
    protected char keyChar;
    protected int keyLocation;
    public GraphicsNodeKeyEvent(org.apache.batik.gvt.GraphicsNode source,
                                int id,
                                long when,
                                int modifiers,
                                int lockState,
                                int keyCode,
                                char keyChar,
                                int keyLocation) { super(source, id, when,
                                                         modifiers,
                                                         lockState);
                                                   this.keyCode = keyCode;
                                                   this.keyChar = keyChar;
                                                   this.keyLocation = keyLocation;
    }
    public int getKeyCode() { return keyCode; }
    public char getKeyChar() { return keyChar; }
    public int getKeyLocation() { return keyLocation; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za5AUR7lv77j3m2cOOF4HBkJ2A4KCB5jjuIOF5bi6A8oc" +
                                                              "hmV2tnd37mZnhpneuz0IGigjqBWKIC+tQPmDFBFJoKxETZmkSKU0wcSUeWgS" +
                                                              "UyExxhKNKUNZJlHU+H09szuPfZBLabZqeme7v/f39fd93XvuXTLO0EkrVZif" +
                                                              "jWrU8HcprFfQDRrtlAXD2AxzYfF4qfC37Vd6lvtI+QCpTwjGRlEwaLdE5agx" +
                                                              "QKZLisEERaRGD6VRxOjVqUH1YYFJqjJAJkpGMKnJkiixjWqUIsBWQQ+RJoEx" +
                                                              "XYqkGA1aBBiZHgJJAlySQId3uT1EakVVG7XBpzjAOx0rCJm0eRmMNIYGhWEh" +
                                                              "kGKSHAhJBmtP6+QmTZVH47LK/DTN/IPyUssE60NLc0ww+0LD+9cOJRq5CcYL" +
                                                              "iqIyrp7RRw1VHqbREGmwZ7tkmjR2kq+Q0hCpcQAz0hbKMA0A0wAwzWhrQ4H0" +
                                                              "dVRJJTtVrg7LUCrXRBSIkVluIpqgC0mLTC+XGShUMkt3jgzazsxqa2qZo+LR" +
                                                              "mwJHjm9v/GEpaRggDZLSj+KIIAQDJgNgUJqMUN3oiEZpdIA0KeDsfqpLgizt" +
                                                              "sjzdbEhxRWApcH/GLDiZ0qjOedq2Aj+CbnpKZKqeVS/GA8r6NS4mC3HQdZKt" +
                                                              "q6lhN86DgtUSCKbHBIg7C6VsSFKijMzwYmR1bNsAAIBakaQsoWZZlSkCTJBm" +
                                                              "M0RkQYkH+iH0lDiAjlMhAHVGWgoSRVtrgjgkxGkYI9ID12suAVQVNwSiMDLR" +
                                                              "C8YpgZdaPF5y+OfdnhUHdyvrFB8pAZmjVJRR/hpAavUg9dEY1SnsAxOxdkHo" +
                                                              "mDDpsQM+QgB4ogfYhPnxHVdvXdh68WkTZmoemE2RQSqysHg6Uv/8tM75y0tR" +
                                                              "jEpNNSR0vktzvst6rZX2tAYZZlKWIi76M4sX+35+251n6Ts+Uh0k5aIqp5IQ" +
                                                              "R02imtQkmeprqUJ1gdFokFRRJdrJ14OkAt5DkkLN2U2xmEFZkJTJfKpc5b/B" +
                                                              "RDEggSaqhndJiamZd01gCf6e1gghFfCQWnimE/PDvxmJBBJqkgYEUVAkRQ30" +
                                                              "6irqbwQg40TAtolABKJ+KGCoKR1CMKDq8YAAcZCg1kJ8GHbnMOantbqgJSTR" +
                                                              "6IGMtIGOduGkH2NN+1S4pFHX8SMlJeCGad4kIMP+WafKUaqHxSOp1V1XHww/" +
                                                              "YwYYbgrLSowgY7/J2M8Z+4GxnzP252NMSko4vwkogOlycNgQbH3IvbXz+29f" +
                                                              "v+PA7FKINW2kDKyNoLNdNajTzg+ZpB4WzzfX7Zp1edGTPlIWIs2CyFKCjCWl" +
                                                              "Q49DshKHrP1cG4HqZBeJmY4igdVNV0UahRxVqFhYVCrVYarjPCMTHBQyJQw3" +
                                                              "a6BwAckrP7l4YmTv1q/e4iM+d11AluMgpSF6L2bzbNZu8+aDfHQb9l95//yx" +
                                                              "PaqdGVyFJlMfczBRh9neiPCaJywumCk8HH5sTxs3exVkbibAToOk2Orl4Uo8" +
                                                              "7ZkkjrpUgsIxVU8KMi5lbFzNEro6Ys/wUG3i7xMgLGpwJ86AZ6u1Nfk3rk7S" +
                                                              "cJxshjbGmUcLXiRW9msnX3nuT5/l5s7UkwZHI9BPWbsjhyGxZp6tmuyw3axT" +
                                                              "CnCvn+j99tF392/jMQsQc/IxbMOxE3IXuBDMfNfTO1994/Lpl3x2nDMo4qkI" +
                                                              "9ELprJI4T6qLKAnc5tnyQA6UIUNg1LRtUSA+pZgkRGSKG+tfDXMXPfyXg41m" +
                                                              "HMgwkwmjhdcnYM/fsJrc+cz2D1o5mRIRa7BtMxvMTOzjbcodui6MohzpvS9M" +
                                                              "/85TwkkoEZCWDWkX5Zm2ktugkms+BbqYvDnFmU3cWQF3Xn8qYsAOlpLgsGGr" +
                                                              "vC3u3SEeaOt92yxdN+RBMOEm3h+4e+vLg8/ycKjEHIHzKEydIwNALnHEYqPp" +
                                                              "po/gUwLPf/BB9+CEWSaaO61aNTNbrDQtDZLPL9JduhUI7Gl+Y+jeKw+YCniL" +
                                                              "uQeYHjjyzY/8B4+YPjY7njk5TYcTx+x6THVwaEfpZhXjwjG6/3h+z0/v37Pf" +
                                                              "lKrZXb+7oD194Df/ftZ/4s1LecpFqWR1rUsw6LMpfoLbN6ZCa77R8Oih5tJu" +
                                                              "yC5BUplSpJ0pGow6KULDZqQiDmfZnRSfcKqGjoHqswB9gDPLLI3xa6XjvYPB" +
                                                              "BlGVuFdK/LmWE/yCPVyXkpiw6kZ+SnxcygFuyYIRDkb42mYc5hrOdO8OGsfp" +
                                                              "ICweeum9uq3vPX6VG959vHBmt42CZnq9CYd56PXJ3nK8TjASALfkYs+XG+WL" +
                                                              "14DiAFAUodUwNunQFKRdudCCHlfx2yeenLTj+VLi6ybVsipEuwVeVkgV5HNq" +
                                                              "JKCfSGtfvNVMZyOVMDRyVUmO8jkTmFJm5E9WXUmN8fSy6yeTH1px5tRlnlct" +
                                                              "P0/l+BXY4rj6CH5ItUvZ2Rc//+sz9xwbMYO6yBb14E355yY5su+tD3NMzit3" +
                                                              "nl3rwR8InLu3pXPVOxzfLqGI3ZbObcugDbFxF59N/t03u/xnPlIxQBpF61C4" +
                                                              "VZBTWJgG4CBkZE6KcHB0rbsPNWYH355tEaZ504aDrbd4O3djGXPtPLteN6EL" +
                                                              "51o1O1O7XfWaN4VmRKFI/iCc4eJUb37re6c/2Lt/mQ8LxrhhFB2s0mjD9aTw" +
                                                              "7Pn1c0en1xx581vc8bDFDiHRGGf/GT4uwOFmHgo+KLUGP8Ey0ERSBNlTchuL" +
                                                              "yMlI1Yau28Ldwb7+zdk0MJ7jb8EhbtL6UsEY35HlNQVnF8Nzo8Xrxlyb4Pcg" +
                                                              "DkZ+XUrx1Y9DEgfFo8nkItQtTTbf1tu1Jp8mbIyaLIPHb/Hy5/EuviTANffg" +
                                                              "y+5PrE4hFozUoDq9fV39/fkVumOMCi2HZ4nFbUkRhQ7jy9c+sUKFWDBSiwr1" +
                                                              "dYW6OgpodNfH16geZ1vgWWmxW5mjEeEvd+dXBPrTKk1XGaQJGvVoUVeELCMV" +
                                                              "Q3S0E2p6PgUOjlGBqfCssTitKaDAMVMBHA7lylkI25ITqjX+7PHIeXyMcrbC" +
                                                              "E7Q4BQvIebKonIWwIcxBzpAqCplzidemp4rImrZ53pTlyT/lxHPN4eDpKKME" +
                                                              "e4XphW6ieHd4et+RU9FN9y3yWR3Maogcpmo3y3SYyg5SpUjJVZE38rs3u7y9" +
                                                              "Xn/494+0xVeP5VCPc63XObbj7xlQRRYULvJeUZ7a9+eWzasSO8ZwPp/hsZKX" +
                                                              "5Pc3nru0dp542McvGs26m3NB6UZqd1fbap2ylK64u905Wb82oL9ugCdi+TXi" +
                                                              "jUQ7cjwhkT15FkIt0rE+VGTtRzicZ6Q6TtkGR1qwo/fC9XZa8R4RJ7ZrfP4H" +
                                                              "WW04Oua+QUubwbEbohBqEWWfKLL2JA6P2obI5B3bEI/9HwzRkNndOy1tdo7d" +
                                                              "EIVQiyj7XJG1X+FwiZF60xCuxGYb4xf/C2OkGZmQ70YSDxZTcv4CMa/txQdP" +
                                                              "NVROPrXlZZ6DslfrtZBNYilZdra+jvdyTacxietXazbCGv96hZGWwtel0I3y" +
                                                              "by7/yybGayBzPgw4SMPohLzMSKMXEijybyfc7yDobDhohc0XJ8jbQB1A8PUP" +
                                                              "WuZOZtHHvOcNKlqKcbumS9yFI+vNidfzpqPWzHHlaP5/Viafpsx/tMLi+VPr" +
                                                              "e3Zf/dx95m2eKAu7diGVmhCpMC8Wszl5VkFqGVrl6+Zfq79QNTdTvZpMge19" +
                                                              "MdURvNuhL9IwfFo8V11GW/bG69XTKx7/5YHyF+AAs42UCIyM35Z78EprKSiG" +
                                                              "20K5tyBQv/gdXPv8746uWhj762vWCYffmkwrDB8WXzpz+4uHp5xu9ZEaODlB" +
                                                              "YaZpfiJcM6r0UXFYHyB1ktGVBhGBiiTIriuWeox0Af/p4naxzFmXncW7YEZm" +
                                                              "594u5d6gV8vqCNVXqyklyqsU1E97JlObXWUtpWkeBHvGcQPXjUN7Gr0BARsO" +
                                                              "bdS0zOVb2SMa3/RrC1+9fMhfcfjHfwF8tpgy6x4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "W//V+/7pq18uPwT+H4Uh4N1tKQAA");
}
