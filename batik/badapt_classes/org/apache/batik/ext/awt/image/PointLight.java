package org.apache.batik.ext.awt.image;
public class PointLight extends org.apache.batik.ext.awt.image.AbstractLight {
    private double lightX;
    private double lightY;
    private double lightZ;
    public double getLightX() { return lightX; }
    public double getLightY() { return lightY; }
    public double getLightZ() { return lightZ; }
    public PointLight(double lightX, double lightY, double lightZ, java.awt.Color lightColor) {
        super(
          lightColor);
        this.
          lightX =
          lightX;
        this.
          lightY =
          lightY;
        this.
          lightZ =
          lightZ;
    }
    public boolean isConstant() { return false; }
    public final void getLight(final double x, final double y, final double z,
                               final double[] L) { double L0 = lightX -
                                                     x;
                                                   double L1 = lightY -
                                                     y;
                                                   double L2 = lightZ -
                                                     z;
                                                   final double norm =
                                                     java.lang.Math.
                                                     sqrt(
                                                       L0 *
                                                         L0 +
                                                         L1 *
                                                         L1 +
                                                         L2 *
                                                         L2);
                                                   if (norm > 0) {
                                                       final double invNorm =
                                                         1.0 /
                                                         norm;
                                                       L0 *=
                                                         invNorm;
                                                       L1 *=
                                                         invNorm;
                                                       L2 *=
                                                         invNorm;
                                                   }
                                                   L[0] = L0;
                                                   L[1] = L1;
                                                   L[2] = L2; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZC5AUxRnu2zuO4x7cg6fAHa8Di9euGlCpIyqchxwucMXh" +
                                                              "lSyPY3a2d3e42ZlxpvduOUIUq1KQVEIZg69EryoJCrFQLKNlXhJSlKilsUrE" +
                                                              "GLXEPKwEg5SQlMbEJOb/u2d2HvugqJKt2t7Z7r//7v/v//++7p7D58goyyRt" +
                                                              "VGNhtsOgVrhLYz2SadFEpypZ1gao65cfqJT+sfXM2qUhUh0jY9OStUaWLLpS" +
                                                              "oWrCipFWRbOYpMnUWktpAnv0mNSi5qDEFF2LkQmK1Z0xVEVW2Bo9QVGgTzKj" +
                                                              "pFlizFTiWUa7bQWMtEZhJhE+k8jyYHNHlNTLurHDFZ/sEe/0tKBkxh3LYqQp" +
                                                              "ul0alCJZpqiRqGKxjpxJFhi6uiOl6ixMcyy8XV1iu2B1dEmBC2Y91fjp5/ek" +
                                                              "m7gLxkmapjNunrWeWro6SBNR0ujWdqk0Y91Bvk4qo6TOI8xIe9QZNAKDRmBQ" +
                                                              "x1pXCmbfQLVsplPn5jBHU7Uh44QYmelXYkimlLHV9PA5g4YaZtvOO4O1M/LW" +
                                                              "CisLTLxvQWT/A1ubnq4kjTHSqGi9OB0ZJsFgkBg4lGbi1LSWJxI0ESPNGix2" +
                                                              "LzUVSVWG7ZVusZSUJrEsLL/jFqzMGtTkY7q+gnUE28yszHQzb16SB5T9b1RS" +
                                                              "lVJg60TXVmHhSqwHA2sVmJiZlCDu7C5VA4qWYGR6sEfexvZbQQC6js5Qltbz" +
                                                              "Q1VpElSQFhEiqqSlIr0QeloKREfpEIAmI1NKKkVfG5I8IKVoP0ZkQK5HNIHU" +
                                                              "GO4I7MLIhKAY1wSrNCWwSp71Obd22b6d2iotRCpgzgkqqzj/OujUFui0niap" +
                                                              "SSEPRMf6+dH7pYnP7w0RAsITAsJC5rmvXbhpYduxl4TM1CIy6+Lbqcz65QPx" +
                                                              "sa9P65y3tBKnUWPoloKL77OcZ1mP3dKRMwBhJuY1YmPYaTy2/sTGux6nZ0Ok" +
                                                              "tptUy7qazUAcNct6xlBUat5CNWpKjCa6yRiqJTp5ezcZDc9RRaOidl0yaVHW" +
                                                              "TapUXlWt8//goiSoQBfVwrOiJXXn2ZBYmj/nDELIaPiSevi2EvHhv4xsjqT1" +
                                                              "DI1IsqQpmh7pMXW034oA4sTBt+lIHKJ+IGLpWRNCMKKbqYgEcZCmdgNmpjTE" +
                                                              "IkoGlh+8AeEaVVJpABqIMuMy68+hfeOGKirA9dOCia9CzqzS1QQ1++X92RVd" +
                                                              "F57sf0UEFSaC7RlG5sGQYTFkmA/JYRKGDPMhw+6QpKKCjzQehxYLDMszAIkO" +
                                                              "SFs/r3fL6m17Z1VCZBlDVeBbFJ3lY5xOFw0cCO+Xj7Q0DM88ffXxEKmKkhZJ" +
                                                              "ZllJRQJZbqYAmuQBO3vr48BFLiXM8FACcpmpyzQBiFSKGmwtNfogNbGekfEe" +
                                                              "DQ5hYWpGStNF0fmTYw8O7e6786oQCflZAIccBQCG3XsQu/MY3R7M/mJ6G/ec" +
                                                              "+fTI/bt0Fwd8tOKwYUFPtGFWMBaC7umX58+Qnu1/flc7d/sYwGkmQV4BBLYF" +
                                                              "x/DBTIcD2WhLDRic1M2MpGKT4+Naljb1IbeGB2kzfx4PYVGHeTcBvtfbich/" +
                                                              "sXWigeUkEdQYZwErOCV8tdd45PevffgV7m6HPRo9tN9LWYcHsVBZC8emZjds" +
                                                              "N5iUgtx7D/Z8775zezbxmAWJ2cUGbMeyE5AKlhDc/I2X7nj7/dMHToXcOGdA" +
                                                              "2dk47HxyeSOxntSWMRJGm+vOBxBPBVTAqGm/TYP4VJKKFFcpJtZ/Gudc/exH" +
                                                              "+5pEHKhQ44TRwosrcOuvWEHuemXrP9u4mgoZGdf1mSsmYHycq3m5aUo7cB65" +
                                                              "3SdbH3pRegQIAUDYUoYpx9Uq7oMqf65jPvVm4xbkpZKBZRi0Keqanm3y3vae" +
                                                              "DwT9XFGkg5CbcCjynb63tr/KF7kGMx/r0e4GT14DQngirEk4/wv4VMD3f/hF" +
                                                              "p2OFgPqWTptvZuQJxzByMPN5ZXaIfgMiu1reH3j4zBPCgCAhB4Tp3v3f+iK8" +
                                                              "b79YObFrmV2wcfD2ETsXYQ4WS3F2M8uNwnus/OuRXb88tGuPmFWLn4O7YIv5" +
                                                              "xO/++2r4wT+8XAT+qxM6xK5I1cUYzXnsHu9fHmHTzd9s/NU9LZUrATa6SU1W" +
                                                              "U+7I0u6EVynsu6xs3LNe7oaIV3itw7UBWpkPy4AV1/OCT2UyI2N5ECIRQXjq" +
                                                              "JpdYwhuvys+W8NkS3rYaizmWF179y+nZe/fL95w639B3/ugF7hL/5t2LJmsk" +
                                                              "Q6xHMxZzcT0mBelvlWSlQW7xsbWbm9Rjn4PGGGiUgc6tdSbQb86HPbb0qNHv" +
                                                              "/Ob4xG2vV5LQSlKr6lJipcRhnIwB/KRWGpg7Z9x4k4CPoRoomrippMD4ggpM" +
                                                              "4enFwaErYzCezsM/m/TMsoMjpzmOGULHVN6/EjcTPt7mR0CXOh5/47o3D373" +
                                                              "/iERbmWSJ9Bv8r/XqfG7//RZgcs5UxbJp0D/WOTww1M6bzjL+7uUhb3bc4Ub" +
                                                              "IKB9t+81j2c+Cc2qfiFERsdIk2wfufokNYtEEINjhuWcw+BY5mv3HxnE/rgj" +
                                                              "T8nTggntGTZIlt4kqWK+hHD5EfeoZD58Z9rUMTPIjxWEP2zmXa7k5XwsFjl0" +
                                                              "NNowFTiW0wAf1ZVRCkCg4h7v9nwejuOdb8Vii1C0tmQ09l367LntW51hNxYb" +
                                                              "NnkZht3uGzZWbNiBMsOKpiuxWJAfnH+qSeBo4SV7N7kIIkhrqdMfR/MDd+8f" +
                                                              "Sax79OqQjWs3MYAE3Vik0kGqelThjU6rL0/X8POuG/Tvjb33zz9vT624lK01" +
                                                              "1rVdZPOM/6dDxs0vnfrBqbx499+mbLghve0SdsnTA14KqvzJmsMv3zJXvjfE" +
                                                              "D/ciGwsuBfydOvw5WGtSljU1PzXNzq9rC67XVPjOtdd1bjCo3MgJhER+/1eq" +
                                                              "axkeu7NM224shiEgUlScyW53KZMH786L5Ux54sCKDQavHyz0wyLbmEWX7odS" +
                                                              "XcvY+u0ybfuw2OPxw8aAH/ZeTj8sto1ZfOl+KNW1jK0PlWn7ARb7PX6IBfxw" +
                                                              "32XwwzhsQ4zrtI3pvHQ/lOpaxtbHyrQdwuKHzEvjXO5aLJYKwzo8zzcCScZ1" +
                                                              "XaWSFtz54t+unOvBH10GDzZj21Xw7bHdsK6MB4MEH8LHMIOthaJJaoDjmxxl" +
                                                              "RZQG/Gef3HjAuIX/NUH+XMaPgeIIsLnuxK+tH//labH9K3bqC1xMHjpYI7+b" +
                                                              "OfGBQ2jX5aeMycSpepU9Zf7LSN+XdGmWonom0pmNK7JzHXeZNCOrzynNhh7v" +
                                                              "jTw2+7U7R2b/kZ8SahQL+BXouMiVsKfP+cPvnz3Z0Pok5/EqZGtOV8G79MKr" +
                                                              "ct8NOPd9IxZHcy5KeM98+L9PCNjbpRfKhSAWz3FVS3FDRbUUSxfLtEqYFz4e" +
                                                              "N9z8CAk9zllPXDjgBhs2Q7pGJedICm3iulHRw/nXENCYKzr5Qde64x744dMp" +
                                                              "gx5vlml7C4uTkG0yzkuYUUb8nVII4AELH9DwXr8oo/E0Fj9lpMaB+GIurhrU" +
                                                              "lYSLWc98GZiVAzh1L3/xTDm54N2SeB8iPznSWDNp5La3RIA67yzqYcuYzKqq" +
                                                              "99Tjea42TJpUuI314gwkbgE+ZKSt/J00rAb/5TM/I3p9xMjkUr0gBKH0Sn8M" +
                                                              "YVVMGiSh9Er+nZGmoCSMz3+9cp+At1w5yAfx4BX5DLSDCD7+y3Cie+FFrt+X" +
                                                              "A56asHXni5Cr8B8l8gs+4WIL7jl9zPbhFH+r6AB4VrxX7JePjKxeu/PCtY+K" +
                                                              "W1ZZlYaHUUsdQIq48M3v0meW1Oboql417/OxT42Z48B/s5iwy3BTPdG+ARLD" +
                                                              "wFibEriCtNrzN5FvH1h29Ld7q08ChG4iFRKgx6bCA3rOyMLxaFO08BILEJff" +
                                                              "jXbM+/6OGxYmP36XX4EQcek1rbR8v3zq4JY37p18oC1E6rohBLUEzfGbg5t3" +
                                                              "aOupPGjGSINideVgiqAFoMp3QzYW00LC943cL7Y7G/K1eEfPyKzC+8HCNxu1" +
                                                              "qj5EzRV6VkvYRFDn1jjY7zvoZA0j0MGt8bDDzQJVBAlX9kfXGIZzfVq12+C4" +
                                                              "0FUcxqCsqOeP+NTwf22ni6VxIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zs2F2f793du3c3m713N6/tkt1ks3dTdie5noc9ntFC" +
       "YOzx2B7b45nxjGdsKBs/x/b4NX7MeEwXQiRIAClEdJOmVVgJFChFmwQhUJFo" +
       "qkVVgQiEIEW0VIUFWqmUEDX5g4dIW3rs+b3vY1kldCQfe875nnO+3+/5fj/n" +
       "ex6vfAW6L4mhWhR6+5UXpjfNPL3peujNdB+Zyc0hh47VODENwlOTZAbyXtDf" +
       "8/PX/urrH7evX4auKNBb1CAIUzV1wiCZmknobU2Dg66d5pKe6ScpdJ1z1a0K" +
       "Z6njwZyTpM9z0JvOVE2hG9wxCzBgAQYswBULcO+UClR6sxlkPlHWUIM02UDf" +
       "B13ioCuRXrKXQk+dbyRSY9U/amZcSQBauFr+l4BQVeU8ht59IvtB5lsE/kQN" +
       "fumff8/1X7gHuqZA15xALNnRARMp6ESBHvJNXzPjpGcYpqFAjwSmaYhm7Kie" +
       "U1R8K9CjibMK1DSLzRMllZlZZMZVn6eae0gvZYszPQ3jE/Esx/SM43/3WZ66" +
       "ArK+/VTWg4SDMh8I+KADGIstVTePq9y7dgIjhd51scaJjDdYQACq3u+bqR2e" +
       "dHVvoIIM6NHD2HlqsILFNHaCFSC9L8xALyn0+B0bLXUdqfpaXZkvpNBjF+nG" +
       "hyJA9UCliLJKCr3tIlnVEhilxy+M0pnx+cro2z72vQEdXK54NkzdK/m/Cio9" +
       "eaHS1LTM2Ax081Dxoee4T6pv/8JHL0MQIH7bBeIDzb/5p1/7zvc9+epvHGi+" +
       "5TY0guaaevqC/hnt4d99J/Fs956SjatRmDjl4J+TvDL/8VHJ83kEPO/tJy2W" +
       "hTePC1+d/pr8oZ8zv3wZepCBruihl/nAjh7RQz9yPDOmzMCM1dQ0GOgBMzCI" +
       "qpyB7gffnBOYh1zBshIzZaB7vSrrSlj9ByqyQBOliu4H305ghcffkZra1Xce" +
       "QRB0P3igh8DzBHT4Ve8U+m7YDn0TVnU1cIIQHsdhKX8Cm0GqAd3asAasfg0n" +
       "YRYDE4TDeAWrwA5s86ig9Ex1l8KOD4YfaAOYK+esbAA7wMqif+D281K+67tL" +
       "l4Dq33nR8T3gM3ToGWb8gv5ShpNf+9wLv3n5xBGONJNCz4Iubx66vFl1WYEm" +
       "6PJm1eXN0y6hS5eqnt5adn0YYDA8a+DoAAIfelb8J8MPfvQ99wDLinb3At2W" +
       "pPCdkZg4hQamAkAd2Cf06qd2PyB9f/0ydPk8pJbsgqwHy+rjEghPAO/GRVe6" +
       "XbvXPvJnf/X5T74YnjrVOYw+8vVba5a++p6Lio1D3TQA+p02/9y71V964Qsv" +
       "3rgM3QsAAIBeqgIjBXjy5MU+zvns88f4V8pyHxDYCmNf9cqiY9B6MLXjcHea" +
       "U434w9X3I0DHbyqN+G3g6RxZdfUuS98SlelbDxZSDtoFKSp8/XYx+on//Nv/" +
       "s1Wp+xiKr52Z3EQzff6M+5eNXasc/ZFTG5jFpgno/vBT43/2ia985LsqAwAU" +
       "T9+uwxtlSgC3B0MI1PyDv7H5g9f+6DO/d/nUaFIw/2Wa5+j5iZBlPvTgXYQE" +
       "vb33lB8AHx5wsdJqbswDPzQcy1E1zyyt9H9fe6bxS3/xsesHO/BAzrEZve/1" +
       "GzjN/0c49KHf/J6/frJq5pJeTl+nOjslO2DiW05b7sWxui/5yH/gS0/8i19X" +
       "fwKgK0C0xCnMCqTurXRwL6j07F1CmNjxwWhsj2AffvHR19af/rPPHiD94hxx" +
       "gdj86Es/8nc3P/bS5TMT6dO3zGVn6xwm08qM3nwYkb8Dv0vg+b/lU45EmXEA" +
       "00eJI0R/9wmkR1EOxHnqbmxVXQz+x+df/JWfffEjBzEePT+PkCBM+uzv/5/f" +
       "uvmpP/7ibSDsihECk6n+t6qkYvRtKfRwpfoSy8CghHElBVwVPlelN0u2K51D" +
       "Vdm3l8m7krOgcl79Z8K3F/SP/95X3yx99d99reLofPx31od4NTro7+EyeXep" +
       "jndcRFBaTWxAh7w6+u7r3qtfBy0qoEUdzAiJEAMEz8953BH1fff/l1/992//" +
       "4O/eA10eQA96oWoM1Aq8oAcAapiJDcA/j77jOw9Os7sKkuuVqNAtwh+c7bHq" +
       "35W7m9+gDN9Ooe+xvxU87cN/+je3KKFC7NtY5IX6CvzKpx8nPvDlqv4pdJa1" +
       "n8xvndVAqHtat/lz/l9efs+V/3AZul+BrutHcbSkelkJSAqIHZPj4BrE2ufK" +
       "z8eBh6Dn+ZOp4Z0XXeJMtxdB+9QUwXdJXX4/eAGny8ADeg48Tx1B2FMXcfoS" +
       "VH2wVZWnqvRGmfzjY1i8P4qdLfCoqmUEGL1XzsnLE6O/XtX5QJlwh+Hs3XHo" +
       "B2+cMfEOjJWfwnme5NvxNPsH4En5+/Ok3I6n73pdnqo28ktA/fc1b2I36+V/" +
       "9fa93lN+fivoL6kWVKCG5QSqd8zGO1xPv3EMjxJYYAEfueF62DFUXa/cu7TG" +
       "m4dVyQVekb83r8B9Hz5tjAvBAudH//vHf+vHnn4N+NgQum9b2j9wrTM9jrJy" +
       "zfdDr3ziiTe99Mc/Ws3GQI3Sh575X1UE7d1N4jKpbN46FvXxUlSxCmg5NUn5" +
       "agI1jRNp62fkaadgGg6/AWnTa79DIwnTO/5xkkKgvXk+DbJmkQlIjumrttWj" +
       "1U7f6ZoZ5RERs9/odr7LdH5pe+J+LLfUptEykabi5dHWyIQ5M9802IlEMsqq" +
       "3SXjfTgk4sGEY0fe0h6KHut4yTwmKW5JjtkduULFicdr5FDQ4KxpNOltttoM" +
       "2bSZYgoWwzC2hbcwXKthEdZHO6twv5+mEjWy00RYSbHNyUVTBNhNRvtIaazU" +
       "sI3q1mY4qyXWkm9u5vbcrrtyVxDTubrguEgMFzHhRIPFVBPkiA/mi3Ua9YJt" +
       "3R+JDrrpk4NBk1tPfLah1HOJlBZNPOxOJGo1K1g3GoB1/GDmLOYqpk0WfEoq" +
       "9tAma+uOu5fpEe2NZlwW0/2BAiekCddTFl/ndouTN5Mo8+qqRwyVaONMNxSb" +
       "u1E+HNhOO3MEr+3kvL7fd5ZSw8maeMMgfZxoyt2G5UYobK59bMXla1+N3FEW" +
       "xAtzEYdtER9N65m7MDbrOqDEt2tkE7ZnAtPJGbM7UUY9tj/18UneiJaEr1kT" +
       "TkoibxygLk7PsbmNIBPZN72lvHZ8j6Ol7riHrhBZVdKtICBCg4e5BeEk3IzL" +
       "t5PFDO41Mi3YIGt3RosbyukKeF0ZJoPVGl8hHqU5DU5cDHOmTorjEeXkTa6Y" +
       "S6K0oDBFyhJFnA9jMuE42B1sCp5KZ2sZ29RWwZxsdvZJQU8KrQFEQmddrTEV" +
       "PWm4atdnS8mnbXGzo3vNRPKHjuIR/QwjUKmHbBYyNW0npGXmW0WbTIi2m6AT" +
       "L9WKSUOKSE+cDGzS2WxEj4nrE9ML2SlpRSTT85nGiGXXkkWhTIdhpXBcV9YT" +
       "FqVHDD2nBITBeI6x2Z7c2InxiFjsxAhrCJrRbGpto+mE6ZSIVsVqvdkULixk" +
       "7nyQOfXAUSNRJMdT3mrXDBqL5GCM7erTXsLMesmQQGN/u9TsSDay3ENmfINg" +
       "9u0ap230oo1OxnmidsdtdN9KcRYY5BhEWyyHYYKuNPxxy2Cn/A63h5nckP2x" +
       "rM72TTiZUVneDpS6AKw3ne+xjVrMe/pIT9u5h8/VFCVGi4h1CbW9nzrAHSLU" +
       "LHSlr3enU1VwDK++VyV6MVOj+dJbpB0YXoWOGE5wS9rFgjNcLoOmgsu+Cwd9" +
       "kmPUsSOaW6dJbml7C9DF3cwafabBJMCufRuL+OWi3kLCHpLM8LTmMTQ7rDEU" +
       "Fy2mI4JnWW0jr0hdIXxjNfIjd0Yy65Dy7FqnZ5KqJA2jHr5h+Izftzs12zIF" +
       "inXiXtcQCEftEsWmEBuTSaNWW3abU8kYoFhi1efkQFQJbOpRaEJN5Nlg7ffg" +
       "oTxlqf6Yt3e19iRiWcItJqady1yfT4oesxbEQQLHLYtr+w1MaUiEgnt9ycS1" +
       "wbDlyWguDHZ1nRBqSxeb1Pt8p2NZy5xkfXZtK0PF84bTyVABwvT8bIILrW2M" +
       "dPAB5yz5zqBH6JEf7YsJ7gxElvJ36cgKVyONMtcWafYnqC0vIkpMR4O65c/k" +
       "XUfAzDbWaYcTwvKUHqPr+ISgWstkksG83JpiPOwP2xRs6jVrxsBaWh/sjE4q" +
       "sDt5Phin1GDB40D+zF+indokyBqw5emYASfyjlr7EwnBcU4e5HAfnzF6v7mw" +
       "uf7U0Rt8k48odobURqrnag1GMym8uS6sHBnLEkWbMx3fppbm6DacLBfOypyv" +
       "SWMiKzsyFgipkxoGgo7NrWWtJMxv0+Np2E1HXW4h63Qi4QrRMX3FNZIR6sxX" +
       "aY71YaWDYWhhFlru9xbDpj6nNN7ck2iP9ey+DjPNJRa4GGzw9Cxc6gJl9JrG" +
       "GsHofG+KQh6k4oKfDim/thXwHB/j0qy3oXx4Jo8Raciyg4EeDVMFpjJDh82c" +
       "rqERSbP2BEFm012YxLqQbRcknZn+Mh53M8RfhQplWA1fTHyZ3uublo+q8xDT" +
       "8TbaEg2NbkVTczVhevO+PA/lKO/ON1jIb6w26o63ko/k2jpSWFyZOnXW3KiB" +
       "39q3tqrZ3826ywG1XqGEphPuPtDarTSG2QG2pvgcjusmQs0aSH8SrJyYXCPw" +
       "botIfL9lwfYgagqD1XizmEXpVskmw7zA9/x4hCpLlbFWvJM1YpNuuUiBj4kV" +
       "0bNxZBa1ti2r5rAdDevKgjaIfam5061+k5wlS3mCLMTWoMl3stEuyBIAUtOl" +
       "1umkVDb2BwsuQARMZrbA2sGk2oyR3azWWfZmtU3Ot3MWZRr6XC6WQUJnXYv2" +
       "6VlhdBN4NO9yyjzuzdS2OG8s5jWMqWdtUtoHSdbOkxY3MrFQZaSWk+6wOb6I" +
       "1uM90pMasEDMmvM90xyhJMFMJ0t3M4wMeWdn231SW3RGa7EVy6pT+ItBA+vu" +
       "a4FiwhbXRXftVhdvwdlqgNkcjKZNbugn60k7p/lcKfRZ3cdNb+stRG+ywPJE" +
       "W2h+d+oGyJiiKGB7ejs1RG2idYCNalp9M6K3YJmC5FRzK6HcBAQhcdsbOpE+" +
       "tQNmh8PsdEFFK0zp5sgaIcbhNAz92Ikivo+sVhGPmMFgp5KxXBBmkQDXhGd8" +
       "EvJuVPgCNQeT56gNk64+G6eYP60TS8FGYQQLW/0W1oIdcqr5C3HYxbedGF5u" +
       "LAqD4amy0hN0nmvDqN6HF8Jst2vwba1wuRqWzW2tpenIXGNYvJvWOg23qdcI" +
       "vbmxnAE5TQxm3dxZmRWuR3JKkszItbOFvqvhMupvW3QekHC8cmedYLZaBSk1" +
       "UxgvRdabBVuz6T4KpsxQAZGU0o3n/GzMuPmCHDcLf6lia3S5SwauVx+Nwl0Z" +
       "5tR3PauhSFNiTawQG9t2g53pZoKhdSTHaRD11J/Uu16rjXFBukAb9iiXtVGw" +
       "Vuy0lVGFstBGDs4nAhs5Wb4Y9qyArm1EEw8RUcJG2Jph1na8MXhrCvN9o9ax" +
       "RDXHusJm4i6SFi/3yJbkrOtramN6M9udt2OuDi87YyGj4NnW1VqtouhuZ+0m" +
       "4rH1RiOWDGUs8HDb6OdJfRtYMb7RcqTbrfkat7K3Zl00kmDWayDsZlsAc+K3" +
       "rWK43LoW2Yd1h9olGW7tDWG7QxdUKnruvDEulqNi042JNraUxq4A8K+huUTY" +
       "4lcg7JvW4AYAgXxtZtiIbzaRxHbI1dwT9f0CbbEKTwOA58Ago0hCsP2JuqX3" +
       "RX235zSfXCyx0BCX+lauZfW9ZmW7pjDOdx21R8OKOXM7SRo2FEvwauxo0XDZ" +
       "+thbBFhvqmHjZZvBrXzXai53u8JOJkgRp0wr2tIT2BMiNU81eh9PjF3G0gW5" +
       "dZcCqnJDmd0VYacodEIEUcVSXYiDtECRtJYFwhanG3WqXyhus7HcYRptJGyb" +
       "xxGepDsczTNCaqvDoRr2XT/PvakyoWDKtFq028uYJYAGurbk1fHKZJiEC7Kc" +
       "raU0DHuqRnfZlrYhGjlPu5HMYDVNsCh80nSXqGrye12MzGjeVSyME0e1pUH5" +
       "izAI/Xrkj1hsWNBLUxkRQlzsg5ENbM+d7Zo1bI5Nmxq8Vjqiak+4Gr4MM96R" +
       "EtYa1/TxNihaSn0crlGY3ChUKkgdCuvybKynnZEwNrpMrtD6HmVNvtupcd0x" +
       "MXK1aGqxtthbFK2BBHCzP9XmczG3uJTcyIMCMUfdokP01t3C88bLvrvC7aQ5" +
       "wSJqaBoM4beczKOnOzhYkiNCZosYnRhmG6ybEMTgo1WObj3fwwgkm62p+r5Y" +
       "Z/J8rnUCiWGQHsnR3f5uGXfCECbrA7frRbyK1ygmi+147skit9C7HUpxpF5h" +
       "N7gWnM/6PoqMmsCFOs64CMRFfxShnNqaMr02ti82sp7JBbvZdLsz11SR5mwY" +
       "zTOm1UBWu7W2ImsKK6bwsF6PexqMzngYmE035931PK6vcJaui0GHlyWJpxzR" +
       "Bis3gMaUHxIiX7RqXT2q9dLGDt33QLSAL9E+J/aJPlbbtwjHrA0GcVpb9tC2" +
       "mtDLwEGJuIN3vM4qqSELhsNcr1uMNXtA1+J2D0ekOF9iQ3PssrmZwWMilWvs" +
       "oqEonqzS83liTJgN0uFbYFFmLkDwHW48pIHBQj4Dq0wQc8EJ6uz2LXw2Nqha" +
       "b8r1dwNHI2OHSEdxMUIHW7phN7ucgW3qHcKmEGcwZVd5WyN6rVjY81yuDoR6" +
       "B2c4cmhZ7lLja3BboHIQXbfayyVCTnRz3Yi1aQcAxAYZyi0sanRCokG249DG" +
       "uTlZWJS2QtOWKmTRmHIpkRk5himtnE1vEPJRa1LIi3qdI7pIS+cwGaNgtmGS" +
       "1njPFkStQxOjPGtsXJQsplJbWm/l6aAfNFxXxoptqPTqbh2skDpav19MhhLe" +
       "85bdtbWkGKWwpE2jWSOQ+mCu5xsi2QjmuDaa7axmM3DaUl4u5Mulff7Gthwe" +
       "qXZXTg6AXQ8rC+w3sKtw1GGZPHOyE1X9rkAXDg3PnjycbptC5cbuE3c61632" +
       "uD/z4ZdeNoSfblw+2m7GUuiBNIze75lb0zvTVHmH4bk778Dy1bH26Tbor3/4" +
       "zx+ffcD+4Bs4NHvXBT4vNvmv+Ve+SL1X//HL0D0nm6K3HLifr/T8+a3QB2Mz" +
       "zeJgdm5D9IkTzT5aauxbwPPeI82+9+Ie3+nY3X6D71sPY3+X3fyP3aXs42Xy" +
       "w0D/K/NwuHnYSD21lR95vR2osy1WGT90q3DvPxLu/d984f7lXco+XSafOCOc" +
       "fEG4T34zhEOOhEO++cL9zF3KfrZMfvKMcMoF4X7qGxDuLcdOThwJR3zzhfuF" +
       "u5T9Ypl8Nj17cnG7LdP7tTD0TDU4Ffpz34DQFdLVwTM+Elp4A0JfPkFk67aS" +
       "Hx1pVmN0mgCAe+bOAFcdkx4OLF/+mad/+/tffvpPqhOxq04iqXEvXt3mBs2Z" +
       "Ol995bUvf+nNT3yuOo2/V1OTAwJdvHp0682icxeGKmkeOlFSqU/oYfCsjpRU" +
       "vVNo/Q3e79Bix1iZsChRAxMM+ba8OcWraezk5V0z0ApeERxfJ/n/2V2lgVYU" +
       "RQfb/NW72O0Xy+TfptDVY6e87Ub/NnSMU5P9whsx2Rz4xOlNlPJY/bFbLrod" +
       "Lmfpn3v52tV3vDz/T4fhP75A9QAHXbUyzzt7Wnfm+0oUm5ZTyfLA4ewuql7/" +
       "MYWevPsFmRS6r3pXLH/pUOv3U+ixO9VKoXtAepb6D1LorbejBpQgPUv5X1Po" +
       "+kVK0H/1Pkv3GtDWKV0KXTl8nCX5U9A6ICk//1t0fAj1vte5C9TTkjRW9cMg" +
       "5JfORz8nA/vo6w3smYDp6XMoUF1xPA5JssMlxxf0z788HH3v19o/fbilontq" +
       "UZStXAUOe7gwcxLWPHXH1o7bukI/+/WHf/6BZ45DsIcPDJ8C3Bne3nX7KyGk" +
       "H6XVJY7il9/xi9/2r17+o+q87P8BX8C2VXsqAAA=");
}
