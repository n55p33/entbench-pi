package org.apache.batik.dom;
public abstract class AbstractDOMImplementation implements org.w3c.dom.DOMImplementation, java.io.Serializable {
    protected final org.apache.batik.dom.util.HashTable features = new org.apache.batik.dom.util.HashTable(
      );
    { registerFeature("Core", new java.lang.String[] { "2.0", "3.0" });
      registerFeature("XML", new java.lang.String[] { "1.0", "2.0",
                      "3.0" });
      registerFeature("Events", new java.lang.String[] { "2.0", "3.0" });
      registerFeature("UIEvents", new java.lang.String[] { "2.0",
                      "3.0" });
      registerFeature("MouseEvents", new java.lang.String[] { "2.0",
                      "3.0" });
      registerFeature("TextEvents", "3.0");
      registerFeature("KeyboardEvents", "3.0");
      registerFeature("MutationEvents", new java.lang.String[] { "2.0",
                      "3.0" });
      registerFeature("MutationNameEvents", "3.0");
      registerFeature("Traversal", "2.0");
      registerFeature("XPath", "3.0"); }
    protected void registerFeature(java.lang.String name, java.lang.Object value) {
        features.
          put(
            name.
              toLowerCase(
                ),
            value);
    }
    protected AbstractDOMImplementation() { super(); }
    public boolean hasFeature(java.lang.String feature, java.lang.String version) {
        if (feature ==
              null ||
              feature.
              length(
                ) ==
              0) {
            return false;
        }
        if (feature.
              charAt(
                0) ==
              '+') {
            feature =
              feature.
                substring(
                  1);
        }
        java.lang.Object v =
          features.
          get(
            feature.
              toLowerCase(
                ));
        if (v ==
              null) {
            return false;
        }
        if (version ==
              null ||
              version.
              length(
                ) ==
              0) {
            return true;
        }
        if (v instanceof java.lang.String) {
            return version.
              equals(
                v);
        }
        else {
            java.lang.String[] va =
              (java.lang.String[])
                v;
            for (int i =
                   0;
                 i <
                   va.
                     length;
                 i++) {
                if (version.
                      equals(
                        va[i])) {
                    return true;
                }
            }
            return false;
        }
    }
    public java.lang.Object getFeature(java.lang.String feature,
                                       java.lang.String version) {
        if (hasFeature(
              feature,
              version)) {
            return this;
        }
        return null;
    }
    public org.apache.batik.dom.events.DocumentEventSupport createDocumentEventSupport() {
        return new org.apache.batik.dom.events.DocumentEventSupport(
          );
    }
    public org.apache.batik.dom.events.EventSupport createEventSupport(org.apache.batik.dom.AbstractNode n) {
        return new org.apache.batik.dom.events.EventSupport(
          n);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06aczs1lV+X957eXlN8l6SNk1D9rwuicPnGc/imaZLPPZ4" +
       "xp6xPZ59DG3q3Z7xNl5m7Clpm1JIRaU2grQUqQ0/aAWUtCmIiiJUlApBW1oQ" +
       "hYpNoq0QEoVSqflBQQQo155ve99bQpTCSL5z595zzj3n3HPOPb5nnvkedCoM" +
       "INj37NSwvWhXS6LduV3ZjVJfC3eZbqUnBaGmErYUhkMw9qhy32fP/eCFJ83z" +
       "O9BpEbpFcl0vkiLLc8O+Fnr2SlO70LnD0aatOWEEne/OpZWExJFlI10rjB7u" +
       "Qq84ghpBF7r7LCCABQSwgOQsIPghFEC6QXNjh8gwJDcKl9C7oBNd6LSvZOxF" +
       "0L0XE/GlQHL2yPRyCQCFM9nvMRAqR04C6J4D2bcyXyLwh2HkqV98+/nfugY6" +
       "J0LnLHeQsaMAJiKwiAhd72iOrAUhrqqaKkI3uZqmDrTAkmxrk/MtQjeHluFK" +
       "URxoB0rKBmNfC/I1DzV3vZLJFsRK5AUH4umWZqv7v07ptmQAWW89lHUrIZWN" +
       "AwHPWoCxQJcUbR/l5MJy1Qi6+zjGgYwXOgAAoF7raJHpHSx10pXAAHTzdu9s" +
       "yTWQQRRYrgFAT3kxWCWCbr8i0UzXvqQsJEN7NIJuOw7X204BqOtyRWQoEfSq" +
       "42A5JbBLtx/bpSP78z3uTR98p9t2d3KeVU2xM/7PAKS7jiH1NV0LNFfRtojX" +
       "P9j9iHTrF96/A0EA+FXHgLcwv/NTzz/y0F3PfXkL82OXgeHluaZEjyqfkG/8" +
       "+h3EA/VrMjbO+F5oZZt/keS5+ff2Zh5OfOB5tx5QzCZ39yef6//R7D2f0r67" +
       "A52lodOKZ8cOsKObFM/xLVsLWpqrBVKkqTR0neaqRD5PQ9eCftdyte0or+uh" +
       "FtHQSTsfOu3lv4GKdEAiU9G1oG+5urff96XIzPuJD0HQefBAd4Pn9dD289qs" +
       "iSAJMT1HQyRFci3XQ3qBl8kfIpobyUC3JiIDq18goRcHwAQRLzAQCdiBqe1N" +
       "qJ6D4DIwckmJSJ6lHR+ECICc+8puZmr+/8ciSSbp+fWJE2AT7jgeAmzgPW3P" +
       "VrXgUeWpuNF8/jOPfnXnwCX2dBRBu2Dd3e26u/m6u2Dd3SuuC504kS/3ymz9" +
       "7X6D3VoAvwcR8foHBm9j3vH++64BhuavTwJVZ6DIlQMzcRgp6DweKsBcoec+" +
       "un58/O7CDrRzcYTNeAZDZzP0XhYXD+LfheOedTm65574zg+e/chj3qGPXRSy" +
       "91z/UszMde87rt3AUzQVBMND8g/eI33u0S88dmEHOgniAYiBkQRsFoSXu46v" +
       "cZELP7wfDjNZTgGBdS9wJDub2o9hZyMz8NaHI/m235j3bwI6vhHaM/DWnpHn" +
       "39nsLX7WvnJrJtmmHZMiD7dvHvgf/+s//adSru79yHzuyFk30KKHj0SDjNi5" +
       "3O9vOrSBYaBpAO7vPtr7hQ9/74mfyA0AQNx/uQUvZC0BogDYQqDmn/ny8m++" +
       "9c1PfGPn0Ggi6Do/8CLgLZqaHMiZTUE3XEVOsODrDlkCAcUGFDLDuTByHU+1" +
       "dEuSbS0z1P8899ri5/7lg+e3pmCDkX1LeujFCRyOv6YBveerb/+3u3IyJ5Ts" +
       "QDtU2yHYNkreckgZDwIpzfhIHv/zO3/pS9LHQbwFMS60NloetqBcDVC+b0gu" +
       "/4N5u3tsrpg1d4dH7f9iFzuSeDyqPPmN798w/v7vP59ze3HmcnS7Wcl/eGth" +
       "WXNPAsi/+rizt6XQBHDl57ifPG8/9wKgKAKKCghjIR+AiJNcZBx70Keu/dsv" +
       "/sGt7/j6NdAOBZ21PUmlpNzPoOuAgWuhCYJV4r/1ke3mrs/sx+8EukT4rVHc" +
       "lv86CRh84MohhsoSj0Mvve0/eFt+79//+yVKyIPLZc7bY/gi8szHbife8t0c" +
       "/9DLM+y7kkujMEjSDnHRTzn/unPf6T/cga4VofPKXgY4luw48x0RZD3hfloI" +
       "ssSL5i/OYLbH9cMHUeyO4xHmyLLH48th9Af9DDrrnz0WUl6ZabkOnof2XO2h" +
       "4yHlBJR33pqj3Ju3F7Lm9fme7GTdN0RgZcuV7D0X/iH4nADPf2dPRi8b2J7H" +
       "NxN7ScE9B1mBD86mM7q2zThzAq+KoPsve1gdGNkwc89tsMtaNGse2a5euaJd" +
       "vTFryOQEiDqn0F1st5D97lxermsikKjHsm0BXz8d5jl0Nknk6iMj4Ci2cmFf" +
       "ljFIqIFlXZjb2D7/53OnyPZwd5uFHmOW/F8zC4z+xkNiXQ8ktB/4hye/9qH7" +
       "vwUsk4FOrTKrAQZ5ZEUuznL8n33mw3e+4qlvfyAPtyDWjt/3wu2PZFTHVxA5" +
       "6/JZ07tI1NszUQd57tKVwojNw6Om5tJe1SF7geWAg2S1l8Aij938rcXHvvPp" +
       "bXJ63PuOAWvvf+rnfrj7wad2jrwS3H9JVn4UZ/takDN9w56GA+jeq62SY1D/" +
       "+Oxjv/drjz2x5ermixPcJnh/+/Rf/tfXdj/67a9cJqM6aXsvY2OjGz/bLoc0" +
       "vv/pFkUNXY+SxNH5MqeXCX1lrgszoebN1QrR9KNBMzENecjWerNJx/fDNosp" +
       "pQoVI1E3iDb1uDXilo3RoulTdqNBFMLhsl0dLKgmM7LlKrns0BM6Yugm5xWC" +
       "UWfZc+xhsUMspfEU5LC1UlyKsQhRjEFn5GLqRtmQWg+rrPQ6EsPoMKq4o3WB" +
       "VLv0uIFZcanvmJE/Li1CblGbSlRrKU2qjWjUXi7NXqWIYtO4OKIG/IJYNuvD" +
       "cLGcM7wzcBJ23ShYRMAstWXCJnHi0GUvUg1mzrU6jFJUZw12USvxfgejF2GK" +
       "RQ2TNKaVZb9pqBU1FbzU5fm4wPAth143MWJm6ebYrZcG5T5rz/t1Ow3hQtrT" +
       "KrHdSKUBZoc2I0+EdltqmxSjjZWmgGqjlUSzUWGoLop+y6glHF2LmpwoipEx" +
       "QvvjueFI06VfQWC50e8U1uv+AAjlTau+IzvSwqfT9YQejmMJWxGLWORrtj1o" +
       "Wq1hj+0oXFNT+gq/lhrGRJX7RX9ClsajhGPUsOAJlZJoBWNGXQvMOk6ZessX" +
       "xB7KdYvWZtMgeVktUmWugSILUR4UIqXYrym2W65RPVkK6n3B8VoDGg3rMYUy" +
       "nNE0C6PWuoOHrcmkhfaX3VA18OW4Z4a9eEaPOaodcL04qo7M4rAzKpG1ue2s" +
       "WWm0EaobHzUCvjkVNiOzO53TSVURmh5c15txs9MWON0PltWJaZZmpOFP0gBP" +
       "6EK5oSKSQCh82oq5hevWm/1Qd4ZlGieJYpf1MYFdRNyIWBQWba9LG/7YrDF1" +
       "nCwWiabgSkYDNyo9sTFQqQkcjVpLkZQbeL8q9oJI9vHlgp7hnrpmw8KKcSRi" +
       "VAkiPp324PFmNXV7RnM6mbcsoYG2eXYgBLGe0Ky0Ejg03FibFmk06jKejsJ5" +
       "H54XbERpE0LblIYVcwDLsou5SbnXbSmJEjpDuyK2lxZfmTcb1fG8oPldpR5P" +
       "AgJryOIwcCx3Xp6ofjdIwyJc8QfaCmc5dsOijJvyi1qEgDf3UlBotMPSgPCw" +
       "geQsOtJiUe6YfMHvVAOyMceLvCgMna4q0h0/lKV+u+Z2Zly1T0liUfWG80rM" +
       "qhWasRxjWVT6K5ZqKv4CH45HjDqOeWlUV/xh2axOLK1ZZBmyElIbCmvCFkYa" +
       "Jj0bTvwOtRz1xxN1SqxmUgv2I3PGrD2UnPXnRndp1njHntO44bS5Fu4P180W" +
       "gfYLSbdvx3OhSy+V4bReEsyGTC/IhgQ3Fx2vqsO9vgq+xWFfwHF+JlV13Byu" +
       "XQ+Vmk6v5bWFciRh9cSLSSotlr3RasbF9KLBx62gPSZnUUEIGuEyJspMg+2n" +
       "oxJVr2IbM6LlBlamykyK+FppPqyvihwj4AV9KhBOw6ccjCZGTNQljeqcLCzd" +
       "anXVouxEhUdLYUhbgmYbpX5/wjLVUqtJEmOutcZqsOCZxKwkhJtSHzdYeTZz" +
       "wr4hjDsUPVPqg8ArrPF6WAFxWlzPbL3acc111JxjCMbEEj/XEA8cHwxtRHYD" +
       "FzWFaKetdSnup3N+VNLWrlHabIpxitVXmE9jYdFOpNQDL2VtoE7PqHD6gixv" +
       "hqzXFYu9zTqFV91IdLoFQmKioUJyRtKUkZbthAWYXvO8PyCNoM0NOIbSklSm" +
       "NkyzPEOrwYz2OYmB7QHeH04SfdohMVG3WqXYrRbnfMgQHN/jfHrQbeKlUlXZ" +
       "1BFkhpQIl8XW0rC1WE8LrIpZ9JBQAqoijMVCF00LrVlKlupRW2Mq1drKgYM1" +
       "kdBdNgWOzE/kUUNR6L5RCes62nMnfFHrTQWnyvPaQpgrBdLA+FnssG5kUksv" +
       "8AghjNVAabY7c5zELaXiqSOjYyg2ao9mmikjVV+Mel3WXSOjid0QPHbcAN4r" +
       "D2EC3RT9djtAy5gGczN/iZtke8aJYSCabYxq68445I24hOvVITptVcrwsAKT" +
       "TbxVkFl/PiTxqDmZGeUomRB6cWr1aHhaR+oTYp2u9HlPnVO9YC54bXmTTu0p" +
       "oqHqyuKKDlNcaWW4amleTLHEeuKj7WprWoHRxZxrsHNVrWJYAZt2YjFcl9ck" +
       "28HbG2deaC1aQpVIUrTODtIpslnbmit3KxNhhmv+mBSkapUkNgWDwplUJDRy" +
       "GvWqTKNaItuDYklYVKUKYemFMt5yfR2pcsshb+qt9mrFz1twzAPBxkKDi2Bp" +
       "tkjbk3jsNjs2gxYxtbdqt5FhuY5UFcuj9MGUImaFEmaJCJz0wcsG2O+asliH" +
       "y7TCCzA765nNGsxjUYTJIH9hQ5/vehW3HzsGo6uhrimDXjlCqWHVS3G/lRLF" +
       "hV+w6kXWNsVyFW85ZlUbcoum6NYnIPGmZnCh0jU3XRvuAWJVVNlwm4RoS5Nk" +
       "Go/mbHtDS641QcvVeqlZN/ABvXQnXXoqMYoVTtXyyiImeDGZUPZkqdHzOWFT" +
       "lXiy6LHVkKPWrBO6zDpY93t4b94dGTjlFy142Aw5exFEcZ+UgwCfz11lNGb6" +
       "MR80qKWltgNDpio1ialx6SooshWULlX5tIZPFVhb1hacnw6luTkYLz1TqrbZ" +
       "uSCMBLO+6jD9noWt8FBG2wnK1jdVuNDu4DBfUCMzXc2WIlKHsalQGMN1x1J8" +
       "EKQkPdCJvj+30KGo+WacTjuV7pQcK0i3ouqaUSqhBW3iKpgkpCinlq2R0tZr" +
       "BYLxZ5M62oXHtdIK4dqrLhoOUbRm0pWVy1ZFJJWKBXdaR9cT0htRPWWZYlSK" +
       "OT3RKC7TkuQOZnRDUUfxZJSW2I3haQartnx9ojrJiNZbnaRL6gJlBkui4DZk" +
       "gpwQnmGqs0GIoi2N9KJh0pBGtEHxLFcQEmCMpNAi2WqPVCPNYrgkSJs2PR7J" +
       "4aRYLKtIAVvX6hqPjs1iDS73nBaKIPi0Zxgq39qYKHiV6NbSytIN2pO2aodq" +
       "UUrLgr4mFHxTQtbCGF3jMtwY11chUV/VNnSBEypUgzKHsm1bVnkNu2oJQUy1" +
       "hBmBGJXxcn02GgxnabnPzDyhMFNoT50LSy9COzOW8pvIAG/CpflsGtNzMi0U" +
       "1/gSKcDCshyytg3P+HbPJ+bN2Sru4LyYdHvieuQ7hu+F4011xLQkYdWYbQIe" +
       "UTEtULtwJcJ0NG6IlKThoqxEDZ2Ywgmi1NTAMILOYhqmZDw32xruDau+ZhWm" +
       "Emv0SkVWKXdm0dIJO55jN50F0BlI7VbrsQ8jGguCujmb1umGz5lMavPLFdmj" +
       "eLCHCdVw/GVHA9KvRsVUCttaM+YFkAEPGRNkzfWo3KC48bxUTMrAu436OBYK" +
       "E77igJyo3uRMMVjTYgBCjcrjzqDdkpXEsGBJqjALbAbeltCemmisGK4UMS6l" +
       "A8o0xX49jih4UTFr4zEvLkKQ9baiYlUYVQwkootkwZ/2VRYzycpglfqLBQtS" +
       "aGE9axMOq68MknJnUX2g9eQZFdkbuDYLOa7vsqzakEds2OkFLT8JlXG6qa8G" +
       "jNMrr6jWzODsyN04ejhPlFQt1TY6nG2NUmICmlkFCMlzw547ld2ibqtVRU4d" +
       "nZXLAgp3MKK0Id1ZqrRmNX8w1yblljtdenKXKHe9QopihlWFux6uTUKYKDUG" +
       "+HI6Q9p2t2YxCxCnmbhh0XIVUaowGQdmsigXZapTohnRUPoBhU2IqrLGR/XB" +
       "YLMu8HFxUg9rbE0uO+tx0kKaK5NtIx3Yr1sj0quvli62AAmqrlaqwwHrq601" +
       "K1YWTb0F11lluXCNsLOJZXYs+0mqlJZ26k14yW66MvCVgu5oPCkSznxakxIX" +
       "LlYMh0XFemKu2mPwnmXp2CCtk8VgMG4QhjvCZGdqkUPN8FNkifZLXaMlyX45" +
       "rHfSCmOrUkVvIwjTVUYjl++rmxWSAgecltdoTXFcJ2RHhqOKHWZBTJKoOxeD" +
       "CLZlRx5YJIUvncGmN0MrXi0wVz475jph3zaFzbjVnKKVZOyMxVqqqMwIxVAb" +
       "iZYR1e33fScZLmKfHa7CocvI4aoMhxKlETq2bIGzWWuDHL8oLZKIxXt4pRW7" +
       "QzUdiN3Vct3lSiVw1qHWaLaBXcm0avoKwVfKyu+vGm3wipq9uhov7fbgpvyi" +
       "5KB2N7exbKL/Et6ak6vcPPERdEbaq2Ac3h/nn3P7RaD976P3x4eXijv7NzZ3" +
       "ZjdO65KSXzRdUg3Zh9pWQyxv96BoKttadtNw55VKfvktwyfe+9TTKv/J4s7e" +
       "fa4cQddFnv/jtrbS7CPcZOXtB698o8LmFc/De8Yvvfefbx++xXzHSyig3H2M" +
       "z+Mkf5195iut1yk/vwNdc3DreEkt9mKkhy++azwbaFEcuMOLbhzvvLiI8Wbw" +
       "7G319vvSIsZlN/1Eft24ta1j1+U7h1bRv8wt3PYmNcf86atctD+RNe+KoHOB" +
       "ZlhhpAXU3sVkNv62I6YqRdDJlWephzb87he7+Tm6Vj7wzgOl3JIN3gkebk8p" +
       "3EtVCv+iSsmbHOqpqyjgI1nzoQg6a0rhVWS/VvY8W5PcQ/GffBni35wN3gEe" +
       "f098//9S/F+5ivifzJqngfiGFu2Jn42871DOX34Zct6TDb4RPJs9OTc/GjmP" +
       "SvDsVeZ+M2s+FUG3KwGQDaSUSpxFuOYKNIPY970g2nedwmUv4LUMMty9ImKu" +
       "od94GRq6LRt8EDyP72no8R+Nhk7sFan3pLv3qrVwzlO1nMoXrqLLL2bN5yPo" +
       "5q0uL6fDN1xNh5fX3e++FN0lEfSaK9bvs0rkbZf8W2j7DxflM0+fO/Pqp0d/" +
       "lZewD/6Fcl0XOqPHtn20cHSkf9oPNN3Khb9uW0by868/Bsfi5SSNoGtAm3P9" +
       "lS3kn4CQfBwygk7l30fh/gw44CFcBJ3edo6C/AWgDkCy7jdyy3hfcuLIQbpn" +
       "WLlOb34xnR6gHK1jZ4dv/p+s/YMy3v4r61Hl2acZ7p3PVz+5raMrtrTZZFTO" +
       "dKFrtyX9g8P23itS26d1uv3ACzd+9rrX7icGN24ZPjTyI7zdffmKddPxo7zG" +
       "vPn8q3/7Tb/69Dfzgs//ACz2v5ksJwAA");
}
