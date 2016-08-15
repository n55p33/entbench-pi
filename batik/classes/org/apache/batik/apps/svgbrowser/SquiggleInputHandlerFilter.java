package org.apache.batik.apps.svgbrowser;
public class SquiggleInputHandlerFilter extends javax.swing.filechooser.FileFilter {
    protected org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler;
    public SquiggleInputHandlerFilter(org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler) {
        super(
          );
        this.
          handler =
          handler;
    }
    public boolean accept(java.io.File f) { return f.isDirectory(
                                                       ) || handler.
                                              accept(
                                                f); }
    public java.lang.String getDescription() { java.lang.StringBuffer sb =
                                                 new java.lang.StringBuffer(
                                                 );
                                               java.lang.String[] extensions =
                                                 handler.
                                                 getHandledExtensions(
                                                   );
                                               int n = extensions !=
                                                 null
                                                 ? extensions.
                                                     length
                                                 : 0;
                                               for (int i = 0; i <
                                                                 n;
                                                    i++) { if (i >
                                                                 0) {
                                                               sb.
                                                                 append(
                                                                   ", ");
                                                           }
                                                           sb.append(
                                                                extensions[i]);
                                               }
                                               if (n > 0) { sb.append(
                                                                 ' ');
                                               }
                                               sb.append(handler.
                                                           getDescription(
                                                             ));
                                               return sb.toString(
                                                           ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfYxUVxW/M/v9/QHLxwLLsiw0LHSm1FKDS7Ew7Jals7Bh" +
                                                              "KdGhZbjz5s7MY9+893jvvt3ZrVjaqKCJiJRSaoC/aKiEFjQ2arQNptG2aTVp" +
                                                              "i9ZqSo2aiFZiibEaUeu5974372NmFzHGSebOm3vPvfecc3/nd85956+hKtNA" +
                                                              "XUSlETqpEzMyoNIRbJgkHVOwae6AvqT0ZAX+8+6rW9eGUXUCNeewOSxhkwzK" +
                                                              "REmbCbRIVk2KVYmYWwlJsxkjBjGJMY6prKkJ1CGbQ3ldkSWZDmtpwgR2YiOO" +
                                                              "2jClhpyyKBmyF6BoURw0iXJNohuCw/1x1Chp+qQrPs8jHvOMMMm8u5dJUWt8" +
                                                              "Lx7HUYvKSjQum7S/YKCVuqZMZhWNRkiBRvYqa2wXbImvKXFBz8WWD28cybVy" +
                                                              "F8zCqqpRbp65nZiaMk7ScdTi9g4oJG/uQ59FFXHU4BGmqDfubBqFTaOwqWOt" +
                                                              "KwXaNxHVysc0bg51VqrWJaYQRUv8i+jYwHl7mRGuM6xQS23b+WSwtrtorbCy" +
                                                              "xMQnVkaPPbm79ZsVqCWBWmR1lKkjgRIUNkmAQ0k+RQxzQzpN0gnUpsJhjxJD" +
                                                              "xoo8ZZ90uylnVUwtOH7HLazT0onB93R9BecIthmWRDWjaF6GA8r+V5VRcBZs" +
                                                              "nePaKiwcZP1gYL0MihkZDLizp1SOyWqaosXBGUUbe+8HAZhakyc0pxW3qlQx" +
                                                              "dKB2AREFq9noKEBPzYJolQYANCjqnHZR5msdS2M4S5IMkQG5ETEEUnXcEWwK" +
                                                              "RR1BMb4SnFJn4JQ853Nt67rDD6ub1TAKgc5pIilM/waY1BWYtJ1kiEEgDsTE" +
                                                              "xr74cTznhUNhhEC4IyAsZL79mev3ruq69IqQWVBGZltqL5FoUjqTan5jYWzF" +
                                                              "2gqmRq2umTI7fJ/lPMpG7JH+gg4MM6e4IhuMOIOXtv/o0wfOkffDqH4IVUua" +
                                                              "YuUBR22SltdlhRj3EZUYmJL0EKojajrGx4dQDTzHZZWI3m2ZjEnoEKpUeFe1" +
                                                              "xv+DizKwBHNRPTzLakZznnVMc/y5oCOEauCLGuG7GIkP/6VIjea0PIliCauy" +
                                                              "qkVHDI3Zb0aBcVLg21w0Bagfi5qaZQAEo5qRjWLAQY7YA1jXzag5nk0Z2gSw" +
                                                              "YXR0nyVnswqwmW7RzVhNg32DsgLoijDc6f/3HQvMB7MmQiE4noVBclAgrjZr" +
                                                              "SpoYSemYtXHg+nPJ1wTwWLDY3qOoH5SICCUiXIkIUyLiKhGZXgkUCvG9ZzNl" +
                                                              "BCzgUMeAHoCfG1eMPrRlz6GeCsCjPlEJJ8JEe3x5KuZyiEP8SelCe9PUkiur" +
                                                              "XwqjyjhqxxK1sMLSzgYjC4Qmjdkx35iCDOYmkm5PImEZ0NAkkgYemy6h2KvU" +
                                                              "auPEYP0Uzfas4KQ5FtDR6ZNMWf3RpRMTj+585I4wCvtzB9uyCmiPTR9hjF9k" +
                                                              "9t4gZ5Rbt+Xg1Q8vHN+vuezhS0ZODi2ZyWzoCaIj6J6k1NeNn0++sL+Xu70O" +
                                                              "2J1iiEYgzq7gHj5y6neIntlSCwZnNCOPFTbk+Lie5gBKbg+HbRt/ng2waGDR" +
                                                              "ugy+PXb48l82Okdn7VwBc4azgBU8kdwzqp/6+U9+/zHubifntHiKhVFC+z08" +
                                                              "xxZr54zW5sJ2h0EIyL17YuTxJ64d3MUxCxJLy23Yy9oY8BscIbj586/se+e9" +
                                                              "K2cuh12cU0j0VgrqpULRSNaP6mcwEnZb7uoDPKkAczDU9D6gAj7ljIxTCmGB" +
                                                              "9Y+WZauf/+PhVoEDBXocGK26+QJu//yN6MBru//axZcJSSxPuz5zxQT5z3JX" +
                                                              "3mAYeJLpUXj0zUVPvYxPQRoB6jblKcLZOGTHOlNqHkVr/it+4Ue+hq9xB2/v" +
                                                              "Yu7iKyM+tpY1y0xv6Pij01ONJaUjlz9o2vnBi9e5rf5yzouUYaz3C3CyZnkB" +
                                                              "lp8bpLbN2MyB3F2Xtj7Yqly6ASsmYEUJ6NzcZgDZFny4sqWran7xg5fm7Hmj" +
                                                              "AoUHUb2i4fQg5iGK6iA2iJkDni7on7xXQGOiFppWbioqMb6kgx3P4vIHP5DX" +
                                                              "KT+qqe/M/da6s6evcIzqYo0FRU5e6ONkfilwaeHcWx//6dmvHp8QZcWK6bkw" +
                                                              "MG/e37cpqcd+/bcSl3MWLFPyBOYnoudPdsbWv8/nu3TEZvcWStMdULo7985z" +
                                                              "+b+Ee6p/GEY1CdQq2UX4TqxYLMgTUHiaTmUOhbpv3F9Eioqpv0i3C4NU6Nk2" +
                                                              "SIRumoVnJs2emwLc18yOcCV8u21a6A5yXwjxh/v5lNt428ea2x2qqdMNjYKW" +
                                                              "JB1gm6YZlqWoJicijf29WxAsaz/BmrhY6Z5ygBRDt7FmZXE//qkOVmBednMR" +
                                                              "h1hYLZquSOYF/pnHjp1Ob3t6tcBcu7/wHIB71bM/++frkRO/erVMPVNHNf12" +
                                                              "hYwTxbNnmG3pQ/kwvz+4kHm3+ehvvtub3XgrRQfr67pJWcH+LwYj+qYPnKAq" +
                                                              "Lz/2h84d63N7bqF+WBxwZ3DJrw+ff/W+5dLRML8sCSyXXLL8k/r9CK43CNwK" +
                                                              "1R0+HC8tAmAWO9j58F1uA2B5+RxeBjvFzDjd1EAWCOSXRk59sgb8oRC+C5kh" +
                                                              "bcis2QP5mTG2Tv0FKTvvUStlQvEo56FWGLdvX3eO7JEO9Y78VsBxfpkJQq7j" +
                                                              "meiXd76993V+cLUMKUV3eVACiPKUQa3CDx/BJwTff7Ev05Z1sF/go5h9leou" +
                                                              "3qUYhc/IxQEDovvb3xs7efVZYUCQeAPC5NCxL30UOXxMxJa4kC8tuRN754hL" +
                                                              "uTCHNSrTbslMu/AZg7+7sP97z+w/GLbP5lNASilNUwhWSw4baj+/24Wum77Y" +
                                                              "8v0j7RWDELVDqNZS5X0WGUr7kVtjWinPObh3eBfHttbM5xSF+pwMybkQz8CF" +
                                                              "/0FyZh0xnfc/WIR8u0PJfTbk+249WqabOgP4PzfD2BdY8whFzVlCNxFTMmS9" +
                                                              "yDkQZa08ylhOjIgXK66DDvwvHFSgqHP6eyYrceaVvPwSL2yk50631M49/cDb" +
                                                              "nLmLL1UaIQIzlqJ4k7DnuVo3SEbmljeKlKzznyNwkbxZwUpRvfuHG/QVMflx" +
                                                              "ijrKTqaokv14ZY+DT4OyFFXxX6/cU7CbK8eIiz94RU5SVAEi7PGU7hxYD38/" +
                                                              "EDEn4Kwi7DWKlNM0Vm0zmhReLYT8Wbl4oh03O1FPIl/qIyH+HtOJUku8yYQL" +
                                                              "/ektWx++fvfT4oYmKXhqiq3SALEpLovFPLZk2tWctao3r7jRfLFumUMabUJh" +
                                                              "N14WeEAdA+rQGXg6A9cXs7d4i3nnzLoXf3yo+k2gu10ohCmatau0ACzoFhQQ" +
                                                              "u+KlHAQ5n9+r+ld8bXL9qsyffslLbFRSWAflk9Llsw+9dXTeGbh/NQyhKuBD" +
                                                              "UuCV6aZJdTuRxo0EapLNgQKoCKvIWPERXDPDOWaByP1iu7Op2Mvu9wCCUtou" +
                                                              "fSsC15EJYmzULDVtU2SD2+N7weqUApauBya4PZ7UVhCsKrJYRTI+rOtOVqto" +
                                                              "0nngTwaJnnfyiRf5I2u+8W9FifSb4xgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
