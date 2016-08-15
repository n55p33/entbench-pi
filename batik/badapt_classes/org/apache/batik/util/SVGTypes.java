package org.apache.batik.util;
public abstract class SVGTypes {
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_INTEGER = 1;
    public static final int TYPE_NUMBER = 2;
    public static final int TYPE_LENGTH = 3;
    public static final int TYPE_NUMBER_OPTIONAL_NUMBER = 4;
    public static final int TYPE_ANGLE = 5;
    public static final int TYPE_COLOR = 6;
    public static final int TYPE_PAINT = 7;
    public static final int TYPE_PERCENTAGE = 8;
    public static final int TYPE_TRANSFORM_LIST = 9;
    public static final int TYPE_URI = 10;
    public static final int TYPE_FREQUENCY = 11;
    public static final int TYPE_TIME = 12;
    public static final int TYPE_NUMBER_LIST = 13;
    public static final int TYPE_LENGTH_LIST = 14;
    public static final int TYPE_IDENT = 15;
    public static final int TYPE_CDATA = 16;
    public static final int TYPE_LENGTH_OR_INHERIT = 17;
    public static final int TYPE_IDENT_LIST = 18;
    public static final int TYPE_CLIP_VALUE = 19;
    public static final int TYPE_URI_OR_IDENT = 20;
    public static final int TYPE_CURSOR_VALUE = 21;
    public static final int TYPE_PATH_DATA = 22;
    public static final int TYPE_ENABLE_BACKGROUND_VALUE = 23;
    public static final int TYPE_TIME_VALUE_LIST = 24;
    public static final int TYPE_NUMBER_OR_INHERIT = 25;
    public static final int TYPE_FONT_FAMILY_VALUE = 26;
    public static final int TYPE_FONT_FACE_FONT_SIZE_VALUE = 27;
    public static final int TYPE_FONT_WEIGHT_VALUE = 28;
    public static final int TYPE_ANGLE_OR_IDENT = 29;
    public static final int TYPE_KEY_SPLINES_VALUE = 30;
    public static final int TYPE_POINTS_VALUE = 31;
    public static final int TYPE_PRESERVE_ASPECT_RATIO_VALUE = 32;
    public static final int TYPE_URI_LIST = 33;
    public static final int TYPE_LENGTH_LIST_OR_IDENT = 34;
    public static final int TYPE_CHARACTER_OR_UNICODE_RANGE_LIST = 35;
    public static final int TYPE_UNICODE_RANGE_LIST = 36;
    public static final int TYPE_FONT_VALUE = 37;
    public static final int TYPE_FONT_DESCRIPTOR_SRC_VALUE = 38;
    public static final int TYPE_FONT_SIZE_VALUE = 39;
    public static final int TYPE_BASELINE_SHIFT_VALUE = 40;
    public static final int TYPE_KERNING_VALUE = 41;
    public static final int TYPE_SPACING_VALUE = 42;
    public static final int TYPE_LINE_HEIGHT_VALUE = 43;
    public static final int TYPE_FONT_SIZE_ADJUST_VALUE = 44;
    public static final int TYPE_LANG = 45;
    public static final int TYPE_LANG_LIST = 46;
    public static final int TYPE_NUMBER_OR_PERCENTAGE = 47;
    public static final int TYPE_TIMING_SPECIFIER_LIST = 48;
    public static final int TYPE_BOOLEAN = 49;
    public static final int TYPE_RECT = 50;
    public SVGTypes() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALWbC3AbxRnHV/Ijjh+x48R5x3EcJ5DEsfJ+4DyQ5bOtRJYU" +
                                                              "STYTpyDOp7Ot5CyJu5WjhIYSZkpSmNK0BAgdyLSdUJgUCNPCwEyBCcNAoVA6" +
                                                              "PFqgtEAZOoXStKRModPQ0v329vSy9mh3pp7RaXO3+/33t/vtt3vK7v3nUYWh" +
                                                              "o2Y1gTvwwZRqdEgJHJR1Q415NNkwIuReVLmjTP7kqg/8W5yocghNG5ONfkU2" +
                                                              "1J64qsWMIbQwnjCwnFBUw6+qMSgR1FVD1SdkHE8mhlBT3PCOp7S4Esf9yZgK" +
                                                              "GQZl3Yemyxjr8eE0Vr3MAEYLfaQmLloTl7v4cacP1SrJ1MFc9jl52T15TyDn" +
                                                              "eE7LwKjBt0+ekF1pHNdcvriBOzM6WplKagdHtSTuUDO4Y5+2gTXBTt+GSU3Q" +
                                                              "+lD9pxePjzXQJpghJxJJTPGMkGoktQk15kP1ubuSpo4b16DrUJkP1eRlxqjN" +
                                                              "Z4m6iKiLiFq0uVyk9nVqIj3uSVIcbFmqTClQIYwWFxpJybo8zswEaZ2JhSrM" +
                                                              "2GlhQtuSpTUpJyHettJ14o6rGn5chuqHUH08EYbqKKQSmIgMkQZVx4dV3XDH" +
                                                              "YmpsCE1PkM4Oq3pc1uKHWE83GvHRhIzTpPutZoGb6ZSqU81cW5F+JGx6WsFJ" +
                                                              "PYs3Qh2K/atiRJNHCeusHKtJ2AP3CWB1nFRMH5GJ37Ei5fvjiRhGi4pLZBnb" +
                                                              "dpEMpOiUcRWPJbNS5QmZ3ECNpotocmLUFSaulxglWSuSxAF1jOZxjUJbp2Rl" +
                                                              "vzyqRsEji/IFzUck11TaEFAEo6bibNQS6aV5Rb2U1z/n/VtvuTbRl3AiB6lz" +
                                                              "TFU0qH8NKdRcVCikjqi6SsaBWbB2he92edYTx5wIkcxNRZnNPI9+9cLl7c3n" +
                                                              "njPzzC+RJzC8T1VwVDk9PO3lBZ7lW8qgGlWppBGHzi8gp6MsyJ50ZlIkwszK" +
                                                              "WoSHHdbDc6Fn91x/Rv3Iiaq9qFJJaulx4kfTleR4Kq6peq+aUHUZqzEvmqom" +
                                                              "Yh763IumkLQvnlDNu4GREUPFXlSu0VuVSfpv0kQjxAQ0UTVJxxMjSSudkvEY" +
                                                              "TWdSCKEG8kFN5LMAmX/0G6PdrrHkuOqSFTkRTyRdQT0J/IaLRJxh0rZjrmHi" +
                                                              "9ftdRjKtExd0JfVRl0z8YExlD2gjhAd7I7QFwbVS/w+jGSCZccDhII28oHiI" +
                                                              "a2R09CW1mKpHlRPpLunCg9EXTPcBl2dtgFEz0ekwdTqojtlJlg5yOKj5maBn" +
                                                              "PiKtv5+MYxJIa5eHr9x59bHWMuI4qQPlpOkga2vBhOLJDXYrQkeVs411hxa/" +
                                                              "veZpJyr3oUZZwWlZg/nBrY+SyKPsZ4OzdphMNbmI35IX8WGq0pOKGiMBhxf5" +
                                                              "mZWq5ISqw32MZuZZsOYjGHku/mxQsv7o3MkDRwa/ttqJnIVBHiQrSHyC4kEI" +
                                                              "zdkQ3FY8uEvZrT/6wadnbz+czA3zglnDmuwmlQSG1mIHKG6eqLKiRX4k+sTh" +
                                                              "NtrsU0kYxjIZNiTCNRdrFESRTisiA0sVAR5J6uOyRv2DtXE1HtOTB3J3qGdO" +
                                                              "h0uT6aTgQkUVpMF8Wzh19xsvfbiOtqQV9+vzJuywijvzYg0Ya6RRZXrOIyO6" +
                                                              "qpJ8vzsZvPW280f3UnckOZaUEmyDq4fEGNI7pAW//tw1b77z9unXnDkXxmSy" +
                                                              "TQ+TNUuGssz8gvw5yOff8IH4ADfMONHoYcGqJRutUqC8LFc3Erc0MszBOdoG" +
                                                              "EsQN4yNxeVhTYfx8Xr90zSN/vqXB7G6N3LG8pf3LDeTuz+1C179w1WfN1IxD" +
                                                              "gXkz1365bGYwnpGz7NZ1+SDUI3PklYV3/ky+m4R1EkqN+CGVRkdE2wPRDtxA" +
                                                              "22I1va4verYJLkuNfB8vHEZ565uocvy1j+sGP37yAq1t4QIpv9/75VSn6UVm" +
                                                              "LxCxRYhdCqI1PJ2VguvsDKnD7OJA1ScbY8TY+nP+rzRo5y4S2SEiq5AQawR0" +
                                                              "Eh0zBa7EcldM+c1TT8+6+uUy5OxB1VpSjvXIdMChqcTTVWOMBNZMasflZj0O" +
                                                              "VFlzSQZNaqFJN6AXFpXuX2k8hWmPHHps9sNb7z31NnXLlGljPi2/DmJ9QYSl" +
                                                              "a/HcID/z6qZf3fvt2w+Ys/lyfmQrKjfnnwFt+Ib3/jGpX2hMK7HSKCo/5Lr/" +
                                                              "rnme7R/R8rngAqXbMpPnJxKgc2XXnhn/u7O18hknmjKEGhS29h2UtTSM6yGy" +
                                                              "3jOsBTFZHxc8L1y7mQuVzmzwXFAc2PJki8Nabl4kacgN6boiH5wDXShZzmh9" +
                                                              "5/sgnS5Nj4IqdXjJUnVU1Rvf+97pz44c3eyEMVYxAVUnrdKQy+dPwxL7xvtv" +
                                                              "W1hz4t2bacdbpndS+WX0uhwu7dQVyiC5ioQrg67WMcGJJ2Qtk60s9bfZNpXF" +
                                                              "qDayJyhFB/y7/IEr/IWTN0yQ4fSwQSba+DgJvhNsSbk2eLVyrC34vulgc0sU" +
                                                              "MPM13ef65uDr+16kob0KpvKI1ah5EzWZ8vOmjAa4dMA4tnHcovq4Dje+s/+u" +
                                                              "Dx4w61PspUWZ1WMnbvqi45YTZsg1XxqWTFq355cxXxyKarfYToWW6Pnj2cM/" +
                                                              "ve/wUbNWjYVLYIm84T3w63+92HHy3edLrMnK4uzFD8KGI7uwmlnY1CZQ9zfq" +
                                                              "Hz/eWNZD5nQvqkon4tekVW+s0JunGOnhvLbPvYzkPJyhwdSGkWMFiTnmtA3X" +
                                                              "zXDZZbrVVm7M6548RlqY27WUGCOQ8AEYJEbsHBwuu+ESKuHZPAnLs73+iNQr" +
                                                              "heDeFUVEowJEi5ncYhsiJySSwkQ8CYxqKJF/oL+rNFBKAKiVqbXaANFKZ4SB" +
                                                              "eBIWkE/y90b6SgEdFABawtSW2ACVQ+KIMBBPAqP5eT0UDQQj3oDf7bPpsRsE" +
                                                              "ANuYepsNYAUkbhIG5ElgVE0B3f5en1SK52YBnqVMbKkNTyUkbhXm4UlYPJ6A" +
                                                              "L1Cyf04I8CxjYstseKZA4i5hHp6ExRN0k7BXiuduAZ5LmNglNjxVkLhHmIcn" +
                                                              "Qd4ITB4p5JH8EXdvSaf7oQDUpUzxUhuoqZB4UBiKJ4HRDAoVCbn94Z5AqD/q" +
                                                              "84ZL9tbZ/xGsh3yWM9XlNmDVkHhUGIwngVGVuZgMeUvRPCZAs4JJrbChqYHE" +
                                                              "OWEangRG0yhNT0jaPSD5PXtKMT0lwLSSCa60YaqFxPPCTDwJjKaaruftLzmS" +
                                                              "fi6A08602m1w6iDxijAOTwKjhvz5ljeMXhWgWsUkV9lQTYPEW8JUPAmLylwW" +
                                                              "cal+K0DVwSQ7bKjqIfG+MBVPwpqavN1S6anpDwI8LibmsuGhLzbnhXl4Etml" +
                                                              "Q7c74i7F8xcBntVMbLUND/1R9VNhHp4ERrPyvS4QIm9OfVLIW7KvPhNgW8OE" +
                                                              "19iwNULiC2E2noS1jKC+xxtQDiQAtZYprrWBmgHGq4SheBIWlMfnDUYH3b6B" +
                                                              "UhHdMVUAah1TXGcDNROMTxeG4klgNN1aQlAX5AQLR6MA1nqmud4GqwmMzxPG" +
                                                              "4klYWJ6BUJhgcXtrvgDWBqa5wQZrFhhfIozFk7CWSEE3iRicOOhoE2DayAQ3" +
                                                              "2jDNBuPtwkw8CYwWUCbJ7+7ySdEut2dXbygw4O/m99oqAcJNTH6TDeEcML5B" +
                                                              "mJAngdHM7CLQhOKGxI0CZJuZ7GYbsrlgfLswGU/CmsOs31/s5jDHDgG2LUx4" +
                                                              "iw3bPDDeK8zGk7DYegJkCutx93t9e/ge2SfAdhkTvsyGbT4YDwqz8SQwas5n" +
                                                              "87BU2Dsk8Rl3CzB2sgp02jAuAON7hBl5EgX9d4Xk7e2L8NmGBNi2MuGtNmwL" +
                                                              "wfiwMBtPwvpFg/4saDtvKwJg25jqNhuwZjC+XxiMJ2F12i5pTzQc9Hn9Upjf" +
                                                              "aZoA23YmvN2GbREYx8JsPAlrTRIMeP0RG6y0ANYOprnDBqsFjB8WxuJJYNRi" +
                                                              "YoWksBQaJE4ZDkqeSDTkjngDfMrrBChZVvObQ7kYjN8oTMmTwKguu07mTd5H" +
                                                              "BZDcTM9tg9QKxr8ljMSTwGhu8c8etqHkuABeF9PussFbAsZPCuPxJDBqM18B" +
                                                              "+twhtydiLk8G/F5PoFsizunv5a/C7hQg9bBqeGxI28D494VJeRIYzWZ7Cv4b" +
                                                              "uB8IwHUz5W4buKVg/IwwHE/Ceuum0zg3mvxIAEpiipIN1DIw/hNhKJ5Ewfqr" +
                                                              "Wwp7Qt5ghLhnOOThMz4swNjDKtBjw3gJGH9cmJEnYb31/BcryycEyHqZbK8N" +
                                                              "2aVg/BlhMp6EFTi73GEJlijRcJ+3x8Y5nxXA62PafTZ4QON4SRiPJ4FRI1uD" +
                                                              "hfxefy+f65cCXF4m6rXhWgHGXxfm4klYXOGg22PL9YYA104mutOGayUYf1eY" +
                                                              "iyeR/SEZXLHvS150fi/AtosJ77JhawfjHwqz8SSsDR65IOLu3jkQtgH8kwCg" +
                                                              "j6n7bACh/o6/CQPyJKz/IPSRObsUzicCOP1Mq98GpwOMXxTG4UlYP1ACDncF" +
                                                              "8rkAk58J+m2YXCThLBdm4klY4T73I5ft7ghnhQBegGkHbPBWg/E6YTyeBEbz" +
                                                              "rF8nISrCy5u3x8v/313nNAG+IBMP2vCtAeOzhPl4Eta+xK5AwCe5/aWIZgsQ" +
                                                              "7WZyu22I1oLxRcJEPAkrZoTIa3YpnBYbHM6mQrqDchVGVfKwgXVZwbnq0L96" +
                                                              "xD8DQHPOt/be62gh71Ad3aV7+oYTp2KBe9Y42VGGKwkNTqZWaeqEqhWYIrWx" +
                                                              "zkTBBv45k05UmqcAlQdP1VfNPjXwOj1jkz2pV+tDVSNpTcvfYp6Xrkzp6kic" +
                                                              "1qDW3HBO998612HUVPJ8Fkbl8AU1dK41827EqKE4L0YV9Ds/3xaMqnP5MKo0" +
                                                              "E/lZtmJURrJAcluKtsIcnL9V3dxln3EUtrXV46jpyxw4r3uWFGzzpqdZrS3O" +
                                                              "afM8a1Q5e2qn/9oLG+8xzwgpmnzoEFip8aEp5kkkahSOzSzmWrNsVfYtvzjt" +
                                                              "oalLrQ4vOKOUXzdIk5d4Bz3PM6/o0IzRlj078+bprU/+4ljlK07k2IscMkYz" +
                                                              "9k4+j5BJpYkn7vVN3sA9KOv0NE/n8u8e3N4+8te3rI3/jsJzHsX5o8pr9175" +
                                                              "6nfmnG52ohovqiC+rGboQYnug4mQqkzoQ6gubkgZUkViJS5rBbvDp4FjynDO" +
                                                              "lbYLa8667F04PIZR6+SN8ZOP3FVryQOq3pVMJ2Jgps6HanJ3zJ4pdPbqdCpV" +
                                                              "VCB3h3UlXGW4dGSgN4g/Rn39qZR18qpiKEVHu/lbdt4ueXqT+nCQJiG1+z8t" +
                                                              "an3U6T4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALWce6zj2HnYNbPv9e7O7Httr/c5a3tXu0NRJPXIem3zJYoU" +
       "RVIk9WKTTEiKIilSFJ8ipWRbO2hqo2ldA12nLmAb/cNGi8COgyJGC7QuXLRp" +
       "U8QtkMJ9oomDIEUTJEZjoHmgTpqSku7cO3fvlSMVvYCoI/Kcj7/zne985+N3" +
       "SX71e6V7orBU9hfuynQX8U0ji2/OXORmvPKN6CbDIoIaRsYEd9UokvN9t/SX" +
       "fvHaH/3gs9b1q6V7ldLjquctYjW2F14kGtHCXRoTtnTtdC/pGvMoLl1nZ+pS" +
       "BZLYdgHWjuI32dJ7zjSNSzfYEwQgRwByBGCDAKCntfJGDxteMseLFqoXR0Hp" +
       "L5eusKV7fb3Ai0sv3inEV0N1vhMjbHqQS7i/+D3IO7VpnIWlF273fdvnd3X4" +
       "c2Xgnb/z49f/4V2la0rpmu1JBY6eQ8T5SZTSQ3NjrhlhhE4mxkQpPeoZxkQy" +
       "Qlt17fWGWyk9Ftmmp8ZJaNxWUrEz8Y1wc85TzT2kF30LEz1ehLe7N7UNd3Ly" +
       "656pq5p5X5867eu2h61if97BB+0cLJyqunHS5G7H9iZx6fnzLW738UYnr5A3" +
       "vW9uxNbi9qnu9tR8R+mx7di5qmcCUhzanplXvWeR5GeJS++7VGiha1/VHdU0" +
       "bsWlZ87XE7aH8loPbBRRNIlLT56vtpGUj9L7zo3SmfH5HveRz/yk1/aubpgn" +
       "hu4W/PfnjZ4710g0pkZoeLqxbfjQa+zPqU9989NXS6W88pPnKm/r/KOf+v7H" +
       "X3/uW7+yrfP+C+rw2szQ41v6l7VHfu1Z/NXmXQXG/f4isovBv6PnG/MXdkfe" +
       "zPx85j11W2Jx8ObJwW+J/2r8iZ83fu9q6UG6dK++cJN5bkeP6ou5b7tGSBme" +
       "EaqxMaFLDxjeBN8cp0v35WXW9oztXn46jYyYLt3tbnbdu9j8zlU0zUUUKrov" +
       "L9vedHFS9tXY2pQzv1QqXc8/pSfzz7Ol7d/mOy71AGsxNwBVVz3bWwBCuCj6" +
       "HwGGF2u5bi1Ay63eAaJFEuYmCCxCE1BzO7CM3YGNEqQBJW80WJiW//9DaFb0" +
       "5Hp65Uqu5GfPT3E3nx3thTsxwlv6OwlGfv8Xbv3q1dsmv9NBXHouP8/N7Xlu" +
       "bs6zHaST85SuXNmIf6I43/ZQrn0nn8e5h3voVenHmJ/49Et35Ybjp3fnqiuq" +
       "Apc7Wvx05tMb/6bn5lf61ufTTw7+SuVq6eqdHrNgzHc9WDQXCj9325/dOD9T" +
       "LpJ77VO/80df/7m3F6dz5g4XvJvK725ZTMWXzmszXOjGJHdup+Jfe0H9xq1v" +
       "vn3jaunufH7nPi1WcxvM3cVz589xx5R888S9FX25J+/wdBHOVXej7J1PejC2" +
       "wkV6umczzI9syo/mOn6+tNvcYbTF0cf9YvvE1iyKQTvXi437fEvyv/if/93v" +
       "Qht1n3jaa2fWLsmI3zwzuwth1zbz+NFTG5BDw8jr/frnhb/9ue996i9tDCCv" +
       "8fJFJ7xRbPF8VudDmKv5Z34l+C/f/Y0vf+fqqdHE+fKWaK6tZ9tO/nn+dyX/" +
       "/J/iU3Su2LGdmY/hO/fwwm3/4Bdn/uApW+4p3HxiFRZ0o+/NFxN7aquaaxQW" +
       "+6fXXgG/8fufub61CTffc2JSr/9wAaf734uVPvGrP/7Hz23EXNGLlepUf6fV" +
       "tu7v8VPJaBiqq4Ij++S//8Df/dfqF3NHmjuvyF4bG39U2uijtBnAykYX5c0W" +
       "OHesWmyej85OhDvn2pmI4pb+2e/8wcODP/hn39/Q3hmSnB33ruq/uTW1YvNC" +
       "lot/+vysb6uRldeDv8X96HX3Wz/IJSq5RD33VxEf5q4mu8NKdrXvue+//vN/" +
       "8dRP/Npdpaut0oPuQp201M2EKz2QW7oRWbmXyvyPfXxrzen9J445K72r81sD" +
       "eWbzq5YDvnq5r2kVEcXpdH3mf/Ou9tO/9SfvUsLGy1ywkJ5rrwBf/cL78I/+" +
       "3qb96XQvWj+Xvdv95tHXadvqz8//8OpL9/7y1dJ9Sum6vgvtBqqbFJNIycOZ" +
       "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" +
       "rjllo5TqA/g84iMIBCJkRrQJk6qy/Qy2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+VVKSQAA");
}
