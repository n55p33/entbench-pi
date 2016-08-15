package org.apache.batik.svggen;
public class SVGBasicStroke extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGBasicStroke(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        if (gc.
              getStroke(
                ) instanceof java.awt.BasicStroke)
            return toSVG(
                     (java.awt.BasicStroke)
                       gc.
                       getStroke(
                         ));
        else
            return null;
    }
    public final org.apache.batik.svggen.SVGStrokeDescriptor toSVG(java.awt.BasicStroke stroke) {
        java.lang.String strokeWidth =
          doubleString(
            stroke.
              getLineWidth(
                ));
        java.lang.String capStyle =
          endCapToSVG(
            stroke.
              getEndCap(
                ));
        java.lang.String joinStyle =
          joinToSVG(
            stroke.
              getLineJoin(
                ));
        java.lang.String miterLimit =
          doubleString(
            stroke.
              getMiterLimit(
                ));
        float[] array =
          stroke.
          getDashArray(
            );
        java.lang.String dashArray =
          null;
        if (array !=
              null)
            dashArray =
              dashArrayToSVG(
                array);
        else
            dashArray =
              SVG_NONE_VALUE;
        java.lang.String dashOffset =
          doubleString(
            stroke.
              getDashPhase(
                ));
        return new org.apache.batik.svggen.SVGStrokeDescriptor(
          strokeWidth,
          capStyle,
          joinStyle,
          miterLimit,
          dashArray,
          dashOffset);
    }
    private final java.lang.String dashArrayToSVG(float[] dashArray) {
        java.lang.StringBuffer dashArrayBuf =
          new java.lang.StringBuffer(
          dashArray.
            length *
            8);
        if (dashArray.
              length >
              0)
            dashArrayBuf.
              append(
                doubleString(
                  dashArray[0]));
        for (int i =
               1;
             i <
               dashArray.
                 length;
             i++) {
            dashArrayBuf.
              append(
                COMMA);
            dashArrayBuf.
              append(
                doubleString(
                  dashArray[i]));
        }
        return dashArrayBuf.
          toString(
            );
    }
    private static java.lang.String joinToSVG(int lineJoin) {
        switch (lineJoin) {
            case java.awt.BasicStroke.
                   JOIN_BEVEL:
                return SVG_BEVEL_VALUE;
            case java.awt.BasicStroke.
                   JOIN_ROUND:
                return SVG_ROUND_VALUE;
            case java.awt.BasicStroke.
                   JOIN_MITER:
            default:
                return SVG_MITER_VALUE;
        }
    }
    private static java.lang.String endCapToSVG(int endCap) {
        switch (endCap) {
            case java.awt.BasicStroke.
                   CAP_BUTT:
                return SVG_BUTT_VALUE;
            case java.awt.BasicStroke.
                   CAP_ROUND:
                return SVG_ROUND_VALUE;
            default:
            case java.awt.BasicStroke.
                   CAP_SQUARE:
                return SVG_SQUARE_VALUE;
        }
    }
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
      ("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" +
       "p2Hv/ZdD0rlpLweks20CvJfQ5fv18zHoT8DnCnj+X/mU6i47Dhvq4+Txrv7M" +
       "6bYehvkV4OEPYEetI7TE71ZUnq3aW2XzQ4dlKl//LAgFcZWTAgzT9lW3mphI" +
       "gIm52q0T6hLIUcGa3Nq4rRO/uVmZUyn90SGxOwTBsq1XJA4m0bqr+XzkAFXt" +
       "do+eEWMDkCP+5H/67G/89ee+AdaUgR7ISn2DpTw3I5+WafNPvP65J9/x6jd/" +
       "sopswKWljz//36skhL+XxGVDl83gRNQnSlHFKi1g1TjhqmBk6JW09zTlSWR7" +
       "IGZnxzkh8srj33B+9o9+4ZDvXbbbS8DGp1/9a39y9JlXr57Lsp+7LdE9j3PI" +
       "tCum33ms4Qh69l6zVBjUf/7KK//s773yqQNXj1/MGfvgL9Ev/M7//Y2jL3zz" +
       "a3dIWu53g7exsMmNLw7q8bB78mElhVzstNrUhZchkven7Qa5omdYvyH0fLmx" +
       "qNGDId5PQzjrb7S+1Et7XBG1dH9pYUpoNdRmu6cKZDhbbCS+i3ohscil3hxV" +
       "FaEX6IyYzAl12iUIsI2MRuLI6nS37rY/lVRd6jZNGOFbfNEiaJcRMx7r+DiS" +
       "GUgHtFmniVidtu8qCoNtN/TOK7iAUuqhtmoy/NhuLxpSvN2tgkVnaG4JDc6S" +
       "JOzoen/PSGtsuhcjpqlonr3NxW2+rRHoNgyokEM9KYpGQ3yz6TVni0TQHMW2" +
       "1TrveB5bC7s1yZkuF9u2FvbX+VAJBVSs7xXRLnrqEOHXzGAxGu+cna+Ji6ms" +
       "tYKtaLgOnrvF3pu29qu4PZxvV3oi5rS3Ha3CaT90PHpEB86WSrOR54l5oCYb" +
       "UZJ8WQnduoZvazO5rzb5ZQMdCIjf21iYjodKUCcozpnpnEK1EaDeGthLBvmI" +
       "dlGjZmx5GtdnUaO/346dwplwIm3OFzOBtFFlPZ/rqrsLMRwlazM2XDXg4c6q" +
       "jaWhMaZpxvcVjBmGoYhh5iyfCOMB7a3YwjZ6yYAv0HUQtlGxbeKUgwwHK8+q" +
       "h0wd64XUYAr7/Rbn7cmdOOp1SYvPm1bIytlAXe4Fnk522ASfS+RUwhYjUx+m" +
       "LtNbMIrRqw8ke8dhvOA0kVBeL32SHSm04oeK02wTlBbANd0VwoU4HCeoVJOt" +
       "uhjFxI6KKN2WPYXotuBdSGnjEeXpzswn6Fm8Ghc7jpiNauN5YyVqKAj9BIM6" +
       "hGoNt1uHESedYBCqfWcd6RLRdRqUMlUcuxbITg9NmHEgqLTai/oo3+VB11ri" +
       "ZG8qO/VGsXZpmZrFbjFJ4WzRioqeh/GUzbjxWKu70lIz8xqnrhMOc7qz2mi6" +
       "JjDGRlQ2GHh+s14kpNXt5UmXzIOJP/UXerrgGQz8iyc0vE942SIvpKknICyM" +
       "jcWl4mtZNpK1pEZtmoxKWjA886lE8QtcdGfL7g4tJpo2I+IeXze5MePB7eaU" +
       "b7OOHhhzexmptswbiRA3Mbc3V72G50Vzl7D5ToNgpGGCt5G+MV/j2Xy+2AS+" +
       "3hl61LTmcFuJb0ihOTG7VJ9ckEQ/MclU7fq6MdMcN2WzhcwJ8zU62cq6z1p9" +
       "E4nxYaHQc38rT0VFRqc6tzFVddx242m7t853PVmy5cGih2rxZDEmSUdBudyb" +
       "Ct2OWCMcWRTVkEodc8HWtNgSFL4fmKFHzTmDJ7kYthWKp/ftoNvhXcKpmcQi" +
       "WQVquFcFhKkrmT/iUGPgW+bWIpW13GaHXXedsbzMtpElKUfYzixqohSrS0+O" +
       "wH43pua5Q8M7wBAwHKSj1jxcRd06T9IqJ3VJT0yymJytzIggislEFEwV82Uu" +
       "RZzGHKbE/mKe9Nf7Pbre5kHNVaxh29nkMY3VOr3+SKB3vmfYQ8LaEDMXc7QB" +
       "Rec2TRRbnRpsh35n0y9q2qBnU1TohAN7PmItRPOLrMmjPWxfZx2lZ8LGWAQJ" +
       "Na4NAjNN95oK1znaR60swFczvFNfcZ0FPpOQZTHN117PmDGiNVHXQ2Fp042+" +
       "VIRzYzBIEHW/oE1i3FTEBTGuT3x17WX1rJ8u60136lqBMB7RK3XuU0PB3CxC" +
       "ed+RaNzCkoDDYZP0wqkFK1h/VhQrM9vgxbqJawRmJURQY8ddqrcTl3yStSYZ" +
       "b8MdY29Q2NpRN0wnwuedlatJs2E0XLRCWlmuFm10JCyaCbLC8KWJwJ0Y10KU" +
       "soMGSeKKje3QMRnUBXnS2sctA9GMyEFcvReF9cLmRYUmhTam7AWs39mKuzWz" +
       "3dd2nd14PFtLyJqKZobC0fDWcSjS8+YbMd7kkb9EWsES1zByVhMCTZ8G+6Wv" +
       "pD1s2RI1fLJsr8xOXMeKkdLdo6wnp57ZM+a1YrxH8xkd8x1l3IFTU1oV6KY1" +
       "7Da7rdZizipiCy3YVc2nZlzuKktuJGF8Q+dhVFvnCFpbFp6y2ndIZ2Aj3bWZ" +
       "7tQVrKyW8mSHNeeebaVTPcJbAjfpEX3MqFuTelyMYjNT2CkjCaK3kxS51940" +
       "+d5CpORRc1RvZmlzwWTL+sLo1kkidzUOXxjWuK3qqj+bKTXFlDITWc07fTRz" +
       "lYkwckdR02XaribwDroj7SaxIK08r0UbmNj2haBYCvyAAn7a2hnTWn004EYD" +
       "xBwl3KDeXdQaK06euFZTHnNODc27bTaT91lXXOUzR28o8FYme2hza0/WqKva" +
       "8Hw74RDVbCP16aDoCA2D3YxYaoB0loIfthq8ZmZ5z4ARpSAEVmBG8spthqg1" +
       "2hq8SdtoumUHLbS9WfIdjEpnOoLAeQNnGoY2G0dk1poWRHeJTLrA6SihTe1U" +
       "tK21O6aS1OrLBVj3uUiMhX4deCOC41k91edsg0ctPxqPugy5bCIgqi09wppL" +
       "PBl7Dctj7NmOX8L1ptbddmeMh++WtBPtmAU1WfYJXPMbCcbMujWlM7NhottP" +
       "Nyyzbw+thrGah/TI12Z1JZZH475LRING1x5Ls67m1/e7PKsLm4XTTzBJ4Br7" +
       "1n682GEkkTY6PozO4CLgfQtZ7epuKxOWu+W4s9HZGiP0vJbIxGwqcQKyVomo" +
       "L4JMI1zrPVEaMqFqWFQ7UASjGLayNewSnBKuaIbY9OOG0abrfZ7dE3NS3SJD" +
       "t03v94LuohNnXcw9TN6vLW3Cdou+RjZTYbYaupvWyC4CxwwKTs7yOblNly1z" +
       "7i83Ipw2zYE1GMcR2tUMYqwjRHdj5h4cC2Y+FFnS2Qk6z42nUR1uTyKPaq3N" +
       "rTMYuC0e3nS4HgH7TKGE+3bcINvGSp73tsIuwQMbQfyOsPDC2YBBuZrb5mQ9" +
       "wLkidcmYW/R4Fm4ik4WWt1fYmGrpvD7Zj6eIo+byaNidrOcpk7Qafr6D+WmL" +
       "LQx0kC6m4Y6xEnuAUcVyr+YqPF9PB1lOr9IWv5Bny4BrzNEG298kVqihK53B" +
       "k4GSd+bdBobOpojGmFy0hoU2bNAzeSg301BP4UUb4ZdqPR/PeszOYiVuAtuO" +
       "iiZhXTYng1q/STV3wBrW4SajMyRkjLFRtycjW0jGU2k/ywuLkugtzWD8nk0b" +
       "yVK15rDcWZgbDO/sNTrBcjQwEkISkhVFupuN1IP38laLWh7ebqrNRduVdtYG" +
       "c5gtFyaYHsw6O1NQ0wQEmY1AN5i8jvmdsD7V5qsRtfEUF2/3YrzW6I1gJw0G" +
       "MEqmpmngXR4xONLPWb+frPE4R6Kavum0CpCK7/surGmEXN9yg/ZOyzbEQseX" +
       "mWb6aU3v+jymFGrbW1NYXWu26+6kMdiy+LY5JcEWNeVjF2sMmN68RzVjwhkU" +
       "rGpotDjnM59CGnNs7q3CPa214mDUqLvrmjGJUF/SqHbYGcbRaMtpPbgT1cQh" +
       "NWua/p7VGpS4ZSRvNMdbfM1ZteG1vGksehw8CaRi5w0Iou0Ph2Gr3w6o/YpO" +
       "56s9CQvjLAj0YioJcsFr0iAx+43Mtf10z66aet/pNUQ53cl8YHan9Exzc3JD" +
       "TMDObIxSBp2tQMQ06zUHBuKJgwE8nMnqdL+k66zgTpoO6npu4UxJfFFMdZp1" +
       "SHjX5XWi2NMDw+babWfZHsw5nVvalMl304QQ117K1Oh9a95T4qzGkfWtzgqT" +
       "ncY7SHe12BaRt9aWRl4v+kvgmCnFkGoTw/ZK0kBxJ9m0sy45ymfrxdSiED8l" +
       "2UySyaBj5LA43+iSZbhBTo4m+BZFuyHZiNKo0bKpZcPD/fa+7rf7sGH15TbG" +
       "2UpiUIjXn8NpZuVC6kiUFDWyIqM0hXHQYDnKm3VT4BB/MXKmLsX5/HyRtcgO" +
       "XhNRtt1rWIZDoAiRtWqoiYlObTvvSSlLifhQxUlRqI/TluVNVmI91PsNhVh7" +
       "EzKZYt211yVcrDN0I8aF5Tlr2sWs8Oex74SUtYfpdoaw/oQ0+yYs9zR/wCRq" +
       "msITTsnrojWfKu5KiQWxUetPptRsxuNzpbN0may3xSJ+F41ng0Ydxdsu5cUL" +
       "eqlhCDYak7hKxoQXgcSclAoj4ig9MzAWQW0JibcDECgznp7bCqHwnjwoxsU0" +
       "lp1omm5gzeHzfm4gaaLCYyxvNmQHyWQv2nnTjNo5Yq/tZHi0rrk6VnQKE+Tz" +
       "tYkqiKi9VxvAjnOQoqy1YNOwiXA+2ksLfW1rw/6uEacas53YYmp3xiJw0i7W" +
       "WNp5j+uMDH+HexQwe2kJ/ANYyIZQBnxItGorpzPbsMkWl5weye12Bp6HfIaT" +
       "M5gNd3RzbM0SXtj5C7XRweDeYlxryQjGtvpLhGqkE6TrM+g+mbKDXbdb/l1/" +
       "6a2dmDxWHQ6dlgA3bqscYN7CScFh6Nmyef70ELr6XLtcNjp/CH12ygiVpx9P" +
       "3q2yV518fPGTr76mj79Uu3p8Oqsk0MNJEP4518gM9xypsor9wt1PebiqsHl2" +
       "avirn/yvT8x+2Hr5LdRPnr7E52WSf597/Wv0B7Wfugrdd3qGeFvJ9SLSixdP" +
       "Dq9HRpJG/uzC+eGTp5otyxfQU+DBjzWL37mGcUcruFJZwWHtLx1+v+lheqlN" +
       "dZccrTH9iI7U0Dqtflf00nscpu/LJkygB5JAlOiTKZ6/x3l9z4i1yA5P6t+V" +
       "EW7f7Ljq/LRVh3eqtaoG8gJ4PnqstY++Ba1dPfWdwZ9GdYeCX6mqc9XACvHH" +
       "76Gjv1o2H7+so3vVNA6E76SpT7wNTVX29UPgeflYUy+/FU0l0INhZGdqYry5" +
       "uiLo+bu7alX7OZyvvvZ3nvv6x1577g+rUshDdiypUTda3+E2wDmc77z+jW/9" +
       "1juf/HJVYrx/pcYHX7p8jeL2WxIXLj9U7D9yqponSk08fayeEzVBCbR4m+Vq" +
       "gOaVdbAg6oK3KgKdVMK/X6QPqz4/F9vlsmzgBmpyR7OuToL/Vn4Fqmzgb/8p" +
       "/SSBrrmGv06sO812H9B9+fozYX465dUDnRPrf9dZnYB0A98oy4oXvcwOjk5v" +
       "2YDB/I7Mewfmq8nObVZ3ss3zHvkP7jH2j8rmy0BlWsnXQYx7gP+T/PD9+XvA" +
       "/HLZfDaBHtXV2DqYchkJqu34zLX/xttw7cp+nwNPeGy/4VsNgq+WDX0vry5/" +
       "fqkC+Bf3kPVflc1XwSa+CWz/TmL+ytsVswz4HzsW82PfTzG/fg8x/13ZfC2B" +
       "3lHezlHDOwn6b9+KoDmwjouXTMqK+ftuu7p2uG6lffm1Gw+997X57x6C4MmV" +
       "qIdZ6CEzdd3zxcpz79fCyDDtiv2HD6XLsPr63QR67102o7LyWL1UDP/OAf73" +
       "EujmZXjgL9X3ebjfT6DrZ3CA1OHlPMg3QbAAIOXrH4Yn/v/hu+2M3VWcRKqW" +
       "AEWB/CQzIhDh8ysX881T9T/+Zuo/l6I+d2G3qq4VniSB6eFi4UvaV15j+B/7" +
       "bvNLhysimqsWRUnlIbCxHG6rnCaSz96V2gmta4MPfe/RX3z4+ZOk99EDw2fG" +
       "e463p+98H6PvhUl1g6L45ff+44/83df+oCqw/n9q6Fnr7ykAAA==");
}
