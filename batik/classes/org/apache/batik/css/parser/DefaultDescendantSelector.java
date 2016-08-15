package org.apache.batik.css.parser;
public class DefaultDescendantSelector extends org.apache.batik.css.parser.AbstractDescendantSelector {
    public DefaultDescendantSelector(org.w3c.css.sac.Selector ancestor, org.w3c.css.sac.SimpleSelector simple) {
        super(
          ancestor,
          simple);
    }
    public short getSelectorType() { return SAC_DESCENDANT_SELECTOR;
    }
    public java.lang.String toString() { return getAncestorSelector(
                                                  ) + " " + getSimpleSelector(
                                                              ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwcRxWfO8ffdvyRON9xvpxAvu4amlSqHNomjt04Pcen" +
                                                              "OI3AobnM7c3drb23u9mdtc8ugaSiSqjUKAppGxCNBErVgtqmQlSAoJVRJdqq" +
                                                              "BaklohTUFAkkwkdEI6TyR4Dy3szu7d6ez1EQ4qSd25t582bem9/7vTf3/HVS" +
                                                              "a1ukm+k8xqdMZsf6dZ6kls0yfRq17YPQl1KeqqF/P3Jt/91RUjdK5uepPaRQ" +
                                                              "mw2oTMvYo2Slqtuc6gqz9zOWwRlJi9nMmqBcNfRR0qXagwVTUxWVDxkZhgKH" +
                                                              "qJUgHZRzS007nA26CjhZmYCdxMVO4rvCw70J0qIY5pQvviQg3hcYQcmCv5bN" +
                                                              "SXtijE7QuMNVLZ5Qbd5btMhm09CmcprBY6zIY2PaDtcF+xI7Klyw9qW2j2+e" +
                                                              "zbcLFyygum5wYZ59gNmGNsEyCdLm9/ZrrGAfI18iNQnSHBDmpCfhLRqHReOw" +
                                                              "qGetLwW7b2W6U+gzhDnc01RnKrghTtaUKzGpRQuumqTYM2ho4K7tYjJYu7pk" +
                                                              "rbSywsQnNsfPP3Wk/Xs1pG2UtKn6CG5HgU1wWGQUHMoKaWbZuzIZlhklHToc" +
                                                              "9gizVKqp0+5Jd9pqTqfcgeP33IKdjskssabvKzhHsM1yFG5YJfOyAlDur9qs" +
                                                              "RnNg6yLfVmnhAPaDgU0qbMzKUsCdO2XeuKpnOFkVnlGysecBEICp9QXG80Zp" +
                                                              "qXk6hQ7SKSGiUT0XHwHo6TkQrTUAgBYny6oqRV+bVBmnOZZCRIbkknIIpBqF" +
                                                              "I3AKJ11hMaEJTmlZ6JQC53N9/84zD+t79SiJwJ4zTNFw/80wqTs06QDLMotB" +
                                                              "HMiJLZsST9JFr5yOEgLCXSFhKfODL964b0v3zBtSZvksMsPpMabwlHIpPf+d" +
                                                              "FX0b767BbTSYhq3i4ZdZLqIs6Y70Fk1gmEUljTgY8wZnDvzs8ye+y/4SJU2D" +
                                                              "pE4xNKcAOOpQjIKpasy6n+nMopxlBkkj0zN9YnyQ1MN7QtWZ7B3OZm3GB8k8" +
                                                              "TXTVGeI3uCgLKtBFTfCu6lnDezcpz4v3okkIqYeHtMCzisiP+OYkH88bBRan" +
                                                              "CtVV3YgnLQPtt+PAOGnwbT6eBtSPx23DsQCCccPKxSngIM/cAcW2MTKBCON7" +
                                                              "WJY6Gt/DbAX2CxE9wjSG0I8h4sz/41pFtHvBZCQCR7IiTAgaxNJeQ8swK6Wc" +
                                                              "d3b333gx9ZYEGwaI6zFOdsDyMbl8TCwfg+VjcvlY1eVJJCJWXYjbkCCAIxwH" +
                                                              "MgA2btk48tC+o6fX1gD6zMl54H8UXVuWlfp8xvBoPqVc7mydXnN122tRMi9B" +
                                                              "OqnCHaphktll5YC+lHE3wlvSkK/8tLE6kDYw31mGwjLAWtXSh6ulwZhgFvZz" +
                                                              "sjCgwUtqGL7x6ill1v2TmQuTJw99+Y4oiZZnClyyFkgOpyeR30s83hNmiNn0" +
                                                              "tp269vHlJ48bPleUpR4vY1bMRBvWhnERdk9K2bSavpx65XiPcHsjcDmnEHtA" +
                                                              "k93hNcqoqNejdbSlAQzOGlaBajjk+biJ5y1j0u8RgO0Q7wsBFs0Ymz3u470T" +
                                                              "HF1kYrtYAhxxFrJCpI3PjphP//oXf7pTuNvLMG2B0mCE8d4Aq6GyTsFfHT5s" +
                                                              "D1qMgdwHF5Jfe+L6qcMCsyCxbrYFe7DtAzaDIwQ3P/rGsfc/vHrpStTHOYe0" +
                                                              "7qShOiqWjMR+0jSHkbDaBn8/wIoYYoiangd1wKeaVWlaYxhY/2xbv+3lv55p" +
                                                              "lzjQoMeD0ZZbK/D7l+4mJ9468o9uoSaiYFb2feaLSapf4GveZVl0CvdRPPnu" +
                                                              "yq+/Tp+GpAFEbavTTHBvVPggKixfAikEmWXyTkUQik2VmEcenkB3hYAKlSXz" +
                                                              "xMTh7xDCd4h2OzpOrEHEWC826+1gEJXHaaAKSylnr3zUeuijV28Iq8vLuCBm" +
                                                              "hqjZK2GKzYYiqF8cJrm91M6D3PaZ/V9o12ZugsZR0KgAmdvDFhBusQxhrnRt" +
                                                              "/W9++tqio+/UkOgAadIMmhmgIlhJI0QJs/PA1UXz3vskSCYboGkXppIK4ys6" +
                                                              "8KBWzQ6B/oLJxaFN/3Dx93c+e/GqQKspdSwPKvwUNptLuBWfunAmDeK2TINF" +
                                                              "VlYrdkShdumR8xczw89skyVJZ3kB0Q/18Qu/+tfbsQu/e3OWHNXIDXOrxiaY" +
                                                              "FlgzikuW5ZQhUQf6vPbB/HO//1FPbvftpBPs675FwsDfq8CITdXTQ3grrz/y" +
                                                              "52UH78kfvY3MsCrkzrDK7ww9/+b9G5RzUVH0yqRQUSyXT+oNOhYWtRhU9zqa" +
                                                              "iT2tAvbrSgDowINdDc9WFwBbZ2fnWbBT4rxqU+eI6s/NMTaKzQgEbI6VShGR" +
                                                              "XcrKCzzjESdtQymgFoD5J9zK+TPJo8rpnuQfJASXzjJBynU9F3/80Htjb4vD" +
                                                              "akB0lFwUQAagKJDU2qXtn8AnAs+/8cFtY4esQDv73DJ4dakOxjC0yMY5Lq7l" +
                                                              "BsSPd344/s1rL0gDwveEkDA7ff6xT2Jnzst4kpepdRX3meAceaGS5mCTwt2t" +
                                                              "mWsVMWPgj5eP//i546ei7iE9wEktsJnFS0cYKRWBC8udLne656ttPznbWTMA" +
                                                              "cTpIGhxdPeawwUw5VuttJx04Bf/25SPX3TN6nJPIJo/jdmJzUL7f+1/SK3b0" +
                                                              "m6J/uATyThxbBs92F+Tbbz8+qk2dIwacOcYmsQHCbOCGvPN6qbZdJAe8DMcC" +
                                                              "A8I1x/4XrilysrTqZQGz05KK/yvkHVt58WJbw+KLD74nSLp0D26BwMs6mhZA" +
                                                              "QBANdabFsqowuUUma1N8neRk+Rz3GazOxIsw44Sc8xWo/2ebw0kNtEHJU+DH" +
                                                              "sCRgXXwH5R7jpMmXg0XlS1DkcdAOIvh6xvQO6a65rmK7gJ4syGGV7i1GKnO5" +
                                                              "ONmuW51sIHmvKyMh8R+UF6eO/BcKrmcX9+1/+MZdz8h6W9Ho9DRqaYbolKV/" +
                                                              "KXetqarN01W3d+PN+S81rvdIo0Nu2I+Y5QFY9wN5mIiiZaFi1O4p1aTvX9r5" +
                                                              "6s9P170LdHeYRCgnCw4H/gGSf3dARetA0XA4UclCkOdFldy78RtT92zJ/u23" +
                                                              "okxyWWtFdfmUcuXZh355bsklqKabB0kt8CErjpIm1d4zpR9gyoQ1SlpVu78I" +
                                                              "WwQtKtXKKG4+Ap5iQAq/uO5sLfXibY2TtZW0XXnHhZJyklm7DUfPuCTZ7PeU" +
                                                              "/TnmpX/HNEMT/J5AalMlr8osVpNKDJmml9XqP20KAhgLU73oFLO/JV6x+fZ/" +
                                                              "ACqIC7ifFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1Ze8zsRnX3/W7uk5B7c4EQLuR9oU0WPu/Tu6tQGq/3ZXvf" +
       "9j68UC5+2+u3PV57TdNC1EJUpIBoQlMV8heoLQoPVaBWqqhSVS0gUCUq1JdU" +
       "QFWl0lIk8kdp1bSlY+/3vg8UtepKHs/OnHPmnDNnfj4z8+IPkTOBj+Rcx9yo" +
       "pgN25RjsrszKLti4crBL9Soj3g9kiTD5IGBh23Xx4S9e+vErH9Mu7yBnl8jr" +
       "eNt2AA90xw4mcuCYa1nqIZcOW1umbAUAudxb8WseDYFuoj09AI/3kNccYQXI" +
       "td6+CihUAYUqoJkKKH5IBZleK9uhRaQcvA0CD/kl5FQPOeuKqXoAeei4EJf3" +
       "eWtPzCizAEo4n/6fQaMy5thHHjywfWvzDQY/l0Of/Y33Xv6908ilJXJJt5lU" +
       "HREqAeAgS+ROS7YE2Q9wSZKlJXK3LcsSI/s6b+pJpvcSuRLoqs2D0JcPnJQ2" +
       "hq7sZ2Meeu5OMbXND0Xg+AfmKbpsSvv/zigmr0Jb7zm0dWthO22HBl7UoWK+" +
       "wovyPssdhm5LAHngJMeBjddoSABZz1ky0JyDoe6wediAXNnOncnbKsoAX7dV" +
       "SHrGCeEoALl6S6Gpr11eNHhVvg6Qe0/SjbZdkOpC5oiUBSBvOEmWSYKzdPXE" +
       "LB2Znx8O3vnM++2uvZPpLMmimep/HjLdf4JpIiuyL9uivGW887HeJ/h7vvL0" +
       "DoJA4jecIN7S/P4vvvzE2+9/6WtbmjffhGYorGQRXBc/Ldz1rbcQj9ZPp2qc" +
       "d51ATyf/mOVZ+I/2eh6PXbjy7jmQmHbu7ne+NPkz7gOflX+wg1wkkbOiY4YW" +
       "jKO7RcdydVP2O7It+zyQJRK5INsSkfWTyDlY7+m2vG0dKkogAxK5w8yazjrZ" +
       "f+giBYpIXXQO1nVbcfbrLg+0rB67CIKcgw9yJ3weQLa/7A0QDdUcS0Z5kbd1" +
       "20FHvpPaH6CyDQToWw0VYNQbaOCEPgxB1PFVlIdxoMl7HWIQpCszkH20KSt8" +
       "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" +
       "AA==");
}
