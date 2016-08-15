package org.apache.batik.css.parser;
public class DefaultDirectAdjacentSelector extends org.apache.batik.css.parser.AbstractSiblingSelector {
    public DefaultDirectAdjacentSelector(short type, org.w3c.css.sac.Selector parent,
                                         org.w3c.css.sac.SimpleSelector simple) {
        super(
          type,
          parent,
          simple);
    }
    public short getSelectorType() { return SAC_DIRECT_ADJACENT_SELECTOR;
    }
    public java.lang.String toString() { return getSelector(
                                                  ) + " + " +
                                         getSiblingSelector(
                                           ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ye2wcRxkfn2PH8SN+5Nk8nJcTyIPbhjQRkUOJ49iNwzk5" +
       "xaklHJrL3N7c3dp7u5vdWfvsEkgqUEylRlFI21C1kUCpWlDbVIgKELQKqkRb" +
       "tSC1RJSCmiKBRHhENEIqfwQo3zeze7u3Z18UhDhp5/Zmvvnme/6+b+65G6TO" +
       "sUknM3icT1rMifcZPElth2V6deo4h2EupT5eS/9+9PqBnTFSP0Lm56kzqFKH" +
       "9WtMzzgjZKVmOJwaKnMOMJbBHUmbOcwep1wzjRGySHMGCpauqRofNDMMCYap" +
       "nSDtlHNbS7ucDXgMOFmZAEkUIYnSE13uTpBm1bQmA/KlIfLe0ApSFoKzHE7a" +
       "EqN0nCou13QloTm8u2iTzZapT+Z0k8dZkcdH9e2eCfYntleYYO2LrR/dOptv" +
       "EyZYQA3D5EI95xBzTH2cZRKkNZjt01nBOU6+TGoTpClEzElXwj9UgUMVONTX" +
       "NqAC6VuY4RZ6TaEO9znVWyoKxMmaciYWtWnBY5MUMgOHBu7pLjaDtqtL2kot" +
       "K1R8dLNy/vGjbd+rJa0jpFUzhlAcFYTgcMgIGJQV0sx2ejIZlhkh7QY4e4jZ" +
       "GtW1Kc/THY6WMyh3wf2+WXDStZgtzgxsBX4E3WxX5aZdUi8rAsr7VZfVaQ50" +
       "XRzoKjXsx3lQsFEDwewshbjztswZ04wMJ6uiO0o6dn0eCGDr3ALjebN01ByD" +
       "wgTpkCGiUyOnDEHoGTkgrTMhAG1Ols3KFG1tUXWM5lgKIzJCl5RLQDVPGAK3" +
       "cLIoSiY4gZeWRbwU8s+NA7vOPGjsM2KkBmTOMFVH+ZtgU2dk0yGWZTaDPJAb" +
       "mzclHqOLX56OEQLEiyLEkuYHX7q5e0vnldclzfIZaA6mR5nKU+ql9Py3V/Ru" +
       "3FmLYjRYpqOh88s0F1mW9Fa6ixYgzOISR1yM+4tXDv3sCye/y/4SI40DpF41" +
       "dbcAcdSumgVL05l9HzOYTTnLDJB5zMj0ivUBMhfeE5rB5OzBbNZhfIDM0cVU" +
       "vSl+g4mywAJN1AjvmpE1/XeL8rx4L1qEkLnwkGZ4VhP5Ed+c6EreLDCFqtTQ" +
       "DFNJ2ibq7yiAOGmwbV5JQ9SPKY7p2hCCimnnFApxkGfeguo4mJkAhMpelqWu" +
       "zvdqNnDoyYxCzBp8iOkMwz+OUWf9n88rov4LJmpqwDUrosCgA/0+U88wO6We" +
       "d/f03Xwh9aYMOkwUz3Kc7AQR4lKEuBAhDiLEpQjxqiKQmhpx8kIURQYEuHMM" +
       "gAGQuXnj0AP7j02vrYVItCbmgC+QdG1ZheoN0MOH/JR6uaNlas21ra/GyJwE" +
       "6aAqd6mOBafHzgGUqWNetjenoXYFJWR1qIRg7bNNlWUAwWYrJR6XBnOc2TjP" +
       "ycIQB7/AYSors5eXGeUnVy5MnBr+yt0xEiuvGnhkHQAebk8i1pcwvSuKFjPx" +
       "bT19/aPLj50wA9woK0N+9azYiTqsjcZG1DwpddNq+lLq5RNdwuzzANc5hTwE" +
       "yOyMnlEGS90+xKMuDaBw1rQLVMcl38aNPG+bE8GMCNp28b4QwqIJ8/ST8Kz3" +
       "Eld84+piC8clMsgxziJaiBLy2SHrqV//4k/bhLn9atMaahOGGO8OIRwy6xBY" +
       "1h6E7WGbMaB7/0LyG4/eOH1ExCxQrJvpwC4cewHZwIVg5q+9fvy9D65duhoL" +
       "4pxDiXfT0CkVS0riPGmsoiSctiGQBxASUwyjput+A+JTy2o0rTNMrH+2rt/6" +
       "0l/PtMk40GHGD6Mtt2cQzN+1h5x88+g/OgWbGhUrdGCzgEzC/oKAc49t00mU" +
       "o3jqnZXffI0+BQUEQNvRppjA4Vphg9ryXMd8GnLTDuSlVgA3jHsl7dPJY+p0" +
       "V/IPslzdNcMGSbfoWeWR4XdH3xJObsDMx3nUuyWU14AQoQhrk8b/GD418Pwb" +
       "HzQ6TsjS0NHr1afVpQJlWUWQfGOVjrJcAeVExwdjT15/XioQLeARYjZ9/uGP" +
       "42fOS8/JLmddRaMR3iM7HakODjtRujXVThE7+v94+cSPnz1xWkrVUV6z+6Al" +
       "ff5X/3orfuF3b8xQDuqcvGnLXvUeDOYSdC8s945Uae/XW39ytqO2H1BjgDS4" +
       "hnbcZQOZME9o0xw3HXJX0D+JibBy6BpOajahF3BmKbQjWJ0mtqmiKDlUjfvF" +
       "xyforCDQ4JbCfDLBfrsgvrukFBFKEbGWwGG9EwbhcqeHOvqUevbqhy3DH75y" +
       "Uxiu/EoQxpxBakmvteOwAb22JFok91EnD3T3XDnwxTb9yi3gOAIcVWgKnIM2" +
       "FO1iGUJ51HVzf/PTVxcfe7uWxPpJo27STD8VYE/mAcoy8J2eKVqf2y1BZqIB" +
       "hjahKqlQvmICE33VzBDSV7C4SPqpHy75/q5nLl4TaOd5aXmY4Sdw2FzCPfGp" +
       "j3ZlYdwr42CTlbM1ziKwLz10/mLm4NNbY57zdnPQ27Q+pbNxpodYxZBTWasx" +
       "KK4KQbl7f/653/+oK7fnTroMnOu8TR+Bv1eB6zbNDiFRUV576M/LDt+bP3YH" +
       "DcOqiJWiLL8z+Nwb921Qz8XEvUj2ChX3qfJN3eVJ22gzuAAa5Wm6ruTXdt+X" +
       "iudXZeaiPUNIlErhbFurJGu+ytooDlDHWnOs1KH64n9G7BjEISPjNPlf5ghO" +
       "DFtiPlVSqQPXlsGzw1Npx51bY7atVTR2q6xN4ABw3sBNeQn28bJNZDjejuOh" +
       "BWGa4/8L0xQ5WVn11oAws7TiTwx58VZfuNjasOTi/e+KtCxdjpshwbKurofi" +
       "Mxyr9ZbNsppQu1miriW+TnGyvMrlBts08SJUOSn3fBUuAjPt4aQWxjDlabBl" +
       "lBLKp/gO0z3MSWNAB4fKlzDJI8AdSPD1jOU7alu1e1kPtEY2oNaQBn2mkStV" +
       "u5pKRBauXXQ714YgeF0ZdIl/pXyYceX/UnBJu7j/wIM3dzwtu25Vp1NTyKUJ" +
       "qr28AJSgas2s3Hxe9fs23pr/4rz1Pqi3S4GDlFkeiuthaEYsDKFlkZbU6Sp1" +
       "pu9d2vXKz6fr34GSeoTUUE4WHAn9JyT/AIG+1oUacSRR2dUArIteuXvjE5P3" +
       "bsn+7bei2BHZBa2YnT6lXn3mgV+eW3oJeuqmAVIH9YoVR0ij5uydNA4xddwe" +
       "IS2a01cEEYGLRvWylmk+RjvFjBR28czZUprFOxsnayv7xcqbLjQGE8zeY7pG" +
       "xmu6moKZsr/LfLR3LSuyIZgJ9dR7ZZ+G3oCQTSUGLctvp+futwQC9EVbRzEp" +
       "dn9LvOLw7f8A0FZdRbEWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yO4gkt974++8/Tde+FZ2Evff4e5/U2ohAAA=");
}
