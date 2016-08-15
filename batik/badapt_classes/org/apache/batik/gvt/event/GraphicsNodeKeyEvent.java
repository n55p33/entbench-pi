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
    public static final long jlc$SourceLastModified$jl7 = 1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za5AUR7lv77j3m/cBx+uI4ZHdgKDgAQaOO1hYjqs7oOQw" +
                                                              "LLOzvbtzNzszzPTe7UHQkDKCWqEIEkArUP4glRhJSFmJjzKkSFGaYGLKEJTE" +
                                                              "VEiMsUQjZSjLJIoav69nduexD3Ipdaumd7b7e39ff9/XvaevkTGGTlqpwvxs" +
                                                              "RKOGv1NhPYJu0GiHLBjGZpgLi8dKhb/uuNq9zEfK+0l9QjA2ioJBuyQqR41+" +
                                                              "Mk1SDCYoIjW6KY0iRo9ODaoPCUxSlX4yXjKCSU2WRIltVKMUAbYKeog0CYzp" +
                                                              "UiTFaNAiwMi0EEgS4JIEVnmX20OkVlS1ERt8kgO8w7GCkEmbl8FIY2hAGBIC" +
                                                              "KSbJgZBksPa0TuZrqjwSl1Xmp2nmH5CXWCZYH1qSY4JZTzS8f+NQopGbYKyg" +
                                                              "KCrj6hm91FDlIRoNkQZ7tlOmSWMX+RIpDZEaBzAjbaEM0wAwDQDTjLY2FEhf" +
                                                              "R5VUskPl6rAMpXJNRIEYmekmogm6kLTI9HCZgUIls3TnyKDtjKy2ppY5Kj4w" +
                                                              "P3Dk2I7G75eShn7SICl9KI4IQjBg0g8GpckI1Y1V0SiN9pMmBZzdR3VJkKXd" +
                                                              "lqebDSmuCCwF7s+YBSdTGtU5T9tW4EfQTU+JTNWz6sV4QFm/xsRkIQ66TrB1" +
                                                              "NTXswnlQsFoCwfSYAHFnoZQNSkqUkelejKyObRsAAFArkpQl1CyrMkWACdJs" +
                                                              "hogsKPFAH4SeEgfQMSoEoM5IS0GiaGtNEAeFOA1jRHrgeswlgKrihkAURsZ7" +
                                                              "wTgl8FKLx0sO/1zrXn5wj7JO8ZESkDlKRRnlrwGkVg9SL41RncI+MBFr54WO" +
                                                              "ChPOHvARAsDjPcAmzA/vun7HgtZzz5swU/LAbIoMUJGFxVOR+pendsxdVopi" +
                                                              "VGqqIaHzXZrzXdZjrbSnNcgwE7IUcdGfWTzX+7Ntdz9K3/WR6iApF1U5lYQ4" +
                                                              "ahLVpCbJVF9LFaoLjEaDpIoq0Q6+HiQV8B6SFGrOborFDMqCpEzmU+Uq/w0m" +
                                                              "igEJNFE1vEtKTM28awJL8Pe0RgipgIfUwjONmB/+zUgkkFCTNCCIgiIpaqBH" +
                                                              "V1F/IwAZJwK2TQQiEPWDAUNN6RCCAVWPBwSIgwS1FuJDsDuHMD+t1QUtIYlG" +
                                                              "N2SkDXSkEyf9GGva/4VLGnUdO1xSAm6Y6k0CMuyfdaocpXpYPJJa3Xn98fAL" +
                                                              "ZoDhprCsxAgy9puM/ZyxHxj7OWN/PsakpITzG4cCmC4Hhw3C1ofcWzu37871" +
                                                              "Ow/MKoVY04bLwNoIOstVgzrs/JBJ6mHxTHPd7plXFp73kbIQaRZElhJkLCmr" +
                                                              "9DgkK3HQ2s+1EahOdpGY4SgSWN10VaRRyFGFioVFpVIdojrOMzLOQSFTwnCz" +
                                                              "BgoXkLzyk3PHh/dt/fLtPuJz1wVkOQZSGqL3YDbPZu02bz7IR7dh/9X3zxzd" +
                                                              "q9qZwVVoMvUxBxN1mOWNCK95wuK8GcJT4bN727jZqyBzMwF2GiTFVi8PV+Jp" +
                                                              "zyRx1KUSFI6pelKQcSlj42qW0NVhe4aHahN/HwdhUYM7cTo8W62tyb9xdYKG" +
                                                              "40QztDHOPFrwIrGiTzvx6kt//DQ3d6aeNDgagT7K2h05DIk182zVZIftZp1S" +
                                                              "gHvjeM83H7i2fzuPWYCYnY9hG44dkLvAhWDme5/f9dqbV05d8tlxzqCIpyLQ" +
                                                              "C6WzSuI8qS6iJHC7xZYHcqAMGQKjpm2LAvEpxSQhIlPcWP9smLPwqT8fbDTj" +
                                                              "QIaZTBgtuDkBe37yanL3Czs+aOVkSkSswbbNbDAzsY+1Ka/SdWEE5Ujvuzjt" +
                                                              "W88JJ6BEQFo2pN2UZ9pKboNKrvkk6GLy5hRnNnFnBdx5famIATtYSoLDhqzy" +
                                                              "tqhnp3igrecds3RNzoNgwo1/JHDf1ssDL/JwqMQcgfMoTJ0jA0AuccRio+mm" +
                                                              "j+BTAs+/8UH34IRZJpo7rFo1I1usNC0Nks8t0l26FQjsbX5z8MGrj5kKeIu5" +
                                                              "B5geOPL1j/wHj5g+Njue2TlNhxPH7HpMdXBoR+lmFuPCMbr+cGbvTx7Zu9+U" +
                                                              "qtldvzuhPX3s1/960X/8rQt5ykWpZHWtizHosyl+nNs3pkJrvtbw9KHm0i7I" +
                                                              "LkFSmVKkXSkajDopQsNmpCIOZ9mdFJ9wqoaOgeozD32AM0stjfFrheN9FYMN" +
                                                              "oipxr5T4cy0n+Dl7uCklMWHVjfyU+LiEA9yeBSMcjPC1zTjMMZzp3h00jtNB" +
                                                              "WDx06b26re89c50b3n28cGa3jYJmer0Jh1vQ6xO95XidYCQAbvG57i82yudu" +
                                                              "AMV+oChCq2Fs0qEpSLtyoQU9puI3z56fsPPlUuLrItWyKkS7BF5WSBXkc2ok" +
                                                              "oJ9Ia5+/w0xnw5UwNHJVSY7yOROYUqbnT1adSY3x9LL7RxOfXP7wySs8r1p+" +
                                                              "nsLxK7DFcfUR/JBql7JHX/nsrx6+/+iwGdRFtqgHb9I/NsmRe97+MMfkvHLn" +
                                                              "2bUe/P7A6QdbOla+y/HtEorYbenctgzaEBt30aPJv/lmlf/URyr6SaNoHQq3" +
                                                              "CnIKC1M/HISMzEkRDo6udfehxuzg27MtwlRv2nCw9RZv524sY66dZ9frJnTh" +
                                                              "HKtmZ2q3q17zptCMKBTJH4QzXJzqzW9/59QH+/Yv9WHBGDOEooNVGm247hSe" +
                                                              "Pb96+oFpNUfe+gZ3PGyxQ0g0xtl/io/zcLiNh4IPSq3BT7AMNJEUQfaU3MYi" +
                                                              "cjJStaFzW7gr2Nu3OZsGxnL8LTjETVpfKBjjO7O8JuHsInhutXjdmmsT/B7A" +
                                                              "wcivSym++nFI4qB4NJlYhLqlyeZtPZ1r8mnCRqnJUnj8Fi9/Hu/iSwJccz++" +
                                                              "7PnE6hRiwUgNqtPT29nXl1+hu0ap0DJ4FlvcFhdR6DC+fOUTK1SIBSO1qFBv" +
                                                              "Z6hzVQGN7v34GtXjbAs8Kyx2K3I0IvzlvvyKQH9apekqgzRBox4t6oqQZaRi" +
                                                              "kI50QE3Pp8DBUSowBZ41Fqc1BRQ4aiqAw6FcOQthW3JCtcaf3R45j41SzlZ4" +
                                                              "ghanYAE5TxSVsxA2hDnIGVJFIXMu8dr0ZBFZ0zbP+Vme/FNOPNccDp6OMkqw" +
                                                              "V5hW6CaKd4en7jlyMrrpoYU+q4NZDZHDVO02mQ5R2UGqFCm5KvJGfvdml7c3" +
                                                              "6g//7sdt8dWjOdTjXOtNju34ezpUkXmFi7xXlOfu+VPL5pWJnaM4n0/3WMlL" +
                                                              "8rsbT19Ye4t42McvGs26m3NB6UZqd1fbap2ylK64u93ZWb82oL8mwxOx/Brx" +
                                                              "RqIdOZ6QyJ48C6EW6VifLLL2AxzOMFIdp2yDIy3Y0fvEzXZa8R4RJ3ZofP57" +
                                                              "WW04Oua+AUubgdEbohBqEWWfLbJ2HoenbUNk8o5tiLP/A0M0ZHb3LkubXaM3" +
                                                              "RCHUIsq+VGTtlzhcYKTeNIQrsdnG+Pl/wxhpRsblu5HEg8WknL9AzGt78fGT" +
                                                              "DZUTT265zHNQ9mq9FrJJLCXLztbX8V6u6TQmcf1qzUZY41+vMtJS+LoUulH+" +
                                                              "zeW/bGK8DjLnw4CDNIxOyCuMNHohgSL/dsL9FoLOhoNW2HxxgrwD1AEEX3+v" +
                                                              "Ze5kFn7Me96goqUYt2u6xF04st4cfzNvOmrNbFeO5v9nZfJpyvxHKyyeObm+" +
                                                              "e8/1zzxk3uaJsrB7N1KpCZEK82Ixm5NnFqSWoVW+bu6N+ieq5mSqV5MpsL0v" +
                                                              "pjiCdwf0RRqGT4vnqstoy954vXZq+TO/OFB+EQ4w20mJwMjY7bkHr7SWgmK4" +
                                                              "PZR7CwL1i9/Btc/99sjKBbG/vG6dcPitydTC8GHx0sN3vnJ40qlWH6mBkxMU" +
                                                              "ZprmJ8I1I0ovFYf0flInGZ1pEBGoSILsumKpx0gX8J8ubhfLnHXZWbwLZmRW" +
                                                              "7u1S7g16tawOU321mlKivEpB/bRnMrXZVdZSmuZBsGccN3BdOLSn0RsQsOHQ" +
                                                              "Rk3LXL6VXdT4pl9b+OrlQ/6Kw9//A+pSHoXrHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6MbQ9djzv93Wt7p9RtUVoOk9997VZ8qDGKdb67/14f/zjPgd6w88wEfd5y/g" +
       "vKjyZ5nXPjf6FvWHD6ArJxvtdx0ROV/ppfPb6zdCPU5CVzy3yf7siWdvFh77" +
       "JnApR55VLm6jnfbd5Xto79r3/X2+EP3ifZ79myJ5LYZuGHpMndmtPA2WT3+9" +
       "baGzKsuCnz2xrhQrdlU3R9Zt/uGt++x9nv16kfzqqXXH256n1v3b/wfrbh6P" +
       "hODIuuAf3rrP3efZ54vkP8bQE3vrzu2fnlr4Gw9iYRZDb7rsSEbxffnpu86A" +
       "7c8tqT//6s1rb311+l/KUwknZ4uu09C1VWLbZz81nclf9UN9ZZZ2XN9/ePLL" +
       "2+/F0DP3Pi8SQ4+U9xL4F/Y1/hPAfFmNGLoC0rOSfxBDty5KAo3l/azcfwcR" +
       "cyoXQ1f3mbMiXwTagUiR/ZJ/vEFc+wYPuhCun8SlX7OHzjPnSa899fV67QzZ" +
       "vvMcRZYH+o7pLNkf6bujfuZVkv3er7Z/an8CQ7XlPC+0XKOhR/eHQU4o8YV7" +
       "ajvWdRV/99ee+IXrLx7T9xN7wKfBfgbb85cfdxg6flweUMh/9a2/9N6ffvWL" +
       "5UfAvwOEjAn3aSkAAA==");
}
