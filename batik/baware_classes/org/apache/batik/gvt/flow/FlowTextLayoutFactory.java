package org.apache.batik.gvt.flow;
public class FlowTextLayoutFactory implements org.apache.batik.gvt.text.TextLayoutFactory {
    public org.apache.batik.gvt.text.TextSpanLayout createTextLayout(java.text.AttributedCharacterIterator aci,
                                                                     int[] charMap,
                                                                     java.awt.geom.Point2D offset,
                                                                     java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.flow.FlowGlyphLayout(
          aci,
          charMap,
          offset,
          frc);
    }
    public FlowTextLayoutFactory() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cYmlpc7XuM294FI2dtJhBU9b+nh7Lu8s9imfxlmuNQPseS5By4tWB9o2hgoq" +
       "A3X2gqmaHNagTT42PpEYeGYlb0WavI1DD/TFz/70n2+Ejv7itSJ1agbR9NsV" +
       "PIwVj54g0lNd+ln/5yDc+3WHf/29jtSGj1JY6FzrLUoH/b8QjFg2daHwq/LK" +
       "Y39o2bY2vfsj1IiFPnf6l/xm/6nX7lsqHQ6yZpeXh4Im2cvU5XYsCDUwdPUq" +
       "NZPO1LId1p5PmhaaI8vgK1hJI/h3GAdzloF06MmzstysmobVByClLKKlduYt" +
       "YRuCZVr+uJjoToN7JGjb+whmaO094dLADmbjJmFAxtvfB6vPv2R+/bfP85xr" +
       "K0Ls66lPHK+U3suc/w1nmFeEgdM1nxC+uP2dPW+wcFbS/Mk70ZU7kGeuAtiQ" +
       "904ddUajjWH2L0E7/suukZ4axREipLCWgRMKSUODkyJpuyn9Xy5P9/+SqbeD" +
       "KyYT32h/8+GJ9l8y6K2UTdhg4KciZyQXz/VTl69eqF1wmm3kUupuy9Xew2Xh" +
       "2dFzJGRRqKdDLGcWT4eIIWegsxi20mFVZLd0oCPC0oHy7aRDiDJ3TnPJ4F1D" +
       "2Nd0eejpK8/ylPKf6XzE+MD45z8MHRznGMgPvu0FZ083Dz/88gTLa7d4OimM" +
       "o/d3Z/Z9/8S+/bZl9xNUIlt3EnRDBvIQO8vrJq7nxifqf3CoqaQXAtKHKrOq" +
       "vDeL+xJedKkws3HXrnDOyQ7WWBrTFoqgwDK7tnkVmO/BeHY95YDgybfv/snx" +
       "Lx0Z4d6dJio+vrl/H1Dij/3qbwV9B8PjIoHy8UeFU0+3dK+9yvid5plyd+QK" +
       "D2SQ5A7vqpOZvwTbyn8URBVR1CBZ10HbRSVL+9YopLFp3xGFUa3nvfc6g5/d" +
       "u/LoP9+fKS6x/rbdHalS4olKI98iAcSgerR4hxFkHQaBRWVVVBhfCHplhUEC" +
       "/beHDglXRIOcz8Z43npSO6BR0FRMu1j7HT9fyloofxMFLwtzg/4f4MoyYa5K" +
       "xPSZpkvdP827J+jwOJgmUb24GdOQf6Gwp6MTG3RX+xdwujLLI2BlM7MSEDVE" +
       "ETUU0WADrtpov12Yf5uE7Ar1wrAVq9CiWld3TPanptFrnA6DBDLMwHAWcVo2" +
       "W8LHpu/vBnVRdTF8gg7buPJr/sNe1/ILmF70eoH2wnML7jP5HZx0eqK+cs7E" +
       "A+/wGmDfk9VA+U1mFcWdza7nct3ASZm5o4bnts5+JgiaN+XdB0Gl9Iepf4zT" +
       "fw1yshg9oCaMbspJcLifElKJ/brpjhNU5dDBzuEPbpKTsDqQ0Mdv6XbQGpxt" +
       "w7d/LlB4HmCxar5VrPIs7sMxjT67ebYxP8vvnmPSmYnNWx66cdcz/HAuKeLY" +
       "GF2lGpCeXwHkO9fFU65mr1W+qfNm3XMzltjlx3M54NaNZQzsHHaQbvGdVs2O" +
       "/KH13ck1Z398oPwC4PEOFBABXnYUAmVOz8KRYUe4sKIBULJjdFfnV0fXrkj+" +
       "6T121CosQH76mHTx+M63D8+dhON2dR8qg8qKcwzBN46qW7E0bERRrWz25EBF" +
       "WAWwzFMu62gai/ROmvnFcmdtfpbe2hDUVtgAFN51wbF0BBsbtKyasAputTPj" +
       "uRK3m/+srvsYnBlXw6TxGs071JJYuF/X7SuPqrt0tqX14jhHx7PskQ4v/Rsh" +
       "4pPslRoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
