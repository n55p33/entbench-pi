package org.apache.batik.gvt.filter;
public class GraphicsNodeRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.gvt.filter.GraphicsNodeRable, org.apache.batik.ext.awt.image.renderable.PaintRable {
    private java.awt.geom.AffineTransform cachedGn2dev = null;
    private java.awt.geom.AffineTransform cachedUsr2dev = null;
    private org.apache.batik.ext.awt.image.rendered.CachableRed cachedRed =
      null;
    private java.awt.geom.Rectangle2D cachedBounds = null;
    private boolean usePrimitivePaint = true;
    public boolean getUsePrimitivePaint() { return usePrimitivePaint; }
    public void setUsePrimitivePaint(boolean usePrimitivePaint) { this.usePrimitivePaint =
                                                                    usePrimitivePaint;
    }
    private org.apache.batik.gvt.GraphicsNode node;
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode() {
        return node;
    }
    public void setGraphicsNode(org.apache.batik.gvt.GraphicsNode node) {
        if (node ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          node =
          node;
    }
    public void clearCache() { cachedRed = null;
                               cachedUsr2dev = null;
                               cachedGn2dev = null;
                               cachedBounds = null; }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node) {
        super(
          );
        if (node ==
              null)
            throw new java.lang.IllegalArgumentException(
              );
        this.
          node =
          node;
        this.
          usePrimitivePaint =
          true;
    }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node,
                                 java.util.Map props) { super(
                                                          (org.apache.batik.ext.awt.image.renderable.Filter)
                                                            null,
                                                          props);
                                                        if (node ==
                                                              null)
                                                            throw new java.lang.IllegalArgumentException(
                                                              );
                                                        this.
                                                          node =
                                                          node;
                                                        this.
                                                          usePrimitivePaint =
                                                          true;
    }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node,
                                 boolean usePrimitivePaint) {
        super(
          );
        if (node ==
              null)
            throw new java.lang.IllegalArgumentException(
              );
        this.
          node =
          node;
        this.
          usePrimitivePaint =
          usePrimitivePaint;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        if (usePrimitivePaint) {
            java.awt.geom.Rectangle2D primitiveBounds =
              node.
              getPrimitiveBounds(
                );
            if (primitiveBounds ==
                  null)
                return new java.awt.geom.Rectangle2D.Double(
                  0,
                  0,
                  0,
                  0);
            return (java.awt.geom.Rectangle2D)
                     primitiveBounds.
                     clone(
                       );
        }
        java.awt.geom.Rectangle2D bounds =
          node.
          getBounds(
            );
        if (bounds ==
              null) {
            return new java.awt.geom.Rectangle2D.Double(
              0,
              0,
              0,
              0);
        }
        java.awt.geom.AffineTransform at =
          node.
          getTransform(
            );
        if (at !=
              null) {
            bounds =
              at.
                createTransformedShape(
                  bounds).
                getBounds2D(
                  );
        }
        return bounds;
    }
    public boolean isDynamic() { return false;
    }
    public boolean paintRable(java.awt.Graphics2D g2d) {
        java.awt.Composite c =
          g2d.
          getComposite(
            );
        if (!org.apache.batik.ext.awt.image.SVGComposite.
               OVER.
              equals(
                c))
            return false;
        java.awt.color.ColorSpace g2dCS =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          getDestinationColorSpace(
            g2d);
        if (g2dCS ==
              null ||
              g2dCS !=
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_sRGB)) {
            return false;
        }
        org.apache.batik.gvt.GraphicsNode gn =
          getGraphicsNode(
            );
        if (getUsePrimitivePaint(
              )) {
            gn.
              primitivePaint(
                g2d);
        }
        else {
            gn.
              paint(
                g2d);
        }
        return true;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext renderContext) {
        java.awt.geom.AffineTransform usr2dev =
          renderContext.
          getTransform(
            );
        java.awt.geom.AffineTransform gn2dev;
        if (usr2dev ==
              null) {
            usr2dev =
              new java.awt.geom.AffineTransform(
                );
            gn2dev =
              usr2dev;
        }
        else {
            gn2dev =
              (java.awt.geom.AffineTransform)
                usr2dev.
                clone(
                  );
        }
        java.awt.geom.AffineTransform gn2usr =
          node.
          getTransform(
            );
        if (gn2usr !=
              null) {
            gn2dev.
              concatenate(
                gn2usr);
        }
        java.awt.geom.Rectangle2D bounds2D =
          getBounds2D(
            );
        if (cachedBounds !=
              null &&
              cachedGn2dev !=
              null &&
              cachedBounds.
              equals(
                bounds2D) &&
              gn2dev.
              getScaleX(
                ) ==
              cachedGn2dev.
              getScaleX(
                ) &&
              gn2dev.
              getScaleY(
                ) ==
              cachedGn2dev.
              getScaleY(
                ) &&
              gn2dev.
              getShearX(
                ) ==
              cachedGn2dev.
              getShearX(
                ) &&
              gn2dev.
              getShearY(
                ) ==
              cachedGn2dev.
              getShearY(
                )) {
            double deltaX =
              usr2dev.
              getTranslateX(
                ) -
              cachedUsr2dev.
              getTranslateX(
                );
            double deltaY =
              usr2dev.
              getTranslateY(
                ) -
              cachedUsr2dev.
              getTranslateY(
                );
            if (deltaX ==
                  0 &&
                  deltaY ==
                  0)
                return cachedRed;
            if (deltaX ==
                  (int)
                    deltaX &&
                  deltaY ==
                  (int)
                    deltaY) {
                return new org.apache.batik.ext.awt.image.rendered.TranslateRed(
                  cachedRed,
                  (int)
                    java.lang.Math.
                    round(
                      cachedRed.
                        getMinX(
                          ) +
                        deltaX),
                  (int)
                    java.lang.Math.
                    round(
                      cachedRed.
                        getMinY(
                          ) +
                        deltaY));
            }
        }
        if (false) {
            java.lang.System.
              out.
              println(
                "Not using Cached Red: " +
                usr2dev);
            java.lang.System.
              out.
              println(
                "Old:                  " +
                cachedUsr2dev);
        }
        if (bounds2D.
              getWidth(
                ) >
              0 &&
              bounds2D.
              getHeight(
                ) >
              0) {
            cachedUsr2dev =
              (java.awt.geom.AffineTransform)
                usr2dev.
                clone(
                  );
            cachedGn2dev =
              gn2dev;
            cachedBounds =
              bounds2D;
            cachedRed =
              new org.apache.batik.gvt.filter.GraphicsNodeRed8Bit(
                node,
                usr2dev,
                usePrimitivePaint,
                renderContext.
                  getRenderingHints(
                    ));
            return cachedRed;
        }
        cachedUsr2dev =
          null;
        cachedGn2dev =
          null;
        cachedBounds =
          null;
        cachedRed =
          null;
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "v0Ipflvj3t+Tr3js4VDnc/fgHf0vcJeV0SgpAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e+zr1n2f7vXz+nWv7Th2XNuxnesmsZIfSZGSqNy0CSXq" +
       "QYmiKFGiJG6Jw6dIiu+32DlJU2wJlsENWqdNi8bYHym2FW4TDCu2Iejgbegj" +
       "azAgRdF1BdZkL7RdGqBG0C5b1mWH1O91f/cR39mbgHNEnef3832d7+E5evU7" +
       "lTvCoFL1XGu3sdzoQM2iA9OqH0Q7Tw0PhnSdFYNQVTqWGIZzUPaC/OxXLv7V" +
       "9z+nXzpfuVOoPCw6jhuJkeE64UwNXStRFbpy8aS0a6l2GFUu0aaYiFAcGRZE" +
       "G2F0ha7ce6prVLlMH5EAARIgQAJUkgARJ61Ap/tVJ7Y7RQ/RiUK/8vHKObpy" +
       "pycX5EWVZ64exBMD0T4chi0RgBHuLn7zAFTZOQsqTx9j32O+BvDnq9DLP//R" +
       "S//4tspFoXLRcLiCHBkQEYFJhMp9tmpLahASiqIqQuVBR1UVTg0M0TLykm6h" +
       "8lBobBwxigP1mElFYeypQTnnCefukwtsQSxHbnAMTzNUSzn6dYdmiRuA9e0n" +
       "WPcIe0U5AHiPAQgLNFFWj7rcvjUcJaq882yPY4yXR6AB6HqXrUa6ezzV7Y4I" +
       "CioP7WVnic4G4qLAcDag6R1uDGaJKo/fcNCC154ob8WN+kJUeexsO3ZfBVpd" +
       "KBlRdIkqj5xtVo4EpPT4GSmdks93mA++9BPOwDlf0qyoslXQfzfo9NSZTjNV" +
       "UwPVkdV9x/uep39OfPtvfOZ8pQIaP3Km8b7NP/1br3/4fU+99jv7Nj9ynTYT" +
       "yVTl6AX5S9ID33ii897WbQUZd3tuaBTCvwp5qf7sYc2VzAOW9/bjEYvKg6PK" +
       "12a/tf7kr6jfPl+5h6rcKbtWbAM9elB2bc+w1KCvOmogRqpCVS6ojtIp66nK" +
       "XeCZNhx1XzrRtFCNqMrtVll0p1v+BizSwBAFi+4Cz4ajuUfPnhjp5XPmVSqV" +
       "u0CqvA8kpLL/QEUWVRRId20VEmXRMRwXYgO3wB9CqhNJgLc6JAGt30KhGwdA" +
       "BSE32EAi0ANdPazYJBEEKADaA/UD0dMNOWRcRZ2JkqXibQO4H6Bt3v+nebIC" +
       "76X03DkgiifOOgIL2NDAtRQ1eEF+OW53X/+1F373/LFhHHIqqiBg6oP91Afl" +
       "1Adg6oP91AfXnbpy7lw549sKEvaCB2LbAgcAXON97+U+MvzYZ569DWicl94O" +
       "eH4baArd2EN3TlwGVTpGGeht5bUvpD/JfwI+Xzl/tastyAZF9xTd2cJBHjvC" +
       "y2dN7HrjXvz0n/7Vl3/uRffE2K7y3Yc+4NqehQ0/e5bBgSurCvCKJ8M//7T4" +
       "6y/8xouXz1duB44BOMNIBMoL/MxTZ+e4ypavHPnFAssdALDmBrZoFVVHzuye" +
       "SA/c9KSklPwD5fODgMf3Fsr9NEjBobaX30Xtw16Rv22vKYXQzqAo/e6Pcd4X" +
       "//Df/hlasvvIRV88tehxanTllFsoBrtYOoAHT3RgHqgqaPcfvsD+7Oe/8+m/" +
       "USoAaPGu6014ucg7wB0AEQI2/+3f8f/9N//4S79//lhpzkVgXYwly5CzY5BF" +
       "eeWem4AEs/3oCT3ArVjA5AqtubxwbFcxNKNQ4UJL/9fF55Bf//OXLu31wAIl" +
       "R2r0vh8+wEn5O9qVT/7uR//7U+Uw5+RiWTvh2Umzva98+GRkIgjEXUFH9pO/" +
       "9+Qv/Lb4ReB1gacLjVwtnde5PQ9K5I+AwOC6JnraNkvxQmX758v8oGBNOUql" +
       "rEOL7J3haTO52hJPBSovyJ/7/b+4n/+Lf/F6ievqSOe0VoxF78peEYvs6QwM" +
       "/+hZnzAQQx20w15j/uYl67XvgxEFMKIMfF44CYBvyq7SocPWd9z1R//yX7/9" +
       "Y9+4rXK+V7nHckWlJ5bmWLkA7EANdeDWMu9DH96rQXo3yC6VUCvXgC8LHr/W" +
       "UD5+qEMfv76hFPkzRfbctep3o65n2H++pOB88RMGnHnmBoyfiWkZDbwg//Pp" +
       "t77xxfzLr+6VUhLBclep3iiwvDa2LXzUczfxsychx1/2P/Dan/1n/iPnD5Xj" +
       "3mOMzxSQLoP0iUOMnzjLniOdvP9EaEBgRWGvHOvDN1FCqsiulFVYkX1wP1rz" +
       "TQnypUNKX7p1Qd6o680F+d6b7DYCwwYOMjmM0KAXH/rm9pf+9Ff30dfZcO5M" +
       "Y/UzL//dHxy89PL5UzHvu64JO0/32ce9Jc779+B+AD7nQPrfRSpAFQX7uOeh" +
       "zmHw9fRx9OV52VV6eR2yyil6f/LlF7/6D1/89B7GQ1eHfF2wo/nVP/jrrx98" +
       "4Vtfu050cZfkupYqOiWVs5voxkeLbHyiG8yt6Ma+7WPlrws3F1Gv2I2crNiP" +
       "/c+JJX3qP33vGk9XBhrXkdqZ/gL06i893vnxb5f9T1b8ovdT2bVBGdi5nfSt" +
       "/Yr9l+efvfM3z1fuEiqX5MNtIS9acbGOCmArFB7tFcHW8ar6q7c1+xj+ynFE" +
       "88RZtTk17dlY40Rc4LloXTzfcya8uK/gcg0k9NBi0LPGdq5SPuh7eyvzy0X2" +
       "7qPV/C4vMBKgdeXIywhsFYvlTOk7NUVNjpzKk6VTEdPoYKO69gGhaYCZ80B0" +
       "wiIiOjHoUkOMH6Yh8rX0Y4f0YzegP7gB/cWjdUT6/XvSF2FQ0F4UOmdIC/8v" +
       "SKsfkla/AWm7N0LahT1pM1U5Yil6TexQmETBYsMGG9gDEISCVVhVDjqgSRHd" +
       "gL5n0OS3iAYGqXGIpnEDNJ96I2gOdaTtxo4SHgF6x9U6MgOaD2zAUmvkGbJ/" +
       "6hbJfj9IHzgk+wM3IPuzb4TsB+NQPfaiLPAHZXDJnyHv790ieU+BND0kb3oD" +
       "8n7mjZB3uwMCxnIxO0PRz/5QisoRsnPAnO+oHTQPygF+4fpz3lY8vgdE8WH5" +
       "vgn0ALYsHhPxqGnJl4+WJF4NQuBzL5tW80jKl0opF97tYP/S5gytyzdMK1gO" +
       "HjgZjHadzZXP/pfPff2n3/VN4LOHlTuSwp8CV31qRiYuXon9nVc//+S9L3/r" +
       "s+WmBDCR/+Rz3/5kMeqXboa4yL5YZK8cQX28gMqV+3xaDKNxuY9QlWO03Ck8" +
       "ayAey30TaKMHvzfAQoo4+tCIqKIEj8y2UAtb4x3CquMDbDsldG6VKCO1Y3b5" +
       "1EjgNuijDD3ClRjUmcx1qdbcVRv13XRJ85o/nViMT4tDxGLrM5rhjMkQbgTi" +
       "oqGMUnYWhQLCurIlBvO1j/B61KsZPtpKgklTgbQ4kSIsWFp2y54nE6WF5onS" +
       "qkNyK48xVavji37ue17q0yEDiww3CnrMWm8QIhPhfme93PUTq5nlBq2nycpB" +
       "DJze1ofx2PGIMeP1UrETDLlgYC7r3HC37XczbtaPQ8/kmIEOY4y/wUfz3oiX" +
       "zOFkHPmcbeyGXTtaYdl0GG+mrZntdjOH82icd+180abQRbbtzEfDtV1TKVVa" +
       "N2Ydnl4pZGJ1e6gdiOnU2+J1sW2wfDhDO267zYwX9iQzOJIRFWS8bc3rCtoK" +
       "Q9dgxrAxqU4ta+MsM0Ha2iNSd0WfpVtYbTFGmHFXmPaGfNZaZxPRN3cUhQ64" +
       "4Woew77NLcerWOguMnnj9vKuac57TZjbhH2X70lLWBl5nerW8D1hlIyQ5aA2" +
       "7yxFg6CyscE0u1t0qotTZD5VV/3l2l3Xpdhp27AjNGdINN3N8EWzvl2wqGO1" +
       "WnKV5noL1BdGizkQa6dLpcvRVCK7/lzjp+gyHmb9GLeZqRe2DNHnMCpsSr1a" +
       "HInTqr5se0uyKUnMRoB9c2JB83C2CqmqYXswZzd0B+nq2RTxIUPv5PCm0TQH" +
       "PMKQvGKyO31Nu72NuqUItLcNKVQYcd5uJvKNiUk1mFW67qw7CLMwxY3grUV3" +
       "ak6nS48xxkYH1iGlzbTnVbcPL4kF0XCzccuDF5IID7EtmBVaG5SJwAN1PV1Q" +
       "6FbfEstZKNR3mj4Ou/GclZJtzYNQBGkhGCFYwYyyKYGoz7cLoT7De3N2oXrb" +
       "huiSbo/NCWFUlfrkxjEHLVgbbjgqQ21qLniaFqO4orHBPEcieJsPp82JLqUy" +
       "vxRbmNeHYFu0I7m+5t2Zbtm2R8WsJdjOOGk02307GouzoZnZMysb9ynWiT0c" +
       "90MUXUBap87uGIsyfIfyO3PD7yrL7TC0Fit4zPubeJxFCQXMpLuELKy/s3vV" +
       "urFd0Aw63Q31BSP0Z6GB+/DcSvBetyNsOnN+OmnVR9xigjTnS4KEyEbUXQxH" +
       "GEfnGO9ROY27jJt33ZTxt9t1b8ET29kaqTU6gS/BUx1LuLY0VQ1tTTYcvkfO" +
       "1S2RiobfguVeOu4S0VRqtJHtYkiQ8IzR3I253hiy0Oh0bWXqtcYBkupTmWhH" +
       "fQfy0BXnT6prlyeoyB75TEZSWJcJ+Lk1afHNbN0Pen4yZltm3dxsUiVtUgsq" +
       "jfTG2qgr1DQZrPsWVZW4rZTRW6RDBflmOZsT6CAQomE6JYwxwcu5EC2bSkuD" +
       "xzOqi0n9TbdGpzSn+9kYmXjdDrCwFuY6opGg+UA3MZXRx8awL4KhvOlU6MIx" +
       "jW5wnWtlnrrie4Pq1B0i/FhpLEb5oN8YRRQ26/iQ1R8wC389Wehosz9zAjvs" +
       "TYSJsVtoOLy1lKoc+7ErxM3EqddtisvDdBwvp7s2qWyb45HgrB3VZHbB1m5q" +
       "vuWMNSc3YB5dGVNEbIQSsyUNzYcnZE9nZDxRabkh02SyhmJJndmD1Mns1NlI" +
       "GSE2mkggUEtNMOOFu6tb7qDdQYQJ8OyTmiknwmaETSZzWA7IFa4ZObHW5w0M" +
       "5TBlHLWrK1weiC19gne7TJUeuynP9nglgeN6qzqFEjqm7ShgRpYYyrXuTAh3" +
       "MYctOYTtS/yEJpWgNx4pI0hDtD45aTUgb62YPUO361acdpVoafQ7qb4kbSmv" +
       "tRr1BYrm5m5qGiSedUh+2PQ3mOs6fJerwlZ9MxylNXs5YdvEUFhvOGMY9Olp" +
       "sFnAHtUYrNzlsLXI+QDDGXzCD0NsOxoM9GiAczC0aXVb4nRZb9QTD0JYxpsa" +
       "Q3sdKjbpbQU0lLFxUwMLMCHVF6YG9XKFrONc0+W7hDwQtqwwHdgt0tvUsLo+" +
       "0a1wK/FKrut9KOlu69Bkia/cmoPRFMfSMmNbca+2rWWswvDLRB1GNJqta9pK" +
       "X1fV+ipyevYs5JtreikR1MzGE27Mwl0p06VRtiGntIYhrB8h2sgz8rbJ4Kk7" +
       "BRMzYDGaR8B46ZFrwJEGqaiJNVVtxNE6Is5k3l1hottvUtl2qG07DLE2u2Bh" +
       "FxtwuiaHfHuBI/xw7ozq6HzDb3M6we1gqwdmrUk7fMZUZWU1S2utlO17uBF4" +
       "8qqZzDZxn6muYKbWctb5OOqF7WogpBq5mqxTyEpHa+C9NrMq2WgICwfvNnSu" +
       "p0IQN1rWlJVZa8mKP2jTXcjHW51Gx1+QQxRS0HmtuTS5YR8aMk4P3gzmkTgM" +
       "GkuNpZRtrccNNuJcinZZY6A2V1GQ0QRuCYKuhW0c8Qczi8R1MjD1pTMfTEV6" +
       "NiD5zKGnE4WZxkygtUxi2g4XLEJznL5267E1pFCzMWWQkPDHa6GmVWF+mTtr" +
       "QITcrAtrNkjyISIKggBtMA9mod1YzIVqU5GrI6wvmdOEysd4Hib1WZMbUxDT" +
       "Cc0euSWqy4DFETpKlBpML9PeliHXElhAKd+Z4h025SfNKjcVYSXhSEEYs11n" +
       "4FhKw6vKSBTBS4/a2rUtPeKpGBnBtNqIvQkJr8V5Y0XrmblZ4mlaE+fVbtJm" +
       "FAjvjtI1JQ/tyFv6MKc6vj1juBqDIW0kX/MSu21JU2YumyEyYoOpbCNLG7IU" +
       "KA8NciDWqpjKEW1tS+prec62pI08pNlGHsEE2Z+3/VpLjIM1HdeT5sAczLbd" +
       "JmOFM3gw7gw22TbPBsoSSuzcSSbskux5QuqP3HjdNFtYo6HOiFRhtGE8QIRt" +
       "vQ4vUBO1NgzXn22X9T7c8eU1xGvzOG2pyzyhRWERKdYgQPjRKHEIA2pVGYde" +
       "1RSm7ic5x1pL3hfbWHeNQyqcLZpTnUBmRA3p9njMjQhrvk31lbrECBAqVcm0" +
       "jrQnziqAcETDcdVEybQm7DZKCHxMggV4bTdAm2jiOXMLJXYQhcfVRG9imJrU" +
       "lF0jXyXyquGwWynOnHnsT5NJn6gnMIQOTZxihotql1tuUX8mRvW8rmy8vOMH" +
       "E8nqxn1oTrgzw8+zYKIt68agNRHG0BziOztoFUbNEdqumbOgE6qT6QLLlhgN" +
       "Iykt0bLsAScFT7rAyZFKP1DzkLc3PNq0bL/BEJv2DmFxc+OvrWF31J0znEah" +
       "XG+kkorfiTGsJ/b7o5nmuza1qw3bPR0P0+YmW0z6XcTFukGxgs/jnOd3Ibdi" +
       "1zpukbkxa7Tiei0BQRa2zgDvjcZoM1Gipr/VhKYDs+JQERocutsmHDNdmq24" +
       "bZMgEJS4uI9is7nVm6DuSnK5RY/1vHbfDUaDlscy1Gg4MEKi12A3rjzi2fYu" +
       "HgoiZTSRhdZOXWpYRdtWGvDtORftUkXYLUixPsE7SToebmuBNnNxf9xh+C2B" +
       "oEPaihdVW08ZZMyxdr0vWt1uXhUJktAJqIpvVWON86NBt7VqxxEz1xocm23c" +
       "8awKpGqQ/sxxgkVr6mFUlxwpQY3eaLtVV3XbDgQpS7K/XnYUsMaOOhsdcWtI" +
       "lWb1AbQ12DaDjXdroBP4IIZ2yQDZoviAxKcoSkvToKsjuNlwRMLbThbR1oKA" +
       "deEgpEgHUnXKRMPRqMomCRrNsqDJZ/OdSeTNhgFlPSKD5hgTMpEMBSuvpy4D" +
       "bbVTksQWNmraZ+OGUA8mnIL7WpTB1SRe7HBW3mmoFwt0rHpaLsxlVKiOWrLH" +
       "Va2REi1a43RijdeGXFt1kGWv7eMirRJipKFqMOhbBO4A4aqpKKF5dxd51R29" +
       "shV00FeGzUa6SOoLpbiUwucBTaPL3hLjWERka35jtKiKeaLrG6uuZpMpUxtr" +
       "9FpfsenUBoGdKscdErBXn6ESu5LHjO67m5pGbxM9CIdRXZbFNeVCbWynpFWB" +
       "NXvTtsZkurlQ1CzzEnKm7EKyKQi+DQerdlClBw2qJnsOMJNNd1tNYylZt0EU" +
       "vuOSiSHV17Q+HuvLmFjECXBQDBZqfoD2qTaVZ1uI6c1CrzdhUW9JK3VSGwzH" +
       "bd0gXAxJB0vUk1FFnyUdM+eJmuwTIeeFO30jtIW6AYJrO9M00+zwHQrT2l2b" +
       "CcFGEEZIS4g7K3xJTGBnlqaMvpRkvkNyY2mECgQ+nPU9h0znfbNYxwyy0eSs" +
       "fOJ0mio5sM2WWOuuFLubtyVYJT1vJZPBmJTIKWunQtrfIfM6ao+ZwXhtktNh" +
       "1sS6SMrTcBr3+rjNMopOhTnT3/kWPIHsqCXBFIM3ObBhzWq7XbfRSXy+Ty6E" +
       "objQnFj3hUZv4sOmMEuqsp9LLWqBr2rD7YrBVjV2UxWW9ETJWTvKmsYGU4Od" +
       "sZZRsAUImt0crTGLKb2UubG9q9b6o0az3oVrVgeLovl6XhdhaVPnTWo3VAk3" +
       "TUgQUGXt3mIUDUNc9AfBDp+3ufaoJsk6bCJ8fTRzg7qWK8okJQV3zfTyWYhy" +
       "U21MGjMsRvo5U41HOYqpYrzNbQIbdBOG6g1GiujnLUyybBREB4zMGtrGpg1o" +
       "xLpqlk8bAakGfIolnUZrrsor1Neqs+HaohYtFe0sF/MeJwYNNvfSlpCYEyFs" +
       "8aEjTTKly5pCZjmtoT+nuopZT4yRORTTlQzrTA+sXRHn5oPcTTieQuRWK0la" +
       "Q7kKBjMGOsFRM7JWN6E5t9y4E21ey1BansjdphnUGlK9tWtV60HdmLZUrAbV" +
       "DNZern0X0kQIS6NelLfwKr7QWzaV+RTOp8SI9yA/nbkO7PSmGiJZlNcXE47q" +
       "0GNqY+0QI2bgtY4RfG1Zwxc7oba0ezmur0dTvQVZtaYrr+oS1ZgNlqo06Iuc" +
       "uXEmJlrrz+dBdShxDFEl4RpwPJKk1PoZg9UwQhpEZlPw7ASmPM1KTDSqzgPU" +
       "DDGedGRI2ww0OJGHKg9zG48giB8rXgF95dZeTT1YvoU7vkdlWs2i4u/fwtun" +
       "7HoHbOXnzsrhnZuj71PvK08d15w/euP3/lu6h3LUC3tDr7eLHgflm9iyc3Hs" +
       "9eSNbmSVR15f+tTLryiTX0aOTkiFqHIhcr33W2qiWmcOm56/8WHTuLyQdnLi" +
       "89uf+m+Pz39c/9gtXGt55xk6zw75j8avfq3/o/LPnK/cdnz+c81Vuas7Xbn6" +
       "1OeeQI3iwJlfdfbz5LEwHy5k926QiENh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("EmdfPp+oy/XfPL9nr243Ofz7Nzep+3qR/WZUedtGjRbXfbF+oqm/dcsHyv/q" +
       "6gPlD4E0PMQ5fGtwnjtpwJcN/uAmYP+wyL4BwIbXAXvdt8WJaygnDPi9N8GA" +
       "x44EzR8ygH/rBf1fb1L3J0X2rahyEQj6tL2XRxUnEP/jm5Vxcdj2kUOIH3nL" +
       "ZQyXDV6/Cc7vFtmfA5zhtTj/6ATnd94szidA0g9x6m+9KP/6JnU/KLLvRZV7" +
       "ZEsVg+Jk8Sy6//Em0D1aFD4L0i8eovvFtxzduQs3qbu3yG6PKvcCRd2fTe7P" +
       "Hj99DO/cHW8C3sNHwvvqIbyvvvXwHrlJ3aNFdgkseEZI7sA6YZSHSyde9tyD" +
       "bxbckyB97RDc195SCzwKCx4+PiQ+srAaWYJ75ibAnyuyJ4DWeseRwhnkT74J" +
       "5O8oCt8D0ncPkX/3/wnydx8jvyYAmpWPhzf/S8Q3uTF4Di2y54GbkgNVjNR9" +
       "Z8PZHE30xJmJZocXCaji1wnLqrd0jyeqPHLdK8fF/cnHrvmnw/52vvxrr1y8" +
       "+9FXFv+uvHV7fIP+Al25W4st6/T9llPPd3qBqhklRy/sb7t4JewPRpUfuUkk" +
       "GhX/ZygeCtrPXdn3+RBYsK/XJ6rcBvLTLdtR5dLZllHljvL7dLsu0MKTdmDS" +
       "/cPpJgMwOmhSPFLekVCabzwcJqQwCkT5MCI+dyqoPVTd0k8/9MPEd9zl9E3f" +
       "YtLy7ytHQWvMHt5x/PIrQ+YnXm/88v6msWyJeV6McjdduWt/6fk48H3mhqMd" +
       "jXXn4L3ff+ArF547CtIf2BN8YkanaHvn9a/1dm0vKi/i5v/s0X/ywX/wyh+X" +
       "h/3/B4sJTh5XNAAA");
}
