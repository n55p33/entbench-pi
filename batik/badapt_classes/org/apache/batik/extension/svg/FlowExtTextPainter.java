package org.apache.batik.extension.svg;
public class FlowExtTextPainter extends org.apache.batik.gvt.renderer.StrokingTextPainter {
    protected static org.apache.batik.gvt.TextPainter singleton = new org.apache.batik.extension.svg.FlowExtTextPainter(
      );
    public static org.apache.batik.gvt.TextPainter getInstance() {
        return singleton;
    }
    public java.util.List getTextRuns(org.apache.batik.gvt.TextNode node,
                                      java.text.AttributedCharacterIterator aci) {
        java.util.List textRuns =
          node.
          getTextRuns(
            );
        if (textRuns !=
              null) {
            return textRuns;
        }
        java.text.AttributedCharacterIterator[] chunkACIs =
          getTextChunkACIs(
            aci);
        textRuns =
          computeTextRuns(
            node,
            aci,
            chunkACIs);
        aci.
          first(
            );
        java.util.List rgns =
          (java.util.List)
            aci.
            getAttribute(
              FLOW_REGIONS);
        if (rgns !=
              null) {
            java.util.Iterator i =
              textRuns.
              iterator(
                );
            java.util.List chunkLayouts =
              new java.util.ArrayList(
              );
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun tr =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                i.
                next(
                  );
            java.util.List layouts =
              new java.util.ArrayList(
              );
            chunkLayouts.
              add(
                layouts);
            layouts.
              add(
                tr.
                  getLayout(
                    ));
            while (i.
                     hasNext(
                       )) {
                tr =
                  (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                    i.
                    next(
                      );
                if (tr.
                      isFirstRunInChunk(
                        )) {
                    layouts =
                      new java.util.ArrayList(
                        );
                    chunkLayouts.
                      add(
                        layouts);
                }
                layouts.
                  add(
                    tr.
                      getLayout(
                        ));
            }
            org.apache.batik.extension.svg.FlowExtGlyphLayout.
              textWrapTextChunk(
                chunkACIs,
                chunkLayouts,
                rgns);
        }
        node.
          setTextRuns(
            textRuns);
        return textRuns;
    }
    public FlowExtTextPainter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+zrVn33/bX33t7b0ntb6GOFvm9hJd3PcZzEyS5jOI6T" +
       "OIkTx46dxBtcHL8Tv+JXHEN57UE1pA5tLWMadNIEGqBC0TS0TRNTp2kDBJrE" +
       "hPaSBmibNBhDo3/AprGNHTu/93101aRF8snJOd/v93y/3/M9n/P1OXn+u9Dp" +
       "wIcKnmttdMsNd9Uk3F1Yld1w46nBbrdfYSQ/UBXCkoJgDNquyI989sIPfvhB" +
       "4+IOdEaEXi05jhtKoek6AasGrhWrSh+6cNhKWqodhNDF/kKKJTgKTQvum0F4" +
       "uQ/deoQ1hC7191WAgQowUAHOVYDxQyrA9CrViWwi45CcMFhB74JO9aEznpyp" +
       "F0IPHxfiSb5k74lhcguAhFuy3wIwKmdOfOihA9u3Nl9l8LMF+Jlfe9vF37kJ" +
       "uiBCF0yHy9SRgRIhGESEbrNVe676Aa4oqiJCdziqqnCqb0qWmeZ6i9Cdgak7" +
       "Uhj56oGTssbIU/18zEPP3SZntvmRHLr+gXmaqVrK/q/TmiXpwNa7D23dWtjK" +
       "2oGB502gmK9JsrrPcvPSdJQQevAkx4GNl3qAALCetdXQcA+GutmRQAN053bu" +
       "LMnRYS70TUcHpKfdCIwSQvddV2jma0+Sl5KuXgmhe0/SMdsuQHUud0TGEkJ3" +
       "nSTLJYFZuu/ELB2Zn+8O3vT0O5yOs5PrrKiylel/C2B64AQTq2qqrzqyumW8" +
       "7Y39D0l3f/6pHQgCxHedIN7S/N47X3rLEw+8+MUtzWuvQTOcL1Q5vCJ/bH77" +
       "V19HPF6/KVPjFs8NzGzyj1mehz+z13M58cDKu/tAYta5u9/5Ivtns/d8Sv3O" +
       "DnSegs7IrhXZII7ukF3bMy3Vb6uO6kuhqlDQOdVRiLyfgs6Cet901G3rUNMC" +
       "NaSgm6286Yyb/wYu0oCIzEVnQd10NHe/7kmhkdcTD4Kgs+CBbgPPG6DtJ/8O" +
       "IQU2XFuFJVlyTMeFGd/N7A9g1QnnwLcGPAdRv4QDN/JBCMKur8MSiAND3esA" +
       "i0Z1AmAjHMQ6iFp3TSbhGLQyUh65u1m0ef9P4ySZvRfXp06BqXjdSSCwwBrq" +
       "uJai+lfkZ6IG+dJnrnx552Bh7HkqhBAw9O526N186N2DoXfB0LtXDw2dOpWP" +
       "+JpMhe3Eg2lbAgAA0Hjb49xbu29/6pGbQMR565uBzzNS+PoITRxCBpUDowzi" +
       "Fnrxw+v3Cu8u7kA7x6E2Uxs0nc/YmQwgD4Dw0skldi25F97/rR+88KEn3cPF" +
       "dgy79zDgas5sDT9y0sG+K6sKQMVD8W98SPrclc8/eWkHuhkAAwDDEHgsw5kH" +
       "To5xbC1f3sfFzJbTwGDN9W3Jyrr2wex8aPju+rAln/nb8/odwMdvgvaKY9Ge" +
       "9b7ay8rXbCMlm7QTVuS4+1Oc99G//vNvo7m79yH6wpFNj1PDy0dgIRN2IQeA" +
       "Ow5jYOyrKqD7uw8zv/rsd9//M3kAAIpHrzXgpawkAByAKQRu/oUvrv7mG1//" +
       "2Nd2DoMmBPtiNLdMOdka+SPwOQWe/86ezLisYbuk7yT2cOWhA2DxspFff6gb" +
       "gBgLLL8sgi7xju0qpmZKc0vNIvY/LzyGfO5fnr64jQkLtOyH1BMvL+Cw/cca" +
       "0Hu+/LZ/eyAXc0rOtrhD/x2SbXHz1YeScd+XNpkeyXv/4v5f/4L0UYDAAPUC" +
       "M1VzIINyf0D5BBZzXxTyEj7RV8qKB4OjC+H4WjuSilyRP/i1771K+N4fvZRr" +
       "ezyXOTrvtORd3oZaVjyUAPH3nFz1HSkwAF35xcHPXrRe/CGQKAKJMkC1YOgD" +
       "9EmORcke9emzf/vHf3L32796E7TTgs5brqS0pHzBQedApKuBAYAr8X76Ldto" +
       "Xt8Ciou5qdBVxm8D5N78181AwcevjzWtLBU5XK73/sfQmr/v7//9KifkKHON" +
       "HfgEvwg//5H7iDd/J+c/XO4Z9wPJ1YgM0rZD3tKn7O/vPHLmT3egsyJ0Ud7L" +
       "CQXJirJFJII8KNhPFEHeeKz/eE6z3cAvH8DZ605CzZFhTwLN4U4A6hl1Vj9/" +
       "AlvuyrzcAs8Te9jyxElsOQXllbfkLA/n5aWseEM+JzshdM7z3RBoqYI87kyQ" +
       "J6D5II+DrgBkZJYa7nn9rhB66KoNSY/D3SP7zxbKshLNCnwbANXrBsvlfKjk" +
       "FMCU06VdbLeY/e5dW9mbsuqPZwUJqDXTkax9Te9ZWPKlfagRQMoMIuXSwsL2" +
       "9b6YB3k2J7vbPPOEno//r/UEQXz7obC+C1LWD/zjB7/yy49+A0RaFzodZ1EA" +
       "AuzIiIMoy+J/8fln77/1mW9+IMdRAKLCex771zwn4l/W2qwY7pt6X2Yql6cm" +
       "fSkI6RzuVCW39oYLjPFNG+wQ8V6KCj955zeWH/nWp7fp58nVdIJYfeqZX/rR" +
       "7tPP7BxJ+h+9Ku8+yrNN/HOlX7XnYR96+Eaj5Bytf3rhyT/8xJPv32p15/EU" +
       "lgRvaJ/+y//6yu6Hv/mla2RLN1vu/2Fiw9trnXJA4fufPjKTSmsZYSeFqIxp" +
       "PsaPh7VW16HZhFwskwjTLUMZGclYLJX9RgFpSlHkWAEWYCoqImXFnm3kuqK2" +
       "S7oh8JPVyrYlw2RbY4HzPJcsdiV9hYcrYtrrbMg+y1FEyTIbnAC7TY4gKNIX" +
       "V4XUL6bDal0ZFoX6pLvCymnsoLRcQWFnGGmaLApcIFVNcdNkKQ+ZmA00tIbu" +
       "GnFkFuv2Un9Wx6ctvsyXR3ApXpTKyazeo1a6bWh8A1ej5XjDclOqoFtSL+A3" +
       "6z7bqC27dLloLCYmWSpyPNJmqarRQJh4vDJHPcpARmV31F206XABBvJEd7ZB" +
       "mtx8XcGLsrv2iTEpJP1VzcGiZo9ejYS2M9daVjMm1SSRbXs+d4rmsmcw2oJj" +
       "0x7fInsGP1GAr5CQtARvaC+9Aa5vlL6u2XYqzXpKWUYqXduoAIBZrIoKh0+q" +
       "RCKYk5a8Qr1ybTQVSZsbb2gpQtWpay/rI8Ylqrq7IFxlbXCI4QzHht3kSHIj" +
       "larFsCFFcdehbFRi1pjSlDlislo3RLLI+ihF+BN54MqiZ8Ztfua6hbkajfuB" +
       "4k+QSWk4VYWopiGMW6Lsus7WJq7iUitjavHzmYyzYmMmUlS7yy1nxfE4KnQT" +
       "0i3oQ8OWGd4tknxsLoaOp1oIvfEMe80UKwHWHC5It8islLAH4wuMRPtEa8z6" +
       "w6I17DVpuOyOySVGTI04jFkXw9pMPaDJHslKdnfc1FOLFQdEpyfPvIk6ngTM" +
       "fK429Z4+8Vx70BNm/KbE0VNOV3XaJD1p7Apt3PHWZHFCtfCewSLNcezS6aRn" +
       "zGy52yXbHFWXA6bdreCrSlnUe8YIUelpmRsSVtctTDtMtcL0F0iti26aoc1o" +
       "/aY9bJDLMK70+LZf6lGlUWNAUgnVNiZ9PtEaa5RxptQiwakBapJN0elgmLeR" +
       "0DhFmWE7ZSiCXg4TmOd0fkKWBGdgsDwMMsteadHsCkV+amsDbaiKo4GN1KrB" +
       "BqTZPRqh4mCWdkpyG3VKNViVuypc5Xke7hkk3xPpdmfAdznLFbpSN+ymfZYm" +
       "polmscNKR2fgepXhIrLep32y2kB63Q5LFOqkaYLZ7TEJTLdIwrBxe+U2UJ4v" +
       "u9FUFooJC6dVlwISy3yDr7UrzSRBa57pKhznrciAali8IBLrik/UV4WO3mmZ" +
       "s0HI93DJddYLD0REk6BmfJ91CJ2ieXpcx4uNhmikpXadXi7dliRWA5SjVV1J" +
       "jE1lNJuV6lqtOK7MQwVu8+lajSZD0sJ1y5Qo2Uxmy0lrVrEiJ4qZRrdeHOFg" +
       "8HTMgyldD9jGrODqTuq5Y7ZErmZMhd8MtUWtUDYItCE3N+X5iKLwhlle2Ugx" +
       "rVXqBrLq4Z3OCiF66yE7COXJxOx4gSWHI7UlY1OhVggiZZwsGrWQWA2q/QFO" +
       "W5ZhVpUeN2o5hNFwBGHcofiptJoMEarFpR1p5uHlADirygPEGm1Esev63YLZ" +
       "nZVZ2bVpY5K48ILlZAZxsWjMx+pAi+k2Aw+xYN2bBQ27u6gGQ7q4QaN5PNmM" +
       "Vq1EKtSxQpVJk0J9Mu9UAP6EshWkY7ETurVJn5AqVTfokIhmplVkUArRYWqt" +
       "BzXeoTduoCwxoxwWhs6AT2ORaxjhsNdyJa6QjNNgJgx6vMejM6ZRChQpcWm0" +
       "SVEqO6eCGh66hZWHwunG4esbrjDj2FVxUSzXuFK01HtjccZI6mJoROwscQ2K" +
       "0dobtRWjDlyJraK8MIkkDAnSl9IQn1IEVsZbMZzWdEUpKCWn5IaFNk3xgTOz" +
       "GoHIWCribMbwIl1rNFNfNMwZW2yvlTFqExu0tKIqllyqoVZ5TnbLpEg38eJ0" +
       "1Wk2cZ7c9IbcbNxK6/UVgvK1+kpr4jKjkPF4WRx0C9ioE8BRVC2OizEWIymd" +
       "wO0uRpBSPWZai8FM65N12VPt8sQuLaJNvV+Fa4jDlFvDUbPcbigO0ZYFo402" +
       "CtQQpZNQHg3iOczWovISqaIjJwkRo0KYtBv0WLNQny4wGK43JoWJo1gVbYzh" +
       "rRnWZEfi1G12Q7OXygpZK9RXbuCIXiuU1ggZ8kOMUPWgFTmNWO6ITdsPekVS" +
       "NCY40Z8Y6UhPe+s+txKLsmrFGizSZazcZ+WFZmzcZUPWMBqvlQW8QnVRtxc1" +
       "JV+LxMksQcaigpNRExk57nQz9PSpYExL81Jd8pT1gi7WAljpTOiqHMuCuUqM" +
       "Rb8/E5XypDubBuP5aIqVLDEsKOpsnlRVml41Qs2ep1UCxaoVnB/CCywujCvG" +
       "dCDpbL/lJrWuo4UlvlYoKZhdGHMVOkoncwfr4W4bVcaVZKAVjLin2ZVORWjz" +
       "JL42C2LSbwuzKanq/IBNrfGIR1ZYjK36zKqDV/taVy5zfCnBWHXiD8bd+TqV" +
       "NFHF5JaOowOjk6ZhV5/PY3ZRpLTqZlmNgkqpOJfqq0oBXvOWFEkjuy00cF8h" +
       "PWRabVm+hlfZ7iiim7BbRfo850qiby1bZkrG/oZfSkqbTfRyV1TTgT9faHYJ" +
       "cam47hBVWEqQQhwqWg9e6oJZHLXEZNjdVKaJQEuwK65r6jApaqoPorJdqkf1" +
       "fmDMGL6JYvV6RSW69XrN5RssXywL9emqO270u7SkamN12VuuW4VZH0/qxfmg" +
       "OFfVOYmUtMpaMhgeKM30Zkwh1pdI4DThTUyGFSzCNbsmlTxNrC86XdOSVRls" +
       "M1pnsUDX8RxZWyTMJEVxLTbQlUP5ytxruiS1kPENnyCbRjCYEaPmIJ03glqH" +
       "m+FDf9OYUXTErN2ybelphWoV0BG16HsEkeCTgszXCWGV0Guj0yzLOjvcNE1i" +
       "PSbjYsf1e4N5RUNYsMxlbbys2TU0nLcwfNRLK84g4FqjyFWduT/YtOJi0Omp" +
       "qqWTDCEuEb/DJwTWxg0JSceJY3B6s2d0q1WVRIpKbSnS/QkjR4ixXvt0ZLdp" +
       "h4oWcWnSIgaiTVU7cmvMDFeLdVQe6PJ80mcLxfawo07J5kSe6AW4S2vshprj" +
       "LmWgra47YxSjIJGpKPf96kSDZ4QBNrhmY9kOyz2GQ2qChsa1cdN301Y0Ekps" +
       "ed3spMaq5DYtr+HZuuOVOwtJSTo1rxQXtY4uNvpsyZwZHsUsRra3tGWU5xJG" +
       "NDupBnuF/oaQw7aNzcfxuGgoWB2txUJAB9WqaNQrQYGT4UJBavEp46SJzady" +
       "0i9K8wrIozf9QjqzJ3MFj+RNe4Nr8xguos0wXqhwYleIYCaXpsHC1pFU90cr" +
       "hoRXbksU64JAIAlIDWcFX4oRBityHYTtbLiuZnGTpcw32wqlKcnAWonV7nDW" +
       "WKBJRwwblj4eN/tNvcwXxnO7t/CHjOLBOhpteHxudeoV0ZsvA6yGjaKhzHUW" +
       "ljLB5sV6oxTX4sRBeUEYcaMl7fWXPsXL2GayYg3KRJGhwLO2Bw9l0iHIaWxF" +
       "IPE3pDjGFkZQbraa04G/HlTQqYdKXsnsDZuCuzJncOpb8XLAGlyxY4nzpGyM" +
       "K/3VussOFr7f9ZocXBYIbsDMGnK5Z+DhkHQRcdQlklLH8um6UkVMdT43J2KC" +
       "WkXBnRZjC5HxKm1PyNSlqxq6sMqVisAwE1O2Rnw3rW3WAAUaeiB10Z47RII1" +
       "NrGrwdJAQqEUqH2hMDUTZzpRSpWBW47NRqPg2+im08AQIQroguIHyEqBZWmx" +
       "FGeL0lQ2Oz1hVethtQjkTiKHl7B1bBsNj+eZulAKF8V1LBXrNQXz4SHXrAVl" +
       "bBrbrsx0aMdSh30vahVLdYvZrNoTr7sszDpGaFsVAzfHE50VTNSLW96McsvG" +
       "TA6EpCnTddHQWihRtYdSFE4dqTuyWn3URda6FDhDQhiSEjLfyEayXC9XGItN" +
       "mekkWtMrd7XUGpjTXjo03VbZhehxutSxmgKKIyQraj1CbfpgQ1s4QoqBbaZn" +
       "m1qhIXgDeKCv2jqOZ6+Q2it7i78jP7A4uCUDL+9Zx+gVvL1uux7OiscOzoPy" +
       "z5kbnDUfOY+Dsjfy+693+ZW/jX/sfc88pww/juzsnWNKIXQudL2fsNRYtY6I" +
       "2gGS3nj9kwc6v/s7PF/7wvv++b7xm423v4IbhAdP6HlS5Cfp57/Ufr38KzvQ" +
       "TQenbVfdSh5nunz8jO28r4aR74yPnbTdf+DZBzKPPQ4eZM+zyLVP8a99zHYY" +
       "BdsAuMFZ8Ttv0PeurFiH0K26Gu6bkTW1D0MmebkDj6My84bwwMac7LXgqezZ" +
       "WHkFNp7KbbymeTt7QbJ3GHf/dQ8RB66i7lM9lh+gZRfhu3gY+uY8ClWFMEBU" +
       "yKHqU6Ga307k4z11A5c9nRU/t3VZNgQbOcGxk6jj0cpK63wJXJH/YPTNr340" +
       "feH57UHTXArUECpc768EV/+bIbuVeuwGN2uHl8zfb//ki9/+B+Gt+4vs1oP5" +
       "uDWz4sKN5mPfWbcfPfjfXpI8exgTP/9KYiIJoTuvvlfMLkbuvervDNsrePkz" +
       "z1245Z7n+L/Kr9YOrsnP9aFbtMiyjp5jH6mf8XxVM3OLz21Ptb386yMh9MCN" +
       "rz1D6CZQ5or/xpbnN0PovuvzANA6qB/l+q0QuniSK4RO599H6T4eQucP6ULo" +
       "zLZylOQTQCdAklU/6e1PytW3t1mc+6qjqL7qZwfR7tJ09CNeTk4dx+eDGbzz" +
       "5WbwCKQ/eizq8n+q7INmxOwF9wvPdQfveKn68e2lomxJaZpJuaUPnd3ebx4A" +
       "78PXlbYv60zn8R/e/tlzj+3H7+1bhQ+h4ohuD1771o60vTC/Z0t//57ffdNv" +
       "P/f1/JD8fwDn/U8FQiQAAA==");
}
