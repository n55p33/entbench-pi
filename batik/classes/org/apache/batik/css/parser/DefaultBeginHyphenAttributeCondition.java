package org.apache.batik.css.parser;
public class DefaultBeginHyphenAttributeCondition extends org.apache.batik.css.parser.DefaultAttributeCondition {
    public DefaultBeginHyphenAttributeCondition(java.lang.String localName,
                                                java.lang.String namespaceURI,
                                                boolean specified,
                                                java.lang.String value) {
        super(
          localName,
          namespaceURI,
          specified,
          value);
    }
    public short getConditionType() { return SAC_BEGIN_HYPHEN_ATTRIBUTE_CONDITION;
    }
    public java.lang.String toString() { return "[" + getLocalName(
                                                        ) + "|=\"" +
                                         getValue(
                                           ) +
                                         "\"]"; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYe2wcRxkfn99v+/JsHnbsOEF53TaQVFROS2zHTpyeHStO" +
                                                              "I+GQXOb25u423tvd7M7aZxdDE6mKCyJEIW1D1foPcNWC2qZCVICgVVAl2qoF" +
                                                              "qSWiFNQUCSTCI6IRUvkjQPlmZm9fd3YShMRJO7c388033/P3fXPPX0eVlona" +
                                                              "iEZjdMogVqxfoyPYtEiqT8WWdQjmEvIT5fjvx64N3xtBVWOoKYutIRlbZEAh" +
                                                              "asoaQ2sVzaJYk4k1TEiK7RgxiUXMCUwVXRtDyxRrMGeoiqzQIT1FGMFhbMZR" +
                                                              "K6bUVJI2JYMOA4rWxkESiUsi9YSXu+OoQdaNKY98pY+8z7fCKHPeWRZFLfET" +
                                                              "eAJLNlVUKa5YtDtvoi2Grk5lVJ3GSJ7GTqg7HRPsj+8sMkHnS80f3zyXbeEm" +
                                                              "WII1TadcPesgsXR1gqTiqNmb7VdJzjqJvoTK46jeR0xRV7xwqASHSnBoQVuP" +
                                                              "CqRvJJqd69O5OrTAqcqQmUAUdQSZGNjEOYfNCJcZONRQR3e+GbRd52ortCxS" +
                                                              "8bEt0oUnjrV8rxw1j6FmRRtl4sggBIVDxsCgJJckptWTSpHUGGrVwNmjxFSw" +
                                                              "qkw7no5aSkbD1Ab3F8zCJm2DmPxMz1bgR9DNtGWqm656aR5Qzq/KtIozoOty" +
                                                              "T1eh4QCbBwXrFBDMTGOIO2dLxbiipShqD+9wdex6AAhga3WO0KzuHlWhYZhA" +
                                                              "UREiKtYy0iiEnpYB0kodAtCkaNWCTJmtDSyP4wxJsIgM0Y2IJaCq5YZgWyha" +
                                                              "FibjnMBLq0Je8vnn+vCusw9p+7QIKgOZU0RWmfz1sKkttOkgSROTQB6IjQ2b" +
                                                              "44/j5a/MRhAC4mUhYkHzgy/e2L217fIbgmZ1CZoDyRNEpgl5Ptn0zpq+TfeW" +
                                                              "MzFqDN1SmPMDmvMsG3FWuvMGIMxylyNbjBUWLx/82ecf/i75SwTVDaIqWVft" +
                                                              "HMRRq6znDEUl5l6iERNTkhpEtURL9fH1QVQN73FFI2L2QDptETqIKlQ+VaXz" +
                                                              "32CiNLBgJqqDd0VL64V3A9Msf88bCKFqeFADPGuQ+PBviiwpq+eIhGWsKZou" +
                                                              "jZg609+SAHGSYNuslISoH5cs3TYhBCXdzEgY4iBLnAXZslhmAhBKe0ga2yrt" +
                                                              "JRlF2zdlZInmYhukV4pbIsaCz/j/HJtn1lgyWVYGjloThgkVMmyfrqaImZAv" +
                                                              "2L39N15MvCVCkKWNY0eKdoMkMSFJjEsSA0liQpLY7UiCysq4AEuZRCJKwMfj" +
                                                              "gBYA1w2bRo/uPz7bWQ7haUxWgIMYaWegbPV5kFKoAwn5UrRxuuPq9tciqCKO" +
                                                              "olimNlZZFeoxM4Bv8rgDAQ1JKGheXVnnqyusIJq6TFIAawvVF4dLjT5BTDZP" +
                                                              "0VIfh0LVY/ktLVxzSsqPLl+cPHX4y3dHUCRYStiRlYCCbPsIKwAu0HeFIaQU" +
                                                              "3+Yz1z6+9PiM7oFJoDYVSmrRTqZDZzhEwuZJyJvX4ZcTr8x0cbPXAthTDMkJ" +
                                                              "ONoWPiOAVd0F3Ge61IDCad3MYZUtFWxcR7OmPunN8Nht5e9LISzqWfJK8HQ6" +
                                                              "2cy/2epyg40rRKyzOAtpwevKfaPG07/+xZ8+w81dKEHNvt5hlNBuH+wxZlEO" +
                                                              "cK1e2B4yCQG6Dy6OfOOx62eO8JgFivWlDuxiYx/AHbgQzPzIGyff//Dq/JWI" +
                                                              "F+cU6r6dhPYp7yrJ5lHdIkrCaRs9eQA2VcAQFjVdD2oQn0pawUmVsMT6Z/OG" +
                                                              "7S//9WyLiAMVZgphtPXWDLz5u3rRw28d+0cbZ1Mms7Lt2cwjE7Vgice5xzTx" +
                                                              "FJMjf+rdtd98HT8NVQWQ3FKmCQfnCm6DCq75Suji+E5WoWOiQrP5e4JIwLJt" +
                                                              "1E5akLVKDpw04VTBT48cl2e7Rv4gKtxdJTYIumXPSV87/N6Jt3kI1DBcYPPs" +
                                                              "oEZf1gN++OKvRbjmE/iUwfNv9jCXsAlRTaJ9Tklb59Y0w8iD5JsWaUKDCkgz" +
                                                              "0Q/Hn7r2glAgXPNDxGT2wlc+iZ29IPwqGqP1Rb2Jf49ojoQ6bOhm0nUsdgrf" +
                                                              "MfDHSzM/fm7mjJAqGizz/dDFvvCrf70du/i7N0vUjOqkrqsECzDbwYLdhfal" +
                                                              "Qf8IpfY82vyTc9HyAUCVQVRja8pJmwym/Fyht7PspM9hXtPFJ/zqMedQVLYZ" +
                                                              "/MDDiI87uSx3uxIhLhHia/vZsMHyI2zQZ74ePiGfu/JR4+GPXr3B9Q5eAvyA" +
                                                              "MoQNYfRWNmxkRl8RroD7sJUFuh2Xh7/Qol6+CRzHgKMM9d86YEJhzgfgx6Gu" +
                                                              "rP7NT19bfvydchQZQHWqjlMDmCM5qgUIJVYWanre+NxugSCTNTC0cFVRkfJF" +
                                                              "EyyL20vjQ3/OoDyjp3+44vu7np27yqHMEDxW+xl+ig1bXFDjn6pwH+YHtQAH" +
                                                              "E61dqFXmcTl/+sJc6sAz2yOO83op6K0b21QyQVQfqwjjFOgjhvjlwKtlHzSd" +
                                                              "//2PujK9d9JCsLm2WzQJ7Hc7uG7zwggQFuX1039edej+7PE76AbaQ1YKs/zO" +
                                                              "0PNv7t0on4/wm5BoBIpuUMFN3cGMqzMJXPm0YI6td/3ayvzVAc82x6/bSlfk" +
                                                              "EiHh1rmFti6SrOlF1nj3j6GcZAh1+0+3pfisg37s6z7few9FlZA1Jg3DFfu5" +
                                                              "V9A8wIakeB/+L3OLTRwy+PxR1xRRtrYKnh2OKXbcuRUX2rqIpfKLrE2zAdCs" +
                                                              "hur+Yuyagf4vzJCHtvR2bg8MkVYW/cMhbuXyi3PNNSvmHnyPZ7B7c26AXEzb" +
                                                              "quoLZX9YVxkmSStc0wYB0KJOnKZo9SJ3Hdau8Reu0Smx5xG4EJTaQ1E5jH7K" +
                                                              "WYjKMCXEHf/2032VojqPDg4VL36Ss8AdSNjr141CB7XzNq5pxdbNlxXDN/fx" +
                                                              "slv52IfX6wM4x/+0KmCSLf62guva3P7hh27c84zov2UVT/Moq4e6Lq4CLq51" +
                                                              "LMitwKtq36abTS/VbihUgFYhsJcnq33BfAjy2GBBtCrUnFpdbo/6/vyuV38+" +
                                                              "W/Uu1N8jqAzwY8kR319G4v8R6HBtKChH4sX9C9QA3jV3b3py6v6t6b/9lldG" +
                                                              "JPqdNQvTJ+Qrzx795fmV89Bd1w+iSihuJD+G6hRrz5R2kMgT5hhqVKz+PIgI" +
                                                              "XBSsBpqjJhbvmOUnt4tjzkZ3lt3eKOos7g2L77zQRUwSs1e3tZTTXtV7M4F/" +
                                                              "0wqlwTaM0AZvxtc/DwiYZd6AoE3Ehwyj0DpXtxscCvaWRl02fou/suHb/wH/" +
                                                              "j9Uq0BYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VGjInbjsTdxlKDbCdFNZoqTD87FdiwyjRYntNCIMmlZWfjwdC35v0u2G4mbo" +
       "LFNS2ASrDeZ6dUlYye0KLlfJRkbQDtJ22JTJKrLBN9vDuDsNHLSOSnydywK4" +
       "H1Ne5o3i7biimTWOkFubWUi22sy4O6JGiDpIZcvyBTNol5obVUtRHDcNqTod" +
       "lftZ0rOn5nxh4hMeLGg835Ytq+P681Z55al4TKwk4INj2onbwpatbVI6ogym" +
       "PEcoWiKC+nxhTLemRFry0mVag6BMa42165bWRBJtmn4J46i+MVpMyvzU0bNK" +
       "1F/F8WhlCPxozLVQaskhcq0GL+sSzPAmTtSciTlf9TJjC2vIAKlgOiUbzqJC" +
       "LLz2lh92fMOus7FbzvygNNa1KZORQXtYERyWaTtrJupWyWmyZroUk27t7VBe" +
       "tibTQQo3EE3RYQurC5ux2JaoYCrqcY/h+QDN3HZnYtdt1Orww/HK9DvxhB80" +
       "9V6FE7khViVJCgjCtf24Mw6ovs2VRGmWVRHCGg5aBh0EbbUsDtCaWMWbTKQ3" +
       "GjLRJwONxNtsN+FKbGttWRsgrUaZ3WnUX3jJcmGg5WZJwHtdYT5MIpsSvF5d" +
       "iarjudkiZmrWMeY1qzVw8dkisk0HN1t9rWxIyDaMad4mkUy1F5TrzM1kJdZ8" +
       "mYokIoOXcI+O3YptbKfivLu0vbFprETG2ephIFHOAl8jg2pzWKkza0IkVv3p" +
       "cF7W+qrHrBiBpJedSMDLtsX5gzk2sYhtFNTwTrLgCbq/YfSl0ZrjlQ0i8x6c" +
       "sBkmTznMlCbp1KCYuTTVDJkV6yuy7+Ebtz4J+TRJ2KAZK1ZA9EeebTlDe7Eg" +
       "NS9laq11IzTaOFeh+11Tm4muG2yTiKIDdExSuLRZi2RNHSzH9da4vWDLIqWb" +
       "5YE4h1fxQEwzIQrYgV1S2N6stq2qvQnBz4XY4u05QchsRPU3eFLuaSQlcZNq" +
       "aZ5VMrTUZC0G80jaa89FwQn5cbBoLzKzs0kW9JZez2oLZRw20rIiszM8Nsdt" +
       "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" +
       "WyEAAA==");
}
