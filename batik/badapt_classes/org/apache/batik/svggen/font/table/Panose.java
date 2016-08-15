package org.apache.batik.svggen.font.table;
public class Panose {
    byte bFamilyType = 0;
    byte bSerifStyle = 0;
    byte bWeight = 0;
    byte bProportion = 0;
    byte bContrast = 0;
    byte bStrokeVariation = 0;
    byte bArmStyle = 0;
    byte bLetterform = 0;
    byte bMidline = 0;
    byte bXHeight = 0;
    public Panose(byte[] panose) { super();
                                   bFamilyType = panose[0];
                                   bSerifStyle = panose[1];
                                   bWeight = panose[2];
                                   bProportion = panose[3];
                                   bContrast = panose[4];
                                   bStrokeVariation = panose[5];
                                   bArmStyle = panose[6];
                                   bLetterform = panose[7];
                                   bMidline = panose[8];
                                   bXHeight = panose[9]; }
    public byte getFamilyType() { return bFamilyType; }
    public byte getSerifStyle() { return bSerifStyle; }
    public byte getWeight() { return bWeight; }
    public byte getProportion() { return bProportion; }
    public byte getContrast() { return bContrast; }
    public byte getStrokeVariation() { return bStrokeVariation; }
    public byte getArmStyle() { return bArmStyle; }
    public byte getLetterForm() { return bLetterform; }
    public byte getMidline() { return bMidline; }
    public byte getXHeight() { return bXHeight; }
    public java.lang.String toString() { java.lang.StringBuffer sb = new java.lang.StringBuffer(
                                           );
                                         sb.append(java.lang.String.
                                                     valueOf(
                                                       bFamilyType)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bSerifStyle)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bWeight)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bProportion)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bContrast)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bStrokeVariation)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bArmStyle)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bLetterform)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bMidline)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bXHeight));
                                         return sb.toString(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1afXAV1RW/7yWEkBDywaeQhJAEHUDfEwsVG4qSkJjoC0SC" +
                                                              "SAMa9u27SZbs211270tesFRlakVn6qBFpR1N/yiKdVAcq9MPP4p16sdobVWq" +
                                                              "tVattdP6UVuYTrVTau059+57u2/f26WhTTOz923uveeec37n3HPO3d3DH5Ep" +
                                                              "lknqqcYibMygVqRdYz2SadFEmypZ1ibo65fvKJL+etV76y8Ik5I+MmNIsrpl" +
                                                              "yaIdClUTVh+pUzSLSZpMrfWUJpCix6QWNUckpuhaH5mtWF1JQ1VkhXXrCYoT" +
                                                              "NktmjFRLjJlKPMVol70AI3UxkCTKJYmu9Q63xMh0WTfGnOnzXNPbXCM4M+nw" +
                                                              "shipiu2QRqRoiilqNKZYrCVtkmWGro4NqjqL0DSL7FBX2hBcEluZB0Hjg5Uf" +
                                                              "n9w3VMUhmClpms64etZGaunqCE3ESKXT267SpLWTfIUUxUi5azIjzbEM0ygw" +
                                                              "jQLTjLbOLJC+gmqpZJvO1WGZlUoMGQViZFHuIoZkSkl7mR4uM6xQymzdOTFo" +
                                                              "25DVVmiZp+Jty6L777iq6qEiUtlHKhWtF8WRQQgGTPoAUJqMU9Nam0jQRB+p" +
                                                              "1sDYvdRUJFXZZVu6xlIGNYmlwPwZWLAzZVCT83SwAjuCbmZKZrqZVW+AO5T9" +
                                                              "35QBVRoEXec4ugoNO7AfFCxTQDBzQAK/s0mKhxUtwchCL0VWx+ZLYQKQTk1S" +
                                                              "NqRnWRVrEnSQGuEiqqQNRnvB9bRBmDpFBwc0GZnvuyhibUjysDRI+9EjPfN6" +
                                                              "xBDMmsaBQBJGZnun8ZXASvM9VnLZ56P1q2++WuvUwiQEMieorKL85UBU7yHa" +
                                                              "SAeoSWEfCMLpS2O3S3Me3xsmBCbP9kwWc77/5RMXnV1/9FkxZ0GBORviO6jM" +
                                                              "+uWD8Rkv1bYtuaAIxSg1dEtB4+dozndZjz3SkjYgwszJroiDkczg0Y1Pf+na" +
                                                              "++iHYVLWRUpkXU0lwY+qZT1pKCo1L6YaNSVGE11kGtUSbXy8i0yF+5iiUdG7" +
                                                              "YWDAoqyLFKu8q0Tn/wNEA7AEQlQG94o2oGfuDYkN8fu0QQiZCheZDtcZRPzx" +
                                                              "X0a2RYf0JI1KsqQpmh7tMXXU34pCxIkDtkPROHj9cNTSUya4YFQ3B6MS+MEQ" +
                                                              "zQyMDA5SLTqgY4SS4ioFV9B0i0bQy4xJXj+N+s0cDYUA+lrvxldhz3TqaoKa" +
                                                              "/fL+VGv7iQf6nxdOhRvBRoaRJcAyIlhGOMuIYBlBlhHOMiJYklCIc5qFrIWB" +
                                                              "wTzDsNEh0k5f0nvlJdv3NhaBZxmjxYAtTm3MyThtTjTIhPB++UhNxa5Fby1/" +
                                                              "KkyKY6RGkllKUjGBrDUHITTJw/bunR6HXOSkhAZXSsBcZuoyTUBE8ksN9iql" +
                                                              "+gg1sZ+RWa4VMgkLt2bUP10UlJ8cPTB63eZrzg2TcG4WQJZTIIAheQ/G7myM" +
                                                              "bvbu/kLrVt7w3sdHbt+tO3EgJ61ksmEeJerQ6PUFLzz98tIG6ZH+x3c3c9in" +
                                                              "QZxmEuwrCIH1Xh45YaYlE7JRl1JQeEA3k5KKQxmMy9iQqY86PdxJq/n9LHCL" +
                                                              "abjvKuE6y96I/BdH5xjYzhVOjX7m0YKnhC/2Gnf96sX3P8fhzmSPSlfa76Ws" +
                                                              "xRWxcLEaHpuqHbfdZFIK89480PON2z66YSv3WZjRVIhhM7ZtEKnAhADz9c/u" +
                                                              "fP3ttw4eCzt+ziBlp+JQ+aSzSoZRp9IAJYHbmY48EPFUiAroNc2Xa+CfyoCC" +
                                                              "Gw831j8rFy9/5E83Vwk/UKEn40Znn3oBp/+MVnLt81d9Us+XCcmYcR3MnGki" +
                                                              "jM90Vl5rmtIYypG+7uW6bz4j3QUJAYKwpeyiPK6GsnvdVV3ifupNxS3GqUXq" +
                                                              "2Vb+9I+t7/zhIZF6GgtM9uSzew+Vym8kn/69IDijAIGYN/ve6Nc3v7bjBe4R" +
                                                              "pRgmsB9BqnAFAQgnLnesylqqFg3TABo8JgwlfhmR/8u4HTeVxCCNtoI4vbKp" +
                                                              "GAwKjXZtRDF1LYmq2Onh/8EmDcZZ7B/VXDYav6fpxWvGm94BJ+kjpYoFkRNw" +
                                                              "K1CvuGiOH377w5cr6h7ggaQY4behzy308uu4nPKMW6USmy+krcLu0WMqSdjS" +
                                                              "I7Z7nNezXd7b3MPdA+lWCZN+Bn8huP6FF5oSO4RJa9rseqMhW3AYBnJbEnBC" +
                                                              "yGUa3V3z9vCd790vfNJbkHkm0737b/oscvN+sXNF1dqUVzi6aUTlKjwUm1aU" +
                                                              "blEQF07R8ccjux+9d/cNQqqa3BqsHY4Y97/66QuRA799rkD6L46PMWGSFTm7" +
                                                              "eVauBYRG626sfGxfTVEH2LqLlKY0ZWeKdiXcS4JZrVTctQGdcph3uHVDyzAS" +
                                                              "WopGyBegNqd04KdQJ3vd98r5vzx0y+2jQuMA+3no5v1jgxrf87u/cyDyknUB" +
                                                              "k3ro+6KH75zftuZDTu9kTaRuTufXYLB/HNrz7kv+LdxY8tMwmdpHqmT71LdZ" +
                                                              "UlOYi/pgh1iZoyCcDHPGc08tokRvyVYFtV6fcrH15mu3pYpZjlWqxe4LEZ6h" +
                                                              "ruAUZ/F2KTbncMuE8TbCYFFFk1RO1wr5T6XaIBvik9fZjos/nYwUwb7H2wtd" +
                                                              "Rg6Lpfj/85idbVA1OAfpGsXElRkTtaaiR7JnUBgs5C51Oe7SzUOLg/2bM259" +
                                                              "94fNg60TKTKxr/4UZST+vxAMv9TfA72iPLPng/mb1gxtn0C9uNDjVt4lv9t9" +
                                                              "+LmLz5RvDfNjrnCKvONxLlFLriuUmRTO81ruNm0SDsGtJ7wBm2Xcvvz/c7N2" +
                                                              "INwOIhCrAWO8HFPAfWQ0tPCLgOk783qxOllYuO5pTxqMVyq7fjD34dWHxt/i" +
                                                              "JZqRJl5vwX/XpzmDlQHMR7FZbLnL9Vzjup7l9Mv7jh2v2Hz8iRN5kSW3Ou2W" +
                                                              "jBZnt52J8X2u9zjVKVlDMG/F0fXbqtSjJ3kyLpdkyJzWBhOOc+mcWtaePWXq" +
                                                              "r598as72l4pIuIOUqbqU6JD4sYBMg3qcWkNwEkwbF14kqpxRrE2ruKokT/l8" +
                                                              "0LGD2Rt4Ae8s4/eX5Ra8c+FaYBe8C7xVvR1XriscV4indg4HLMVIebxDSirq" +
                                                              "WMZf14ojA7Yc3D1itat91S0geK3NrdZH8BudLfDVfFn9qFFWDF0DvWxMLSjr" +
                                                              "TROUdSZcdTa3Oh9Z9wXK6kfNyNT4FVQZHGKF5LzlNDCttznV+8h5R6CcftSI" +
                                                              "KRTKhm5mDnheWQ9MUNbZcC20uS30kXU8UFY/akamxfHZqilZBVH99gQlRf9q" +
                                                              "sHk1+Eh6d6CkftSMVMV7makPY6JTJD9o7zkNaBfZLBf5CHw4UGA/aoR2rZn0" +
                                                              "3Vj3n4bDNtq8Gn0k/V6gpH7U6LAxyvD8o5vJQrI+PEFZ8abJ5tbkI+uPAmX1" +
                                                              "o2ZwhO5WEviQtZCgj56GoM02q2YfQZ8MFNSPGgXd0ukbrn4SIGjaVc1kGfK/" +
                                                              "EuJ5QOxi6Mp+BPN2nd8zfH4mO7hn/3hiw93LM8fTLnBXphvnqHSEqq6lyvk9" +
                                                              "zYoxA5fHjLfCFmOFFzVHUY8G2YdOfqQBxc6xgLFXsfk5IxWDlHnyroP3L07l" +
                                                              "GP9JheGHxSpboVUTx8KPNEDfdwLG3sXmNwILT153sHhzsrDAELXaVmj1xLHw" +
                                                              "Iw3Q988BY8exeR/8GrBw1Q0ODh9Mpk/Ya4rfieHgRxqg68mAsU+x+Vj4hKcu" +
                                                              "cbD4ZLKwwDC1zlZo3cSx8CP11zdUGjBWhk0RJDzAIqfuySIRKp4sJBrg6rTV" +
                                                              "6Zw4En6kAdrODhibi00VIzUYKQrUVQ4g1ZPpGjFbq9jEAfEjDVC6MWCsGZs6" +
                                                              "4Ro5dZuDRP1kBoweW52eiSPhRxqgbTRgbDk2S0XAEHVhR6YudLBYNllYzINr" +
                                                              "k63Qpolj4UcaoO/qgLE12JzPSBlg4a47HSBWTSYQW2xttkwcCD/SAGW7AsYu" +
                                                              "xWadAMJd1zpAtE8CEFUZILbZ2mybOBB+pAHKbg4Y24LNZVDeM118n8NnzYPz" +
                                                              "qfOc2DXAaTb+L6BJM1IivnTAp4zz8j6kEh//yA+MV5bOHb/8NfHCK/OBzvQY" +
                                                              "KR1Iqar7+brrvsQw6YDCwZwunv8ZXPA4I42n/gCDkSks81Q8JAlK6KwNomSk" +
                                                              "GH/cJEOMzPUhAdXFjXv+MGDunQ+i8F/3PKAuc+bBUuLGPWUnI0UwBW9No4BB" +
                                                              "xTuNdIgPLXAbiqM1+1T2dZ3LmnIe1/Kv5jLPzVPiu7l++cj4JeuvPvH5u8VX" +
                                                              "BLIq7dqFq5THyFTxQQNfFJ+9L/JdLbNWSeeSkzMenLY4c9KrFgI7+2aB49yE" +
                                                              "ERIy0L3me16xW83ZN+2vH1z9xM/2lrwcJqGtJCQxMnNr/tuftJGCI+jWWP5r" +
                                                              "Ol5mgLO0LPnW2JqzB/7yBn8OTvLeqnnn98vHDl35yq3zDtaHSXkXmQKHWJrm" +
                                                              "r6XWjWkbqTxi9pEKxWpPg4iwiiKpOe8AZ+BOkHBbclxsOCuyvfgNCjh7/vvP" +
                                                              "/C93ylR9lJqtekpL4DIVMVLu9AjLeF5fpAzDQ+D02KbEthub1jRaA/yxP9Zt" +
                                                              "GJnXw+UrDR4G1mejQ87bAnTc6/kt3n3t3yq2EAxRKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pSuJH/ygo60050hTD26fuQMyHimaLzaH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("kD0ykJNLn4dAb2PZuS3Ldow6Y4fud8/I+7dF8rWk9PBSS07sNB0y91/cbYnu" +
       "aKunAWzsAWzce4D/8Yy8PyiSb+wAnti2OgT4++8XYLHC/+oewFfvPcB3zsj7" +
       "r0XyR0DdAMAje2CH4L51L6S3V3d3v7fg/vSMvO8WyZ/spHdiQ+0Q4P94vwAL" +
       "02/tAWzdc4DnrpyR92CRXEhKDwKAx3bnDuCdu/h+4T0Prt4evN69h/f4GXlP" +
       "FMm1pPRYYX132Oo7RPnovRAitYeSuvcoXzgj73qRPL0T4rF9w0N4z9wLI5zs" +
       "wZvce3g/eEYeVCTfvzPC3SZkZ38T8hDgy+8X4JPg4vYAcvceIH5G3itFgiSl" +
       "BwDAozuah+jq9wLdYg/d4t6ja5+R1y2Sj+7QHd0ePURHvA901/bRvbaH7rV7" +
       "j256Rh5bJFRSupz4h5upv3SIjX432LKkdGl3Nr04aPvkbX992f1dQ/nym1cv" +
       "P/Hm7F/tjrzu/6XiClW6rKeOc/SM3ZHnS0Gk6eYW65Xd0aZgC0BMSi/e/ch8" +
       "UrqY7J+MOyfsav5oUnr6rJpJ6UJxO1rlY0npiVOqFHvZ24ej5ZWkdO1keUDK" +
       "9n60nA7U67AcaGr3cLSImZTuA0WKR2t35uz4VvjuXGN2bpv15FFl2w7yj91N" +
       "jkdC9evHTqJt/+e0f3Iv3f3T6ZbylTcHox9/B/3Z3VF1xZHyvGjlMlW6f3dq" +
       "fttocfrvhVNb22/rUu/l7zzy1Ssv7Qf/j+wIPlT8I7Q9d+dz4W03SLYnufN/" +
       "8MQvvPp33vy97c78/wFMf0OzgDYAAA==");
}
