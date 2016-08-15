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
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
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
                                                              "VCB3h3UlXGW4dGSgN4g/Rn39qZR18qrCk6Kj3fwtO2+XPL1JfThIk5Da/R+I" +
                                                              "sMFS6T4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALWce6zj2HnYNbPv9e7O7Hu9Xq/3MWt7rd2hKJJ6ZL22+RJF" +
       "iiIpknqxSSYkRZEUKYpPkVKybRwktdE0joGuUxewjf5ho0Vgx0ERowVaF1u0" +
       "aVPELZDCfaKJgyBFEyQGYqB5oE6akpLu3Dt375UjFb2AqCPynI+/853vfOfj" +
       "d0l+9bule6KwVPYX7sp0F/FNI4tvzlzkZrzyjegmwyKCGkbGBHfVKJLzfbf0" +
       "l3752p98/7PW9aule5XS46rnLWI1thdeJBrRwl0aE7Z07XQv6RrzKC5dZ2fq" +
       "UgWS2HYB1o7iN9jSe840jUs32BMEIEcAcgRggwCgp7XyRg8bXjLHixaqF0dB" +
       "6a+XrrCle329wItLL94pxFdDdb4TI2x6kEu4v/g9yDu1aZyFpRdu933b53d1" +
       "+HNl4O2/+6PX/9FdpWtK6ZrtSQWOnkPE+UmU0kNzY64ZYYROJsZEKT3qGcZE" +
       "MkJbde31hlspPRbZpqfGSWjcVlKxM/GNcHPOU809pBd9CxM9XoS3uze1DXdy" +
       "8uueqauaeV+fOu3rtoetYn/ewQftHCycqrpx0uRux/YmcekD51vc7uONTl4h" +
       "b3rf3Iitxe1T3e2p+Y7SY9uxc1XPBKQ4tD0zr3rPIsnPEpeevVRooWtf1R3V" +
       "NG7FpWfO1xO2h/JaD2wUUTSJS0+er7aRlI/Ss+dG6cz4fJf76Gd+3Gt7VzfM" +
       "E0N3C/7780bPn2skGlMjNDzd2DZ86CPsL6hPffPTV0ulvPKT5ypv6/zjn/je" +
       "J157/p1f29Z53wV1eG1m6PEt/cvaI7/xHP5q864C435/EdnF4N/R8435C7sj" +
       "b2R+PvOeui2xOHjz5OA74r8e/+QvGn9wtfQgXbpXX7jJPLejR/XF3LddI6QM" +
       "zwjV2JjQpQcMb4JvjtOl+/Iya3vGdi8/nUZGTJfudje77l1sfucqmuYiChXd" +
       "l5dtb7o4KftqbG3KmV8qla7nn9KT+ee50vZv8x2XeoC1mBuAqque7S0AIVwU" +
       "/Y8Aw4u1XLcWoOVW7wDRIglzEwQWoQmouR1Yxu7ARgnSgJI3GixMy///ITQr" +
       "enI9vXIlV/Jz56e4m8+O9sKdGOEt/e0EI7/3S7d+/eptk9/pIC49n5/n5vY8" +
       "Nzfn2Q7SyXlKV65sxD9RnG97KNe+k8/j3MM99Kr0I8yPffqlu3LD8dO7c9UV" +
       "VYHLHS1+OvPpjX/Tc/MrvfP59JODv1G5Wrp6p8csGPNdDxbNhcLP3fZnN87P" +
       "lIvkXvvU7/3J13/hrcXpnLnDBe+m8rtbFlPxpfPaDBe6Mcmd26n4j7ygfuPW" +
       "N9+6cbV0dz6/c58Wq7kN5u7i+fPnuGNKvnHi3oq+3JN3eLoI56q7UfbOJz0Y" +
       "W+EiPd2zGeZHNuVHcx1/oLTb3GG0xdHH/WL7xNYsikE714uN+3xT8r/4X/79" +
       "70MbdZ942mtn1i7JiN84M7sLYdc28/jRUxuQQ8PI6/3m54W/87nvfuqvbQwg" +
       "r/HyRSe8UWzxfFbnQ5ir+Wd+Lfiv3/mtL3/76qnRxPnylmiurWfbTv5l/ncl" +
       "//yf4lN0rtixnZmP4Tv38MJt/+AXZ/7gKVvuKdx8YhUWdKPvzRcTe2qrmmsU" +
       "Fvvn114Bv/GHn7m+tQk333NiUq/9YAGn+9+LlX7y13/0T5/fiLmiFyvVqf5O" +
       "q23d3+OnktEwVFcFR/bJ//D+v/dv1C/mjjR3XpG9Njb+qLTRR2kzgJWNLsqb" +
       "LXDuWLXYfCA6OxHunGtnIopb+me//UcPD/7on39vQ3tnSHJ23Luq/8bW1IrN" +
       "C1ku/unzs76tRlZeD36H++Hr7jvfzyUquUQ991cRH+auJrvDSna177nvv/2L" +
       "f/nUj/3GXaWrrdKD7kKdtNTNhCs9kFu6EVm5l8r8j39ia83p/SeOOSu9q/Nb" +
       "A3lm86uWA756ua9pFRHF6XR95n/zrvZTv/Nn71LCxstcsJCea68AX/3Cs/jH" +
       "/mDT/nS6F62fz97tfvPo67Rt9Rfnf3z1pXt/9WrpPqV0Xd+FdgPVTYpJpOTh" +
       "THQS7+Xh3x3H7wxNtuvwG7fd2XPnXc2Z0553NKduPy8XtYvyg+d8yzOFlskT" +
       "J3Pyfda3bFaD7RgXSDfpPBIzjfCx3/n7X/7TT36qcbUw6HuWBXquleun9bik" +
       "iCD/5lc/9/73vP3bP7uZ/CeiP7E5/Yub7Y1i86HN+N5VFD+c+4ZoE4zGeXds" +
       "T3U3xK/GpYfksUDe6nMdjh9y+01BCO157suWu5gIeOux7zhf+L2vbeOd8+N+" +
       "rrLx6bf/1l/e/MzbV89EmS+/K9A722YbaW4wH96wFjPpxX1n2bRo/c+vv/VP" +
       "/+Fbn9pSPXZnzETmlwRf+09/8a2bn//tf3vBIn5XHg9vnX6xhYoNup0qtUun" +
       "1RvvHvQXdoP+wgWDXhSwwlkXBXnfiBUbqti07xwqmpNJihSLfd1zsP0jYF/c" +
       "wb64B/ZqUfjhw2Dfs4Hl+l3sYtYfOYL1pR3rS3tYNzyTY1hZkqPk9kWsxhGs" +
       "L+9YX97DendRcA9jfd8Zvd7iBZnmOZTdo+f5Eew3duw39rDfUxTiw9gf3LCj" +
       "HMWSF6EmR6C+skN9ZQ/qvUXhJ45BxXmWv1Crbx2B+sEd6gf3oN5XFH76GFQB" +
       "zR3DRag/cwTqh3aoH9qDen9R+NuHoV7bopIiTnIySl1oBT93BO+Hd7wf3sP7" +
       "QFF4+zDexze8sohyUosXu7dYWrpQx587kLmVf17dMb+6h/nBovCFw5jv3y7o" +
       "In0R6BePAP3IDvQje0DfUxS+fBjoIxvQlkj2+iSHjy/C/coRuOUdbnkP7kNF" +
       "4auH4T6wtQW6e6HVfu0I0td2pK/tId2EPr9yGOn1s0vEZSb7jSOAX98Bv74H" +
       "eHPV88+OAd6uv5cCf/MI4Js74Jt7gK8VhX91jMulCfJil/urR6ACO1RgD+r1" +
       "ovCtoxYyApXRi1D/3RGolR1qZQ/qo0Xh24ehPnXWDHgxj3TbpEhfqOH/eAQ2" +
       "uMMG92A/VhT++zGL2sYYLjXe3zyCt7rjre7hfbwo/O4xvDhLC7cGKNu/0J39" +
       "jyN4oR0vtIf3iaLwh4fxPnqyoG1s4rI5990jiOEdMbyH+Mmi8L+OIcb7opQT" +
       "X6rjPz6CGNkRI3uInyoKf37MWiyg+cS7zFP8xRG4tR1ubQ/u03nhyt2H4T63" +
       "wSU5FGPJWxiKdyiR73PEpbq+cs8R8PUdfH0P/DOF8IcOg3/idiCx5b3MaVx5" +
       "+Ajoxg66sQf6vYXwJ47xzSeXnft885Unj8Bu7rCbe7CfLYQ/dwx2i89dcwvt" +
       "0uz4chN5/xHYP7TD/qE92O8rhN84DPv5s9j4riTRCnk5/itH4L+xw39jD/5z" +
       "hfDXjtb6kKSptnw59utHYH90h/3RPdjvL4TDh2E/fpqe2LfUXEGOYH5zx/zm" +
       "HubnC+EfPUbVHXJ8SxJYmiOly1X95hHYH9thf2wP9gcK4cQxK6TA05y8h5g8" +
       "gvjjO+KP7yF+oRDOHkb8wpZYJCVSHORWIgkkLt8SUZnmL+9A94gO7Kpuvy/p" +
       "wIuF8AOzxw/fDqMuW28OTR8XtOiOFt1D+1Ih/MD08XvPXxLunZGHJpMLcmxH" +
       "ju0hf7kQfmAy+cY2+GujIorL28Wyz9E4T5C5tXDU5cv9oVnmohP4rhP4nk4U" +
       "zFcOzDI/vfuv0F+F+9AMc8FN7LiJPdyvFMIPzDBfO115Lp2Uh6aZC15yx0vu" +
       "4f1gIfzANPOZhZ4gJVykBTm3F0nEL8c/NPXc2n1Oypfhf6gQfmDq+YlT/P3R" +
       "yaFJ6AKU2kFTe6ALpisHJqG3rgVDJbJYMG9Jbbq1x1oOTUcX5O0deXsP+auF" +
       "8APT0Y/tFnuRoznqcuRjstH0Dpneg/yRQviB2egtsiSg+F7kY/LSzA6Z2YNc" +
       "LoQfmJfepaEK22j/gOj1mPx0Z4fd2YP9WiH8wPz0+87NRZRg+tIe9mMy1uyO" +
       "nd3D/noh/MCM9Ta3zubLzEWkx6SquzvS7h7Sm4XwA1PVj9wmvXQ9PCZRze1w" +
       "uT24QCH8wET1e89dtu/919uVY/LW/I6c30NeKYQfmLd+9iRLUviNItimW/Tl" +
       "/864ckweW9ihC3vQwUL4gXns7X0aGM+zJMpdBHtM9rq3g+3tgS3uZ7tyYPZ6" +
       "O/XE/GLmItIfnLfeiMkh4tI91Zv1m5uhPjAh/fTM1W+c3JA4MMLIXng3Zm59" +
       "0/7J+OztT9ubyu+ELO4M+itCRmHpkVNh7MIz3/jZ3/3st37+5e9cLV1hTm64" +
       "KmrnAfWVwU9//9lPFP357oGmW/RH2tx/zKpR3N3c+WhMbneJOQPNxaW73cX/" +
       "Q5fiJ/w2HNHoyR871HAI1TLRaw8AejazyhncEJEMInUGIchoypRhYtVDND4W" +
       "mXG+Qoxlf0Xwfp2PEXzFJMhwZtFjSXF8ac51KhhqTlasNOkzZh/nBDwlVxiu" +
       "c+higNaEVmDGJKrwi5EUd8S8n0KvsoSqzaW0as4tyPfrojrioTIAQTGwjGNo" +
       "2akvIa8/HlqL6hg05WWaKmIwIU2mzYhgDwYRjnNSOhGNATufyULdCUygMURW" +
       "C920OArhuanTr4JMDQ6iYZfWeqk3w1OvhfXTWjnoSqYItgYEKE2cNtmYWy4m" +
       "QwKe902C8443V4rZoXqKC42N+SqbhQ2DrAxCqIuSY3aq9uasu5Dd+hLWVV0A" +
       "pZABuy29OXORqgwi8orwDLLOpp0ZFlfKhtMC/TY30ZehjfHrbm3oux3VnLRj" +
       "SU76BA+PkXLVlEeYHJcpqQ/1yi7R9DNDmK1HPcY3LSZjGFmgug61cOKeAyKO" +
       "ACZaIvkLWANrRNhn8h2G6GbBjFPgec3u2KzdCirJYOU0vUFAz6BEGtC61poH" +
       "Mu726HE6bGU+s9IWjXWUkqpSZSwp7FYp1+rFuVy5nx9sG3HMgPCiFlIeoltJ" +
       "0O63Kw1yrAWdTk+a02bX6SmDDJ4MoBHRHs/9CCdBwenCfAD5Oph02kOyAVHL" +
       "tmjRa9kXklhZUFpNkYJ+A9SHSKvMUFltGLUYYRxBPavaAdTYFhmujRtJ1O7E" +
       "TBUVIHyIgV5L7LYRioHqpI1MlzNbtCgb9lkF87SJT3Z93u7r4lBgNE5CenMF" +
       "InHOX8QLfc72W5KauJnpDqVEytAWOOOVbNZnNL8qusv1KhAjcmYDdGvd1x0Q" +
       "lFWyhZKLmmZrXE+qqQNE1Kp9cA14wCBeJrImuhBqYzV3Lbf6laDd4DoTUR/g" +
       "tjML7JoUqdhQw6qW0awak7GcISnt6BknKh4n0M1yU2fdug553kxYr/GyyKzx" +
       "hgwO0gHhNAUecjGl7g4bgUm5Q9/HqPbabph+rRutGKSiuLSTRuvOcCG12xON" +
       "0GstrwlmgLiEaFsNmkGLYYqews5Udg0R7gQ13wjKar/dV4I1uZwHi/nYqtcg" +
       "Opk7bG/puQSXwJRI9oXWyJWSyiAZSFN/WXF6swztVfrygMmy7kySkomzJMfy" +
       "cCLhHZJqOC0OYbvofARUqJowCcO2k/CB1JIdUV6Jk55cYQBaZUUmsyqhMgvn" +
       "bbs5jSfirBOT2aTCTAeiW1k3xmTmElVzZqGTOl3vtVJtIAFpeUZJuKLrhEXT" +
       "1caibdNqVaw08SE47/htVxR8NvFws0mOZEHH3OokNlvkumI46UQOFrPYZVwT" +
       "WfGdGTJXMU+wO/ESKXfHGUOriNEOmxnS1NrDbkLDQU9wfd4x1eoSs3iWIUbj" +
       "sOcYgwgGQStTgaWh5HMghBZ9RUmHrmICHhaOy9KqI0QKzK8nvtXltDkNIfSo" +
       "MaSCis93KLuLWdkUmSvDAKGlIIWqXSVRlIgfz6hcTcA860XL+gLqOoSYqkAc" +
       "B4xHD7C23Qul9gqHHZJeT5we1Bo3EnKphDJQS9WJp63L+hqF1qbrEfMknbs9" +
       "iQLndLtD1YyA7djiCHbKkWxxcRj1K844m9EKZ8s4J07CFimJsh3ZaCUaoCLC" +
       "1BJ+JS6rRDwiwXbMyxjEQAE14a1KItdU2ew5/YHfbTWGawtsZtFyqtl8HPQG" +
       "zfJyzSSr1J4t12OzMlZroqiMQp5e8bXAZxrLdaQshWG1UZlCfU93eEXtk/MV" +
       "EcBTkuLouo8OASBOQa1eXzcTb+QRziibSyu5V5a5fkJF0bphLtN88KbTBt2G" +
       "UWLa5bn2YqxTASMmcT/AG2xLh8hQr3SjNcZPFhQZ9Th4xWXGwJLH06wxCpuV" +
       "tcQBy2CE1akaB7FUw59CLGHIyboM4mC9mYLDKQfSGWGOnDUI1RCNGqeeT63r" +
       "nAKWJaJPQ4LjjgcQ4KzKc1gESSfgyjg1EJ0JWU0FkYgztFqlwaUKL41wzLBO" +
       "wk2xxrJNKkgNSRb6cgXOyhElQPUVGoAx3KP9ZROoIwPJq/UHczbDM3FsTfCA" +
       "BgWmOjCTZUR0PKLOMygo6dq4IY/LnlAO1+ICWcFSVSLtAEF7aipWSKuyxtQ6" +
       "qbuTblkHZblRrpWT/grhMwwc+NJsOaInXdwKdFkeDPkuxildNZq6yqzCD1ru" +
       "WuopnJo7Cq6Gjlr+KBlVnYY1nAvtth81I06rryGQ80asS7kzwa4CxJxp9saS" +
       "qwJtnSaAdS1QptB0GVfT8jgC3NV03gs7s6nnpa24TGsQMKP8UdXqduptqYMv" +
       "AIQNgdCbG3UREBuhZ6LBSOv6gsdkHVOvjkae5QFJnQcbluPNZ7lzsaRq06r2" +
       "Y1nq1lbUCprxESa3lHamN1hwVZ/3ksF6vk5HLVSvCoxjNzhVc2FH1U2upi3s" +
       "NpISI8lS1nOriQCR6UkIN4PpYDKaMX1v0AfF5bTcrPtrGNYhY0V2B+MMHfS9" +
       "cNLprcoTIc3YeraMl0PQWsNxVVP1ieZ7E6k8HFUSK03qk95gZeOIveiFZq0+" +
       "7OoUw1R7sVOrRE1tqnD+qBUQ6opZWS0MWNUBmgwBeihzlVUPnkppT9LUMmEy" +
       "S4uLJM2pGuxgFeIQvExcU69E/a7QBSFjmpsREZbBmrPQKh1/2aFB1ULI9VBp" +
       "LPn5DFXhSReFY6+tL5YBTMyMcgSUEyKD0xooRH5/qIDDrqctAxtGxrISmeAo" +
       "C4ZyK4AQRM9G2aqjhtOxvBgOa4I3q+rd3NcBaV/jhrPxgB3T8wYsQ2kNKjer" +
       "7fYKMiZs2PU6cLJuEY0ORdcLB+SNQVzpNdfToL0GjCGnEIjXWwbOwoNjwxkM" +
       "y1GFSTyK96wlqwnL8doRcqWkE4lyht2WLXvzGIVG6xGhKFo4GMzr3RqSR55u" +
       "MK7Wh30K53uNPNBiSC1qY2mSlEmpk7QVAfXYqA6Vba4XWgZhtPoDcpEyeVDg" +
       "6WMrspmVJKVOr4GPs6DDtIAFWw65FtZBO/Yg0EYqyrU6CixhBkYPHRJYNSta" +
       "TTLJSQvF1DSWhlUUH/TKHbqLYQIaCIghV/pErzeDFsS0rgl+lAcLKJeMDT/i" +
       "xmjf0SyaQkjXHJAVDJoihgdKHaQ6xrxg0NU6DievijqjOdx3xwJTQ1kQX00r" +
       "MN3As9k4iiOjo6CwjVhtv0ZmIldx6tjITiYJqiDsnDNdbpYNHNZqz2nd601g" +
       "WsZgH2HaDXI0WUrqtL7oEX2/v876VrIIFAzuY3aHgdsikUfcuOY1YQVBAwII" +
       "GrDCNmNNATIqsqDVsNscudycGDhtq0/RqWcOqEGimF2jvxQFXEEjmGFCLfcj" +
       "4zbJD8n88kekKiuLkyszVZAIRBjFna5ccVNWknC1li8GQSsTBFwmUmbWUdUw" +
       "mcbsei5N7RpaadQq1TmY1mwis2coL+dBsbVcI+7M6I6soTmM+s6g6faKK8th" +
       "g+kL6JxduelQV91yp0IMUqlX1zqzgJ5S5S42EFI/UJccmMdmnk+kdIO1tXmU" +
       "UBa71jxr5MJknC+Pdb0O2/VWI9MxL87Hgu1zBACKzQGX6xomxVBYLaXcM8+b" +
       "/HTA0sN6ZylYnDls8CTYtFOuz9p4lax6CwmcdfBylsU9wu6hsTL2w3CIzc02" +
       "FcCSVdiR2516RH/chrQa1rfak+6gj6oWKI8oneBEvitnBgU7rslxoNpz0VHu" +
       "ylmx1kVBL5gnE5gK0nl3nQlFnfGQyWUwlqmP4nBpEkMsUJG0p4Qty5rSi3XL" +
       "qeNDiSQhW7R1nrcWZDV3NmgPqs4IDkuEOHXS3PbTYR/XmHq5vpImZBJXJyNt" +
       "ZaYwD8ybzUWA6gwnt2syYZB6l0WwOYN6+aVIt46zPSsPYTK6gitMotSpsRaF" +
       "rjllo5TqA/g84iMIBCJkRrQJk6qy/Qy2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "hthKSQAA");
}
