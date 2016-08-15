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
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfYxUVxW/M/v9/QHLxwLLsiw0LHReqaUGl2Jh2S1LZ2HD" +
                                                              "UqJDy3LnzZ2Zx7557/HefbuzW7G0UUETESml1AB/0VAJLWhs1GgbTKNt02rS" +
                                                              "Fq3VlBo1Ea3EEmM1otZz731v3sfMLmKMk8ydN/eee+855/7O75z7zl9DFZaJ" +
                                                              "OohGY3TSIFasX6PD2LRIqk/FlrUD+kblJ8vwn3df3bo2iioTqDGLrSEZW2RA" +
                                                              "IWrKSqBFimZRrMnE2kpIis0YNolFzHFMFV1LoDbFGswZqiIrdEhPESawE5tx" +
                                                              "1IIpNZWkTcmgswBFi+KgicQ1kTaEh3vjqF7WjUlPfJ5PvM83wiRz3l4WRc3x" +
                                                              "vXgcSzZVVCmuWLQ3b6KVhq5OZlSdxkiexvaqaxwXbImvKXJB18WmD28cyTZz" +
                                                              "F8zCmqZTbp61nVi6Ok5ScdTk9farJGftQ59FZXFU5xOmqDvubirBphJs6lrr" +
                                                              "SYH2DUSzc306N4e6K1UaMlOIoiXBRQxs4pyzzDDXGVaopo7tfDJY21mwVlhZ" +
                                                              "ZOITK6VjT+5u/mYZakqgJkUbYerIoASFTRLgUJJLEtPakEqRVAK1aHDYI8RU" +
                                                              "sKpMOSfdaikZDVMbjt91C+u0DWLyPT1fwTmCbaYtU90smJfmgHL+VaRVnAFb" +
                                                              "53i2CgsHWD8YWKuAYmYaA+6cKeVjipaiaHF4RsHG7vtBAKZW5QjN6oWtyjUM" +
                                                              "HahVQETFWkYaAehpGRCt0AGAJkXt0y7KfG1geQxnyChDZEhuWAyBVA13BJtC" +
                                                              "UVtYjK8Ep9QeOiXf+Vzbuu7ww9pmLYoioHOKyCrTvw4mdYQmbSdpYhKIAzGx" +
                                                              "vid+HM954VAUIRBuCwkLmW9/5vq9qzouvSJkFpSQ2ZbcS2Q6Kp9JNr6xsG/F" +
                                                              "2jKmRrWhWwo7/IDlPMqGnZHevAEMM6ewIhuMuYOXtv/o0wfOkfejqHYQVcq6" +
                                                              "aucARy2ynjMUlZj3EY2YmJLUIKohWqqPjw+iKniOKxoRvdvSaYvQQVSu8q5K" +
                                                              "nf8HF6VhCeaiWnhWtLTuPhuYZvlz3kAIVcEX1cN3MRIf/kuRJmX1HJGwjDVF" +
                                                              "06VhU2f2WxIwThJ8m5WSgPoxydJtEyAo6WZGwoCDLHEGsGFYkjWeSZr6BLCh" +
                                                              "NLLPVjIZFdjMsOlmrKXAvgFFBXTFGO6M//uOeeaDWRORCBzPwjA5qBBXm3U1" +
                                                              "RcxR+Zi9sf/6c6OvCeCxYHG8R1EvKBETSsS4EjGmRMxTIja9EigS4XvPZsoI" +
                                                              "WMChjgE9AD/Xrxh5aMueQ11lgEdjohxOhIl2BfJUn8chLvGPyhdaG6aWXFn9" +
                                                              "UhSVx1ErlqmNVZZ2NpgZIDR5zIn5+iRkMC+RdPoSCcuApi6TFPDYdAnFWaVa" +
                                                              "Hycm66dotm8FN82xgJamTzIl9UeXTkw8uvORO6IoGswdbMsKoD02fZgxfoHZ" +
                                                              "u8OcUWrdpoNXP7xwfL/usUcgGbk5tGgms6ErjI6we0blnk78/OgL+7u522uA" +
                                                              "3SmGaATi7AjvESCnXpfomS3VYHBaN3NYZUOuj2tpFqDk9XDYtvDn2QCLOhat" +
                                                              "y+Db5YQv/2WjcwzWzhUwZzgLWcETyT0jxqmf/+T3H+PudnNOk69YGCG018dz" +
                                                              "bLFWzmgtHmx3mISA3Lsnhh9/4trBXRyzILG01IbdrO0DfoMjBDd//pV977x3" +
                                                              "5czlqIdzConeTkK9lC8YyfpR7QxGwm7LPX2AJ1VgDoaa7gc0wKeSVnBSJSyw" +
                                                              "/tG0bPXzfzzcLHCgQo8Lo1U3X8Drn78RHXht9187+DIRmeVpz2eemCD/Wd7K" +
                                                              "G0wTTzI98o++ueipl/EpSCNA3ZYyRTgbR5xYZ0rNo2jNf8Uv/MjX8DXu4O1d" +
                                                              "zF18ZcTH1rJmmeUPnWB0+qqxUfnI5Q8adn7w4nVua7Cc8yNlCBu9ApysWZ6H" +
                                                              "5eeGqW0ztrIgd9elrQ82q5duwIoJWFEGOre2mUC2+QCuHOmKql/84KU5e94o" +
                                                              "Q9EBVKvqODWAeYiiGogNYmWBp/PGJ+8V0JiohqaZm4qKjC/qYMezuPTB9+cM" +
                                                              "yo9q6jtzv7Xu7OkrHKOGWGNBgZMXBjiZXwo8Wjj31sd/evarxydEWbFiei4M" +
                                                              "zZv3921q8rFf/63I5ZwFS5Q8ofkJ6fzJ9r717/P5Hh2x2d354nQHlO7NvfNc" +
                                                              "7i/RrsofRlFVAjXLThG+E6s2C/IEFJ6WW5lDoR4YDxaRomLqLdDtwjAV+rYN" +
                                                              "E6GXZuGZSbPnhhD3NbIjXAnfTocWOsPcF0H84X4+5Tbe9rDmdpdqagxTp6Al" +
                                                              "SYXYpmGGZSmqyopIY3/vFgTL2k+wJi5WuqcUIMXQbaxZWdiPfyrDFZif3TzE" +
                                                              "IRZWi6YrknmBf+axY6dT255eLTDXGiw8++Fe9ezP/vl67MSvXi1Rz9RQ3bhd" +
                                                              "JeNE9e0ZZVsGUD7E7w8eZN5tPPqb73ZnNt5K0cH6Om5SVrD/i8GInukDJ6zK" +
                                                              "y4/9oX3H+uyeW6gfFofcGV7y60PnX71vuXw0yi9LAstFl6zgpN4ggmtNArdC" +
                                                              "bUcAx0sLAJjFDnY+fJc7AFheOoeXwE4hM043NZQFQvmlnlOfogN/qITvQmZI" +
                                                              "Gwpr9kB+Zoxt0GBBys57xE5aUDwqOagVxp3b153De+RD3cO/FXCcX2KCkGt7" +
                                                              "Rvryzrf3vs4PrpohpeAuH0oAUb4yqFn44SP4ROD7L/Zl2rIO9gt81OdcpToL" +
                                                              "dylG4TNyccgAaX/re2Mnrz4rDAgTb0iYHDr2pY9ih4+J2BIX8qVFd2L/HHEp" +
                                                              "F+awRmPaLZlpFz5j4HcX9n/vmf0Ho87ZfApIKanrKsFa0WFD7Rd0u9B10xeb" +
                                                              "vn+ktWwAonYQVduass8mg6kgcqssO+k7B+8O7+HY0Zr5nKJIj5shORfiGbjw" +
                                                              "P0jOrKPP4P0PFiDf6lJyjwP5nluPlummzgD+z80w9gXWPEJRY4bQTcSSTcUo" +
                                                              "cA5EWTOPMpYTY+LFiuegA/8LB+Upap/+nslKnHlFL7/ECxv5udNN1XNPP/A2" +
                                                              "Z+7CS5V6iMC0rar+JOx7rjRMkla45fUiJRv85whcJG9WsFJU6/3hBn1FTH6c" +
                                                              "oraSkykqZz9+2ePg07AsRRX81y/3FOzmyTHi4g9+kZMUlYEIezxluAfWxd8P" +
                                                              "xKwJOKsYe40iZ3WdVduMJoVX85FgVi6caNvNTtSXyJcGSIi/x3Sj1BZvMuFC" +
                                                              "f3rL1oev3/20uKHJKp6aYqvUQWyKy2Ihjy2ZdjV3rcrNK240XqxZ5pJGi1DY" +
                                                              "i5cFPlD3AXUYDDztoeuL1V24xbxzZt2LPz5U+SbQ3S4UwRTN2lVcAOYNGwqI" +
                                                              "XfFiDoKcz+9VvSu+Nrl+VfpPv+QlNioqrMPyo/Llsw+9dXTeGbh/1Q2iCuBD" +
                                                              "kueV6aZJbTuRx80EalCs/jyoCKsoWA0QXCPDOWaByP3iuLOh0Mvu9wCCYtou" +
                                                              "fisC15EJYm7UbS3lUGSd1xN4weqWArZhhCZ4Pb7UlhesKrJY2Wh8yDDcrFYm" +
                                                              "GTzwJ8NEzzv5xIv8kTXf+DcAmTB04xgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/Fwo/Z03/NZbfu35r+cbsv8FbaaAPQQjAAA=");
}
