package org.apache.batik.bridge;
public class GVTBuilder implements org.apache.batik.util.SVGConstants {
    public GVTBuilder() { super(); }
    public org.apache.batik.gvt.GraphicsNode build(org.apache.batik.bridge.BridgeContext ctx,
                                                   org.w3c.dom.Document document) {
        ctx.
          setDocument(
            document);
        ctx.
          initializeDocument(
            document);
        ctx.
          setGVTBuilder(
            this);
        org.apache.batik.bridge.DocumentBridge dBridge =
          ctx.
          getDocumentBridge(
            );
        org.apache.batik.gvt.RootGraphicsNode rootNode =
          null;
        try {
            rootNode =
              dBridge.
                createGraphicsNode(
                  ctx,
                  document);
            org.w3c.dom.Element svgElement =
              document.
              getDocumentElement(
                );
            org.apache.batik.gvt.GraphicsNode topNode =
              null;
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                svgElement);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.GraphicsNodeBridge)) {
                return null;
            }
            org.apache.batik.bridge.GraphicsNodeBridge gnBridge =
              (org.apache.batik.bridge.GraphicsNodeBridge)
                bridge;
            topNode =
              gnBridge.
                createGraphicsNode(
                  ctx,
                  svgElement);
            if (topNode ==
                  null) {
                return null;
            }
            rootNode.
              getChildren(
                ).
              add(
                topNode);
            buildComposite(
              ctx,
              svgElement,
              (org.apache.batik.gvt.CompositeGraphicsNode)
                topNode);
            gnBridge.
              buildGraphicsNode(
                ctx,
                svgElement,
                topNode);
            dBridge.
              buildGraphicsNode(
                ctx,
                document,
                rootNode);
        }
        catch (org.apache.batik.bridge.BridgeException ex) {
            ex.
              setGraphicsNode(
                rootNode);
            throw ex;
        }
        if (ctx.
              isInteractive(
                )) {
            ctx.
              addUIEventListeners(
                document);
            ctx.
              addGVTListener(
                document);
        }
        if (ctx.
              isDynamic(
                )) {
            ctx.
              addDOMListeners(
                );
        }
        return rootNode;
    }
    public org.apache.batik.gvt.GraphicsNode build(org.apache.batik.bridge.BridgeContext ctx,
                                                   org.w3c.dom.Element e) {
        org.apache.batik.bridge.Bridge bridge =
          ctx.
          getBridge(
            e);
        if (bridge instanceof org.apache.batik.bridge.GenericBridge) {
            ((org.apache.batik.bridge.GenericBridge)
               bridge).
              handleElement(
                ctx,
                e);
            handleGenericBridges(
              ctx,
              e);
            return null;
        }
        else
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.GraphicsNodeBridge)) {
                handleGenericBridges(
                  ctx,
                  e);
                return null;
            }
        org.apache.batik.bridge.GraphicsNodeBridge gnBridge =
          (org.apache.batik.bridge.GraphicsNodeBridge)
            bridge;
        if (!gnBridge.
              getDisplay(
                e)) {
            handleGenericBridges(
              ctx,
              e);
            return null;
        }
        org.apache.batik.gvt.GraphicsNode gn =
          gnBridge.
          createGraphicsNode(
            ctx,
            e);
        if (gn !=
              null) {
            if (gnBridge.
                  isComposite(
                    )) {
                buildComposite(
                  ctx,
                  e,
                  (org.apache.batik.gvt.CompositeGraphicsNode)
                    gn);
            }
            else {
                handleGenericBridges(
                  ctx,
                  e);
            }
            gnBridge.
              buildGraphicsNode(
                ctx,
                e,
                gn);
        }
        if (ctx.
              isDynamic(
                )) {
            
        }
        return gn;
    }
    protected void buildComposite(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.CompositeGraphicsNode parentNode) {
        for (org.w3c.dom.Node n =
               e.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                buildGraphicsNode(
                  ctx,
                  (org.w3c.dom.Element)
                    n,
                  parentNode);
            }
        }
    }
    protected void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                     org.w3c.dom.Element e,
                                     org.apache.batik.gvt.CompositeGraphicsNode parentNode) {
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                )) {
            throw new org.apache.batik.bridge.InterruptedBridgeException(
              );
        }
        org.apache.batik.bridge.Bridge bridge =
          ctx.
          getBridge(
            e);
        if (bridge instanceof org.apache.batik.bridge.GenericBridge) {
            ((org.apache.batik.bridge.GenericBridge)
               bridge).
              handleElement(
                ctx,
                e);
            handleGenericBridges(
              ctx,
              e);
            return;
        }
        else
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.GraphicsNodeBridge)) {
                handleGenericBridges(
                  ctx,
                  e);
                return;
            }
        if (!org.apache.batik.bridge.CSSUtilities.
              convertDisplay(
                e)) {
            handleGenericBridges(
              ctx,
              e);
            return;
        }
        org.apache.batik.bridge.GraphicsNodeBridge gnBridge =
          (org.apache.batik.bridge.GraphicsNodeBridge)
            bridge;
        try {
            org.apache.batik.gvt.GraphicsNode gn =
              gnBridge.
              createGraphicsNode(
                ctx,
                e);
            if (gn !=
                  null) {
                parentNode.
                  getChildren(
                    ).
                  add(
                    gn);
                if (gnBridge.
                      isComposite(
                        )) {
                    buildComposite(
                      ctx,
                      e,
                      (org.apache.batik.gvt.CompositeGraphicsNode)
                        gn);
                }
                else {
                    handleGenericBridges(
                      ctx,
                      e);
                }
                gnBridge.
                  buildGraphicsNode(
                    ctx,
                    e,
                    gn);
            }
            else {
                handleGenericBridges(
                  ctx,
                  e);
            }
        }
        catch (org.apache.batik.bridge.BridgeException ex) {
            org.apache.batik.gvt.GraphicsNode errNode =
              ex.
              getGraphicsNode(
                );
            if (errNode !=
                  null) {
                parentNode.
                  getChildren(
                    ).
                  add(
                    errNode);
                gnBridge.
                  buildGraphicsNode(
                    ctx,
                    e,
                    errNode);
                ex.
                  setGraphicsNode(
                    null);
            }
            throw ex;
        }
    }
    protected void handleGenericBridges(org.apache.batik.bridge.BridgeContext ctx,
                                        org.w3c.dom.Element e) {
        for (org.w3c.dom.Node n =
               e.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n instanceof org.w3c.dom.Element) {
                org.w3c.dom.Element e2 =
                  (org.w3c.dom.Element)
                    n;
                org.apache.batik.bridge.Bridge b =
                  ctx.
                  getBridge(
                    e2);
                if (b instanceof org.apache.batik.bridge.GenericBridge) {
                    ((org.apache.batik.bridge.GenericBridge)
                       b).
                      handleElement(
                        ctx,
                        e2);
                }
                handleGenericBridges(
                  ctx,
                  e2);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwcRxWfO387/s4nSex8OUFx0rtGTYDKodR27MTh7Jg4" +
       "McJpc5nbnfNtvLe72Z07n11S+gFKQCKKgtuGQoOQUpqitKkKFVDaKqiCpBSQ" +
       "WiKgoKaV+IPwEdEIqagKUN6b3b3d27tzFERO2tm9mTdv5v3mN++9mbNXSZVl" +
       "kg6m8QifNpgV6df4CDUtJvep1LL2QF1ceqyC/mP/leE7w6R6nDSlqDUkUYsN" +
       "KEyVrXHSrmgWp5rErGHGZOwxYjKLmVnKFV0bJwsVazBtqIqk8CFdZigwRs0Y" +
       "aaWcm0oiw9mgo4CT9hjMJCpmEu0JNnfHSIOkG9Oe+BKfeJ+vBSXT3lgWJy2x" +
       "gzRLoxmuqNGYYvHunEk2GLo6PaHqPMJyPHJQ3eJAsDO2pQiC1c81v3/9eKpF" +
       "QDCfaprOhXnWbmbpapbJMdLs1farLG0dIveTihiZ5xPmpDPmDhqFQaMwqGut" +
       "JwWzb2RaJt2nC3O4q6nakHBCnKwqVGJQk6YdNSNizqChlju2i85g7cq8tbaV" +
       "RSY+siE6+9j+lucrSPM4aVa0UZyOBJPgMMg4AMrSCWZaPbLM5HHSqsFijzJT" +
       "oaoy46x0m6VMaJRnYPldWLAyYzBTjOlhBesItpkZietm3rykIJTzryqp0gmw" +
       "dZFnq23hANaDgfUKTMxMUuCd06VyUtFkTlYEe+Rt7Pw0CEDXmjTjKT0/VKVG" +
       "oYK02RRRqTYRHQXqaRMgWqUDAU1OlpZVilgbVJqkEyyOjAzIjdhNIFUngMAu" +
       "nCwMiglNsEpLA6vkW5+rw1uP3aft0MIkBHOWmaTi/OdBp45Ap90syUwG+8Du" +
       "2NAVe5QuevlomBAQXhgQtmV+8Plrd2/sOH/RlllWQmZX4iCTeFw6nWh6Y3nf" +
       "+jsrcBq1hm4puPgFlotdNuK0dOcM8DCL8hqxMeI2nt/9s8898F321zCpHyTV" +
       "kq5m0sCjVklPG4rKzO1MYyblTB4kdUyT+0T7IKmB75iiMbt2VzJpMT5IKlVR" +
       "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" +
       "HlUZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVaecwr11Wf972895LX5L2XpFkIzdqXQuLyzXjGK+kSe7zN" +
       "PrbHY3ugfZ3N47Fn8yyesUugDUsiKpUA6QJq8we0dFHaVEAFoi0EUDe1Qiqq" +
       "2CTaCiFRKJWaPyiUAOXO+Ps+f9/3lhKlWJrr8b3nnHvPuef87rn3+tlvQ6cC" +
       "H8p5rrUyLDfc1ZNwd2YVd8OVpwe7JF3kZT/QNdySg0AAdZfUBz5x/rsvPjW9" +
       "sAOdlqBbZcdxQzk0XSfo6YFrLXWNhs5va5uWbgchdIGeyUsZjkLTgmkzCB+h" +
       "oVccYg2hi/T+EGAwBBgMAc6GANe2VIDpJt2JbDzlkJ0wWEA/C52godOemg4v" +
       "hO4/KsSTfdneE8NnGgAJ16e/RaBUxpz40H0Hum90vkzhd+Xgp9/z5gu/exI6" +
       "L0HnTaefDkcFgwhBJxJ0o63biu4HNU3TNQm62dF1ra/7pmyZ62zcEnRLYBqO" +
       "HEa+fmCktDLydD/rc2u5G9VUNz9SQ9c/UG9i6pa2/+vUxJINoOvtW103GrbS" +
       "eqDgWRMMzJ/Iqr7Pct3cdLQQuvc4x4GOFylAAFjP2Ho4dQ+6us6RQQV0y2bu" +
       "LNkx4H7om44BSE+5EeglhO66qtDU1p6szmVDvxRCdx6n4zdNgOqGzBApSwjd" +
       "dpwskwRm6a5js3Rofr7Nvu6db3U6zk42Zk1XrXT81wOme44x9fSJ7uuOqm8Y" +
       "b3yYfrd8+2ee3IEgQHzbMeINzR/8zAuPvvae57+wofnRK9BwykxXw0vqB5Rz" +
       "X3kV/lD1ZDqM6z03MNPJP6J55v78XssjiQci7/YDiWnj7n7j873Pjd/2Uf1b" +
       "O9BZAjqtulZkAz+6WXVtz7R0v607ui+HukZAN+iOhmftBHQGvNOmo29quckk" +
       "0EMCus7Kqk672W9gogkQkZroDHg3nYm7/+7J4TR7TzwIgs6AB4LB8yC0+WTf" +
       "ITSAp66tw7IqO6bjwrzvpvoHsO6ECrDtFFaA18/hwI184IKw6xuwDPxgqu81" +
       "KL6pGTrcFoV6ZFqa7u+m7uX9fwlOUo0uxCdOAGO/6nioWyBKOm5Ke0l9Oqo3" +
       "X/j4pS/tHLj+ni1C6AHQ1+6mr92sr91NX7vbvqATJ7IuXpn2uZlLMBNzENMA" +
       "7W58qP8m8i1PPnASOJEXXwfMmJLCVwddfIsCRIZ1KnBF6Pn3xm8Xfw7ZgXaO" +
       "omc6TlB1NmXnU8w7wLaLx6PmSnLPP/HN7z737sfcbfwcgeO9sL6cMw3LB45b" +
       "1HdVXQNAtxX/8H3yJy995rGLO9B1INYBvoUy8EcAHfcc7+NIeD6yD3WpLqeA" +
       "whPXt2UrbdrHp7Ph1HfjbU021eey95uBjV+R+utt4Hl4z4Gz77T1Vi8tX7lx" +
       "jXTSjmmRQenr+977/+Yv/hnLzL2PuucPrWN9PXzkUKSnws5nMX3z1gcEX9cB" +
       "3d+/l//1d337iZ/KHABQvPpKHV5MSxxEOJhCYOZf/MLib7/+tQ98dWfrNCFY" +
       "6iLFMtXkQMm0Hjp7DSVBb6/ZjgcghQWCKvWaiwPHdjVzYsqKpade+l/nH8x/" +
       "8l/feWHjBxao2Xej1/5gAdv6H6lDb/vSm//9nkzMCTVdqbY225Jt4O/WreSa" +
       "78urdBzJ2//y7t/4vPx+AKQAvAJzrWd4BGU2gLJJgzP9H87K3WNt+bS4Nzjs" +
       "/Efj61BGcUl96qvfuUn8zh+/kI32aEpyeK4Z2Xtk415pcV8CxN9xPNI7cjAF" +
       "dIXn2Z++YD3/IpAoAYkqwKqA8wFEJEc8Y4/61Jm/+9M/v/0tXzkJ7bSgs5Yr" +
       "ay05CzLoBuDdejAF6JR4b3x0M7nx9aC4kKkKXab8xinuzH6dBAN86Or40koz" +
       "im2I3vmfnKU8/g//cZkRMmS5wkJ6jF+Cn33fXfgbvpXxb0M85b4nuRx2Qfa1" +
       "5UU/av/bzgOnP7sDnZGgC+peaifKVpQGjgTSmWA/3wPp35H2o6nJZh1+5ADC" +
       "XnUcXg51exxctnAP3lPq9P3sYTz5PvicAM//pE9q7rRisyDegu+tyvcdLMue" +
       "l5wA0XoK3S3vIin/GzMp92flxbT4sc00pa8/DsI6yHJKwDExHdnKOn40BC5m" +
       "qRf3pYsgxwRzcnFmlTMxt4GsOnOnVPvdTWK2AbS0RDMRG5coXtV9fnJDla1c" +
       "57bCaBfkeO/4x6e+/Cuv/jqYUxI6tUztDabyUI9slKa9v/Tsu+5+xdPfeEeG" +
       "UgCixF948a5HU6n0tTROi2ZatPZVvStVtZ8t7bQchEwGLLqWaXtNV+Z90wb4" +
       "u9zL6eDHbvn6/H3f/NgmXzvut8eI9Sef/uXv777z6Z1DWfKrL0tUD/NsMuVs" +
       "0DftWdiH7r9WLxlH65+ee+xTH37sic2objma8zXBluZjf/XfX9597ze+eIXk" +
       "4zrLfRkTG96kdQoBUdv/0OJ4MozVXjKccFilDAcFp68nFW7QShA/bAvjBuVq" +
       "PbTMCNMyaRQYlfTUoqM4EzZc0noZlZCyk8/3c0aL6uIUZYRRu+ty3YG3MENq" +
       "TrXEhkwtTNyr97tDkzJcShZzBB83tSaxkA1qwJYUTME0tByuW80eh4Z21Ra0" +
       "ZXGJ2WwuV7UVdtSXRGtulOxK15ywniGWtEkBbwxCcql7eZpGu628qi9WOGzz" +
       "sKU3y3GpV3IafWvRGMwH44ClmivRH3X6vm0MvaLf9NudtsTFyXhG0bbogDEi" +
       "ChkHoryuhwtiMa/gLU0yjbgXIGNZHqo24ppx1TbcAi5UpzOGxD27GSEk60w6" +
       "fYKbt6ucnqtTE53MLev9kYBZxpBcoYmx7tFuYkcLtj0eLzuR05yjbdot8XJn" +
       "wTPkiu+QXUwna0GDQ72uiefVSn6JwVWd8lrdBj6RPZ+bjpyhYiue7Ckko9FB" +
       "fiL7dBvRCOBM5tSUiglvew3ebkwXra7MxIt2FJLxcK2gPZkMUQfHuMKi5Mjz" +
       "Th13qHghtsnuvDTW2D5rrhf41JpFqFkpGmV1UQkVWez1x7nAbJZy1VnOilS/" +
       "zzMFWZSRgbTi6iRvMIxRqDF+Hx9KMq/QTLHT6S+Cljlbk4Iru6tCKUHsksjI" +
       "ZM8Z85Y2pGur8bouzDhrWtcDIvTmkqmHNuav5gQprP3VwkMMO9aklrNAsWmN" +
       "lRvGZEAJTMIMIlxDSuJqELbmgjVu6rleWOZjBG82RvZMmFECAouU2HbHFIL2" +
       "er2FMO51uqOF3GOM4WLQqA3ynOVJomkZikgu5s3VipvV1sRMm7JEa+AYTC1y" +
       "8JgxDYsNmh5dKy3nw2LOj/MRj8mTEGGIeb3DDW1ZMGFOq3uFYs2rIsFqELdz" +
       "lUaEsjVRL3YjfWm5dr3WHU2NbmiLuQpv+RoKB1wH7lmWNeza0qhg4oLeikvO" +
       "cFoaY84kNwt8tb7IT+2CF/FGCwS/xkYUonEqU2ngdGW6SBidQJ0QrgaVSrXS" +
       "wtD8Gvc6K0GcL4o2EuAzcW7x7YJPrbk8M14pllAvzLXBSsghQpmg7Hq5aJqM" +
       "EqLimvQYoUhQltgTZZSG43qvaXWNHj+K/eGUxCYISjVzZLmY1HHAN0WE6XCw" +
       "DBxsug5muoyETNA3hwtKcvWO0MqHbI4yAo2s0WALVCPHfGLnq0RMtoj1ojjv" +
       "D2pGtb9uW4RNuJVYppUEVhBp2hMle9wsDUcqFQyKYXuWE3GjOcYrvOIMRC2Y" +
       "c53haIbYKzuEYTmAOyOl506rPSTgWnN2jIyCoE+aPmFUxaCrmIUePnaNFkfJ" +
       "Vcuv9edl3InlOerXc1Utp9fdUuAbTaEt4qOaSVE+XiBppzxJRsOKZlVKeVYt" +
       "BZG/9vIC7s3IJkotm4wotIZV0hAKxHDeH+oz1uwa5c5Mn5RGfA7lx4wDwlqv" +
       "V1bzQb2HRKFjD+y8w61ialKfDdACXuItAuHJnMSvyRLYSPJLvDxs9mlHKHDt" +
       "rpjD/YB3yYiLchxXYJSlJOhFkx1hMxgrtTvAZYhWU+2yk+agiowVsdsjmoWx" +
       "RY/6Sw+H26MGplIot6yRI4YaxmZlNNDiWY3ikShfksp9q2UkXMmW5UU4m4+t" +
       "NT8ojXNFbUBovkyVY7FmYnYh6Sk4khsF3KTTzs8HbeB3IWvyfM0aE2UYJgc6" +
       "R2IwtlhjKhGx+Rqir+gKxTEaHKnNlec30ZKbl/mw4zHJvLMsF5nZqONbJYmE" +
       "DbppBpQgGmRRqhbInoF3OzadRypVdly2kOoEd4JKMcE1JrYI1SGLRLmt55nq" +
       "lCRW6NoLeK6hinANX3kOt6wvk8Hc8NhFLcbyfk7Oo8VSYQh3hnasL1oN4Cez" +
       "2awnFqo92CO7ucpymZt0BiTbZ2iwUnRsU5vrernkRKqKlASBI+CJYefykyWC" +
       "T2pshYdDqS9509gd9Iwu0zeVXgfFVmVqPW6jM5RL8ktKWGJ1OCdRRtQRKogT" +
       "sWOwHqlzjAlnID4XcL7ZGJaUkTcN+oVOaap2HI3h5IVYU5Z8sTAK5TzPj7o6" +
       "wE9SqC3FRVng64uoS9ocS4qsAsMrOaIbftLrqkTDa5XFhZDUkv54pqn1SFqM" +
       "aq4uM0I1H9K54oDudcPY6vWlTtKrd6mKuxT6VVll6QDXc3rHLKPVainsWbFA" +
       "N/J+h/FhfDZsr4kKglUWLldfMxVMQFhigle84oRuTZtKJ4z0tYD0kaWYyIRF" +
       "LZAYZh2PxEBAkmC1l/E5W+XR/moNr22snCOczhoLe0TiFcp+YiOL1ZoW2TVS" +
       "mZcB9BHIdK60in60DL0pC8OtjtPjYLZXWwWl8rQuMA2YquCEvyR6RMMU8Riu" +
       "SrqtR3miowR00Qee3BaFYpVtSPmyvJwjpWZv5C1yMGqGtBwPyupkCKJMIvGO" +
       "jBp2ftanOgphr4sDq0/kUb0xLo9YS0WN9shtgaxbGvltp1YbK21zLGmxXFla" +
       "bRozi70YG3HzFtXI56dJv1cd9eb2qmghQY1iFD3hJmuGF6eVqcct6vg49BdF" +
       "sCayvNSx5hFisxZOSnG5UeguCWHIrVAtP8PgslkOZLrT5MVGIk2djo6v2EK1" +
       "GMkli1F12MFGrJPLdZpGzqU9muo0TTuQ6hrJd/iJUZlrRliTAwrlnRnHkVJO" +
       "ikvdHmu3kmE+alGFtUCiDQoVV0S9hkW+R5VqcW2Atwdid4YEjZnbDafifN4e" +
       "t1DcjCfJoBlyqt3lpVy5XRuw4/mcwfwao2MTt+jjIkt2EVnQukUUUdmwjCS5" +
       "SsVdh2GFdQyiEUdrt9xSc7P6SglHaDwRe/oA68nViZ7MKiHIYhHUrsM4HQv8" +
       "BK7XB+UajmH1UtnhOQVfrqfrMTM0JYnVdCSp1xqTtYflGM1pTCskV60xqkVJ" +
       "+d5IGicLWBzEisGp1jQZgGyvVpbcgKwOKcmfqWarrmD4BHGKiwZB16VJUe6J" +
       "A0bgaTspoATvoBSKe0lObySxwpenRZ3x8o7KKvgIJC82zBrqCgtGhhrPwQrh" +
       "01SdYwarccEQDVxV4BiOGSsZRBXNmLXKwzyJOENpUhs4vGMvotEoWYB4akke" +
       "BXu2XevgnDQQxYkJErcS6jekptVCWckgy1xbb2DsSidWtR7LdWoOXwC5HNyy" +
       "uKFLr0o0lpQltVyHpYK6aFDwEqd5pkrWxzOjCKtMPuZQk4xFv2KYVSffpa2+" +
       "asX+uFUtEFUnHsHFOc1LpcLa6QpuIam6PXsEzClzo/UkHFeqsgQXSXLErSl8" +
       "qAut/jipwJWKIy58Wh61MJGrShMFW0TKAvPVlh/io6g5ipTZ0ICbrS47mrQd" +
       "o9vu5YtBtaUUMT0XuMtZXoZxpZjvALDBaaU8IXWStch4EXg10Q+WxWiYX0Zh" +
       "rIq0P1rChWoLUeYYDBvIrGiO8tXAX1UmrVWpyvary3UpKTb6aokbs3PTj71+" +
       "jAmRK8rVCAm9kByOOJXFveEkLtl4yx0sjFIfdVd2h1nEXcFq2x6utvBKqd4v" +
       "cA6BFYd+nBh1FlfHsbu09Xqh2hww2DI/w+X+tCkRUxqVDSccTuFGvq0yhAbw" +
       "tjKPii47QyNaCFcVZNkZ5vw2UWNFG+dGGMpaA2eu5mE4L0du0GTklgUzqNb2" +
       "iWlBYYwYs70W1pCWCV8WrYAsCQNSA8lgYSrhqprjdXPQ0eqTNp1aHq97I7tj" +
       "DSSwq3p9ut1600vb8d6cbe4PrmDARjdt6LyEnd6m6f60ePDgQDD7nD5+bH/4" +
       "QHB7SnRi/yDh8gPubGfaF9sHd23pRvfuq13CZJvcDzz+9DMa98H8zt5B3CiE" +
       "bghd7ycsfalbh3pNLxwfvvqGnsnuoLYHRJ9//F/uEt4wfctLOPa+99g4j4v8" +
       "CPPsF9uvUX9tBzp5cFx02e3YUaZHjh4SnfX1MPId4chR0d0Hk3BnavO7wVPY" +
       "m4TClY+er+gwJzKH2bjJsXPOnYxgZ3/aHrzavUQ9+9q7otynfmVKHWPqruba" +
       "uw1XjWzdCbNuomscp741LbwQOqWkFx37su6/rGdjGe62fdmbmmrAupq+deHF" +
       "DzqsONxlVmFfbsjlniGXP1RDpj+X+zrdetg+6b31vnmeuIZ53pEWj++bJ/3x" +
       "2Fbzn38Zmp9LK3HwfHhP8995KZqD0PN8N9TVUNeuaICTW2xapsWT+1Z4+Ioz" +
       "mx5Cpvcc+uEpzgS/+xrG+c20eCqEzmXGOZCR0fYPodswhK5buqa2tdyvvlzL" +
       "tcDz6T3L/dFL9Zmn/28mS4v3ZKQfuoYRPpIWvwXwPjPCYfulDe/b6vzbL1fn" +
       "Jni+t6fz9344Oh+Ok0znjOr3rqHuJ9Pi4wBtprKjWXp2JG6qG0AKjmn83EvR" +
       "OAmhs9v71vTy6M7L/rmx+beB+vFnzl9/xzODv86uHA/+EXADDV0/iSzr8Fn/" +
       "offTnq9PzEyHGzYn/1729ekQuuMqOBtCp5WtYp/a0P9JCF04Tp/iQ/p9mO7P" +
       "gD5bOiBq83KY5LMhdBKQpK+f865w6L+58khOHFpc9zwjM+8tP8i8ByyHbyTT" +
       "BTn758z+4hlt/jtzSX3uGZJ96wulD25uRFVLXq9TKdfT0JnN5ezBAnz/VaXt" +
       "yzrdeejFc5+44cH9ZOHcZsBbLz00tnuvfP3YtL0wuzBc/+Edv/+6Dz3ztewO" +
       "4n8BXfMumNIkAAA=");
}
