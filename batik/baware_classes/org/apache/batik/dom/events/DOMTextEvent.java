package org.apache.batik.dom.events;
public class DOMTextEvent extends org.apache.batik.dom.events.DOMUIEvent implements org.w3c.dom.events.TextEvent {
    protected java.lang.String data;
    public java.lang.String getData() { return data; }
    public void initTextEvent(java.lang.String typeArg, boolean canBubbleArg,
                              boolean cancelableArg,
                              org.w3c.dom.views.AbstractView viewArg,
                              java.lang.String dataArg) { initUIEvent(typeArg,
                                                                      canBubbleArg,
                                                                      cancelableArg,
                                                                      viewArg,
                                                                      0);
                                                          data =
                                                            dataArg;
    }
    public void initTextEventNS(java.lang.String namespaceURIArg,
                                java.lang.String typeArg,
                                boolean canBubbleArg,
                                boolean cancelableArg,
                                org.w3c.dom.views.AbstractView viewArg,
                                java.lang.String dataArg) {
        initUIEventNS(
          namespaceURIArg,
          typeArg,
          canBubbleArg,
          cancelableArg,
          viewArg,
          0);
        data =
          dataArg;
    }
    public DOMTextEvent() { super(); }
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
      ("H4sIAAAAAAAAALVae8zkVnX3fvvKLkl2EyAJIe8sNGHg87wfWqCZsT2eh8f2" +
       "jGc8Y9OyePz2+DV+jyEUKC2hVEDbAKkE+SuolIZHUVErVVSpqhYQqBIV6ksq" +
       "oKpSaSkS+aO0atrSa8/32m83G2jpSL5z595zzj3n3HN+9/reefb70Gnfgwqu" +
       "Y25U0wl25STYNczabrBxZX93QNRowfNlCTEF35+CtiviQ5+/8MMXPqxd3IHO" +
       "8NDLBdt2AiHQHdufyL5jRrJEQBcOWzFTtvwAukgYQiTAYaCbMKH7wWUCetkR" +
       "1gC6ROyrAAMVYKACnKsAtw+pANMtsh1aSMYh2IG/ht4JnSCgM66YqRdAD14t" +
       "xBU8wdoTQ+cWAAk3Zb9ZYFTOnHjQAwe2b22+xuCPFOAnP/bWi184CV3goQu6" +
       "zWTqiECJAAzCQzdbsrWUPb8tSbLEQ7fZsiwxsqcLpp7mevPQ7b6u2kIQevKB" +
       "k7LG0JW9fMxDz90sZrZ5oRg43oF5ii6b0v6v04opqMDWOw5t3VrYzdqBged1" +
       "oJinCKK8z3JqpdtSAN1/nOPAxktDQABYz1pyoDkHQ52yBdAA3b6dO1OwVZgJ" +
       "PN1WAelpJwSjBNDdLyo087UriCtBla8E0F3H6ehtF6A6lzsiYwmgVx4nyyWB" +
       "Wbr72CwdmZ/vk2/84Nvtnr2T6yzJopnpfxNguu8Y00RWZE+2RXnLePPriI8K" +
       "d3zpiR0IAsSvPEa8pfn9dzz/2Ovve+4rW5pXX4eGWhqyGFwRn1ne+o17kEdb" +
       "JzM1bnIdX88m/yrL8/Cn93ouJy7IvDsOJGadu/udz03+jHvXp+Xv7UDn+9AZ" +
       "0TFDC8TRbaJjubope7hsy54QyFIfOifbEpL396GzoE7otrxtpRTFl4M+dMrM" +
       "m844+W/gIgWIyFx0FtR1W3H2664QaHk9cSEIOgseqA2e+6DtJ/8OoLfAmmPJ" +
       "sCAKtm47MO05mf0+LNvBEvhWg5cg6lew74QeCEHY8VRYAHGgyXsdkmPBcgSo" +
       "fRilRlOQQ1j2azcLMvf/V3ySWXcxPnECOP6e42lvgozpOaYke1fEJ8MO9vxn" +
       "r3xt5yAN9vwSQI+AEXe3I+7mI+6CEXe3I+4eHRE6cSIf6BXZyNvZBXOzAlkO" +
       "8O/mR5mfH7ztiYdOgrBy41PAsRkp/OIwjBziQj9HPxEEJ/TcU/G72V8o7kA7" +
       "V+Nppi1oOp+x0xkKHqDdpeN5dD25F9733R9+7qOPO4cZdRVA7yX6tZxZoj50" +
       "3K+eI8oSgL5D8a97QPjilS89fmkHOgWyHyBeIIAIBWBy3/ExrkrYy/vgl9ly" +
       "GhisOJ4lmFnXPmKdDzTPiQ9b8gm/Na/fBnzcgfaKq0I66325m5Wv2AZINmnH" +
       "rMjB9U2M+4m//vN/quTu3sfhC0dWNkYOLh/J/UzYhTzLbzuMgakny4Du756i" +
       "f+Mj33/fW/IAABQPX2/AS1mJgJwHUwjc/EtfWf/Nt7/1zDd3DoMmAItfuDR1" +
       "Mdka+SPwOQGe/86ezLisYZu3tyN74PHAAXq42civPdQN4IgJki2LoEsz23Ik" +
       "XdGFpSlnEfufF15T+uK/fPDiNiZM0LIfUq9/aQGH7a/qQO/62lv/7b5czAkx" +
       "W8cO/XdItgXHlx9KbnuesMn0SN79F/f+5peFTwCYBdDm66mcoxWU+wPKJ7CY" +
       "+6KQl/CxvnJW3O8fTYSrc+3IfuOK+OFv/uAW9gd/9Hyu7dUblqPzPhLcy9tQ" +
       "y4oHEiD+zuNZ3xN8DdBVnyN/7qL53AtAIg8kigDDfMoDoJNcFSV71KfP/u0f" +
       "/8kdb/vGSWinC503HUHqCnnCQedApMu+BvAqcX/2sW00xzeB4mJuKnSN8dsA" +
       "uSv/dQoo+OiLY003228cputd/0GZy/f8/b9f44QcZa6zzB7j5+FnP3438ubv" +
       "5fyH6Z5x35dcC8Rgb3bIW/609a87D5350x3oLA9dFPc2fqxghlkS8WCz4+/v" +
       "BsHm8Kr+qzcu21X68gGc3XMcao4MexxoDhcAUM+os/r5Y9hya+blu8Hz8B62" +
       "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" +
       "1tPfys/H/wfH+MSg9CMAAA==");
}
