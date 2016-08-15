package org.apache.batik.bridge.svg12;
public class BindableElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge implements org.apache.batik.bridge.svg12.SVG12BridgeUpdateHandler {
    public BindableElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return "*"; }
    public java.lang.String getLocalName() { return "*"; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.svg12.BindableElementBridge(
                                                            ); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                e,
                ctx.
                  getUserAgent(
                    ))) {
            return null;
        }
        org.apache.batik.gvt.CompositeGraphicsNode gn =
          buildCompositeGraphicsNode(
            ctx,
            e,
            null);
        return gn;
    }
    public org.apache.batik.gvt.CompositeGraphicsNode buildCompositeGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                                 org.w3c.dom.Element e,
                                                                                 org.apache.batik.gvt.CompositeGraphicsNode gn) {
        org.apache.batik.dom.svg12.BindableElement be =
          (org.apache.batik.dom.svg12.BindableElement)
            e;
        org.w3c.dom.Element shadowTree =
          be.
          getXblShadowTree(
            );
        org.apache.batik.bridge.UpdateManager um =
          ctx.
          getUpdateManager(
            );
        org.apache.batik.bridge.ScriptingEnvironment se =
          um ==
          null
          ? null
          : um.
          getScriptingEnvironment(
            );
        if (se !=
              null &&
              shadowTree !=
              null) {
            se.
              addScriptingListeners(
                shadowTree);
        }
        if (gn ==
              null) {
            gn =
              new org.apache.batik.gvt.CompositeGraphicsNode(
                );
            associateSVGContext(
              ctx,
              e,
              gn);
        }
        else {
            int s =
              gn.
              size(
                );
            for (int i =
                   0;
                 i <
                   s;
                 i++) {
                gn.
                  remove(
                    0);
            }
        }
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        if (shadowTree !=
              null) {
            org.apache.batik.gvt.GraphicsNode shadowNode =
              builder.
              build(
                ctx,
                shadowTree);
            if (shadowNode !=
                  null) {
                gn.
                  add(
                    shadowNode);
            }
        }
        else {
            for (org.w3c.dom.Node m =
                   e.
                   getFirstChild(
                     );
                 m !=
                   null;
                 m =
                   m.
                     getNextSibling(
                       )) {
                if (m.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    org.apache.batik.gvt.GraphicsNode n =
                      builder.
                      build(
                        ctx,
                        (org.w3c.dom.Element)
                          m);
                    if (n !=
                          null) {
                        gn.
                          add(
                            n);
                    }
                }
            }
        }
        return gn;
    }
    public void dispose() { org.apache.batik.dom.svg12.BindableElement be =
                              (org.apache.batik.dom.svg12.BindableElement)
                                e;
                            if (be != null &&
                                  be.
                                  getCSSFirstChild(
                                    ) !=
                                  null) {
                                disposeTree(
                                  be.
                                    getCSSFirstChild(
                                      ));
                            }
                            super.dispose(
                                    ); }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return null;
    }
    public boolean isComposite() { return false;
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        initializeDynamicSupport(
          ctx,
          e,
          node);
    }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.apache.batik.dom.svg12.BindableElement be =
          (org.apache.batik.dom.svg12.BindableElement)
            e;
        org.w3c.dom.Element shadowTree =
          be.
          getXblShadowTree(
            );
        if (shadowTree ==
              null &&
              evt.
              getTarget(
                ) instanceof org.w3c.dom.Element) {
            handleElementAdded(
              (org.apache.batik.gvt.CompositeGraphicsNode)
                node,
              e,
              (org.w3c.dom.Element)
                evt.
                getTarget(
                  ));
        }
    }
    public void handleBindingEvent(org.w3c.dom.Element bindableElement,
                                   org.w3c.dom.Element shadowTree) {
        org.apache.batik.gvt.CompositeGraphicsNode gn =
          node.
          getParent(
            );
        gn.
          remove(
            node);
        disposeTree(
          e);
        handleElementAdded(
          gn,
          e.
            getParentNode(
              ),
          e);
    }
    public void handleContentSelectionChangedEvent(org.apache.batik.bridge.svg12.ContentSelectionChangedEvent csce) {
        
    }
    protected void handleElementAdded(org.apache.batik.gvt.CompositeGraphicsNode gn,
                                      org.w3c.dom.Node parent,
                                      org.w3c.dom.Element childElt) {
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.GraphicsNode childNode =
          builder.
          build(
            ctx,
            childElt);
        if (childNode ==
              null) {
            return;
        }
        int idx =
          -1;
        for (org.w3c.dom.Node ps =
               childElt.
               getPreviousSibling(
                 );
             ps !=
               null;
             ps =
               ps.
                 getPreviousSibling(
                   )) {
            if (ps.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            org.w3c.dom.Element pse =
              (org.w3c.dom.Element)
                ps;
            org.apache.batik.gvt.GraphicsNode psgn =
              ctx.
              getGraphicsNode(
                pse);
            while (psgn !=
                     null &&
                     psgn.
                     getParent(
                       ) !=
                     gn) {
                psgn =
                  psgn.
                    getParent(
                      );
            }
            if (psgn ==
                  null)
                continue;
            idx =
              gn.
                indexOf(
                  psgn);
            if (idx ==
                  -1)
                continue;
            break;
        }
        idx++;
        gn.
          add(
            idx,
            childNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8P8z/iwhOoWV94pXfNv4HwzjXWr+IwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16C8zr1n0f77V9r33j+F7bteO6sWM712ljZR8lUS/WbRqJ" +
       "okiJFEWRlChxax2+RFHi+y223pIMW7IVS4PNSTM0NRA0RdMij27oY0CRzcPQ" +
       "R5Du0a5Y12Ftuu6VLcvQDFg2LN26Q+p733s/w7huP+Ac8Tvnf/7n/P6v8+fh" +
       "+dw3oPvCAKp4rrUzLDc60LPoYGM1D6Kdp4cHI7rJykGoa5glh6EA2l5Sn/v5" +
       "69/69sfWNy5DVyToUdlx3EiOTNcJOT10rUTXaOj6SStu6XYYQTfojZzIcByZ" +
       "FkybYfQiDb3l1NAIukkfLQEGS4DBEuByCXD3hAoMeqvuxDZWjJCdKPShvwxd" +
       "oqErnlosL4KePcvEkwPZPmTDlggAh/uL/+cAVDk4C6BnjrHvMd8C+OMV+JUf" +
       "/6Ebf/8e6LoEXTcdvliOChYRgUkk6EFbtxU9CLuapmsS9LCj6xqvB6ZsmXm5" +
       "bgl6JDQNR47iQD8WUtEYe3pQznkiuQfVAlsQq5EbHMNbmbqlHf1338qSDYD1" +
       "8ROse4SDoh0AvGaChQUrWdWPhty7NR0tgt5xfsQxxpsUIABDr9p6tHaPp7rX" +
       "kUED9Mhed5bsGDAfBaZjANL73BjMEkFP3pFpIWtPVreyob8UQU+cp2P3XYDq" +
       "gVIQxZAIeuw8WckJaOnJc1o6pZ9vMN/30R92SOdyuWZNV61i/feDQU+fG8Tp" +
       "Kz3QHVXfD3zwBfoT8uNf+shlCALEj50j3tP88o98833vefq139jTfNdtaCbK" +
       "Rlejl9TPKA/91tuxd6P3FMu433NDs1D+GeSl+bOHPS9mHvC8x485Fp0HR52v" +
       "cb+2/MDP6V+/DF0bQldU14ptYEcPq67tmZYeELqjB3Kka0PoAd3RsLJ/CF0F" +
       "z7Tp6PvWyWoV6tEQutcqm6645f9ARCvAohDRVfBsOiv36NmTo3X5nHkQBF0F" +
       "BaqA8h5o//dCUUXQCl67tg7LquyYjguzgVvgD2HdiRQg2zWsAKvfwqEbB8AE" +
       "YTcwYBnYwVo/7FACUzN0OEyMWh3uAcOTFUsvwgRg0Cv7Dgp78/7cZsoKzDfS" +
       "S5eAOt5+PhhYwI9I19L04CX1lbiHf/MLL33l8rFzHEorghAw+cF+8oNy8oP9" +
       "5Afl5Ae3nRy6dKmc8zuKRezVD5S3BWEABMgH383/4Oj9H3nuHmB3XnovkHxB" +
       "Ct85TmMngWNYhkcVWC/02ifTD87/SvUydPlswC0WDpquFcPZIkweh8Ob5x3t" +
       "dnyvf/hr3/riJ152T1zuTAQ/jAS3jiw8+bnzIg5cVddAbDxh/8Iz8i++9KWX" +
       "b16G7gXhAYTESAYmDKLN0+fnOOPRLx5FxwLLfQDwyg1s2Sq6jkLatWgduOlJ" +
       "S6n7h8rnh4GM31KY+DOg1A5tvvwteh/1ivo79rZSKO0cijL6fj/v/eS//mf/" +
       "BSnFfRSor5/a+ng9evFUcCiYXS/DwMMnNiAEug7ofv+T7N/5+Dc+/BdLAwAU" +
       "77zdhDeLGgNBAagQiPmv/Yb/e1/9g8/8zuUTo4nA7hgrlqlmxyCLdujaBSDB" +
       "bO86WQ8ILhZwu8Jqbs4c29XMlVnYcmGlf3L9+dov/reP3tjbgQVajszoPa/P" +
       "4KT9O3vQB77yQ//r6ZLNJbXY3E5kdkK2j5iPnnDuBoG8K9aRffC3n/q7vy7/" +
       "JIi9IN6FZq6XIQwqZQCVSoNL/C+U9cG5vlpRvSM8bfxn/etUEvKS+rHf+eO3" +
       "zv/4H36zXO3ZLOa0rsey9+LevIrqmQywf9t5TyflcA3oGq8xf+mG9dq3AUcJ" +
       "cFRBNAsnAYg52RnLOKS+7+q/+cf/5PH3/9Y90OUBdM1yZW0gl04GPQCsWw/X" +
       "IFxl3g+8b6/c9H5Q3SihQreA3xvFE+V/94AFvvvO8WVQJCEnLvrE/5lYyof+" +
       "6H/fIoQystxm7z03XoI/96knsfd+vRx/4uLF6KezW+MwSNhOxtZ/zv6fl5+7" +
       "8quXoasSdEM9zAbnshUXjiOBDCg8ShFBxnim/2w2s9+6XzwOYW8/H15OTXs+" +
       "uJzEf/BcUBfP107Hkz8Ff5dA+X9FKcRdNOz30Eeww438meOd3POyS8Bb76sf" +
       "tA+qxfgfKLk8W9Y3i+q792oqHr8HuHVYpqFgxMp0ZKuc+H0RMDFLvXnEfQ7S" +
       "UqCTmxurXbJ5DCTipTkV6A/2udw+oBV1vWSxN4nmHc3ne/dU5c710Akz2gVp" +
       "4Y/+h4/95o+986tApyPovqSQN1DlqRmZuMiU//rnPv7UW175wx8toxQIUfMP" +
       "PP/1DxRc6YsQFxVeVIMjqE8WUPly86flMBqXgUXXSrQXmjIbmDaIv8lhGgi/" +
       "/MhXt5/62uf3Kd55uz1HrH/klb/5pwcffeXyqcT6nbfktqfH7JPrctFvPZRw" +
       "AD170SzliMF//uLLv/LZlz+8X9UjZ9NEHLwFff5f/d/fPPjkH375NtnIvZZ7" +
       "F4qNbtwgG+Gwe/RH1yS9nqoZZ68mOWxKcE6Z6bRN77S5Q/bI1E9m28mwIdij" +
       "lhbtliJVE9SJUm/GjXpdizQtXoX8rhtN59ORNXM3rW1PtuZ81ZToHeZ7mDyb" +
       "9wLfoAYDl+IosSOiBBV1xbnfozvbOd1aKZN2hERtLYubvh15TXSZI0ierxS4" +
       "udiw7WpX3+423LBXY5rrCczZnOPN4O2Ume3E1kAE4bHRXYksn3CLqpODmKuk" +
       "LYHyyJ2eVpkpeAkJRszYGvNNc+1ZNVGY1eZm0+xtMCnNpD4mEPpktmu6LT5W" +
       "KMlBiXmdGzUNRjZMsof156Y3nO+UcJPRxAplDGZSt8cGP+eGeIxkfWRF8sPJ" +
       "trWI1I4x0ztWm8UGIxuh52PB8zZxxWhsRLkZ4NwmDO22mkpSICaU4/FmZ7qh" +
       "O6oRN6euYsTRZp5xvXCSc54LT8iqi2DpRvYpz19Qa0exJ7bn7nJumFZjpYZi" +
       "YbxkmpNk67pLf6VOVXQoqZnMpP6IExmBq/kzrMXFkh0iVXk71NoO5tfM2cwc" +
       "Taz1LKvKETbORWm466aqHJhR3DTGdbM9kuuRJ8qC2dAW3G4RJXLSzHriVh7N" +
       "6ruJm5s81sXX1TnRnWOiKbD9Nr7digQ1i4DF1FV2vKW2Zrs9R+JInM12gSVq" +
       "60ovU8J8EoxxIm6JY7xi2E1iHlPydq4m1DSnYL/j+1p31uoHbE1b8GqPrRuN" +
       "UW1srO0R5iwdoW6pYNsbbdZSe1Tham0yx6rd7qyuWQSOBhV55s+nruYBg8CX" +
       "ou/rRgpMVe5GQ78/zacNgluLsjyMZi0LEYRBFnXN1YLr19a9aW3qGmrXdVS4" +
       "tjXWbFjd0ivacerNBtuTK60Wp9XN9XY7lPBGys/IZqs+4Nd1mGc8adszxnCI" +
       "LevaeBG7q4nO9gy7N9w4FdeI7FBL2MVKs92WJ+3qMsfP3SiUkPHSZnl1ZYa1" +
       "SismV/MaN3M5tx7bwiheuaSdhjHRHpGx021wktXSh2mTcMaEpyhwq2NX2ZCu" +
       "kPy8CvvSsjqSwt6k7nPRMI2pTr7MB5w9Gzd4WOZFf2npY63JSuGgLQxkqaaE" +
       "NVuYSu2dPjdj06+FAtwd4LyI9XBt1Y39qsPomuoJjQRx8MbQns5YcYqwhE2j" +
       "mkj2eYGSa5thyJuiv/NdkRSG1RpTGU9DftRtK57c24UrZzWr0UPCJnqzcW3E" +
       "YY48lRKpi4y6AsUta1mNCWrVGWJMSC4eD9NxF+v3xWFoJLINo6i488mJwk3W" +
       "OJGT2appuMPuStGIWa/PEt7YCddBM980UlTJtvLE1RmQcCxSfcjJMDEU+5lJ" +
       "cw3OrGoUvW1iQ4W0yZ6A1Z32MmGq057ZnTCtVE4SsuVM9cV82dda3GRu9Hc8" +
       "bSZDrl2LA7KLwaN11Q/mWRulkFre0EYecJatazn+jPI8FehD7PGoF1UQqU/2" +
       "qbmdY6LeGxLSxutvawbWsMRmRgxyXyMJe0mizjjPVCA+QvDiiEx3FL+FbcHd" +
       "hQt4Kzd1gleMlKtgIJz0dZV1p1widXoTuJo1JH41CicOi7i1PtJm+ho1wKba" +
       "qKaK+WyqWYkdpQbM2gxfW/cbdTTmK4IxaNMzLhNCMhjivXqFUV0MpzVh2yMX" +
       "otdtyJwtUSY2TduEJmSR3GPiTd5fDBK80uvsTDKo7TAhCxRBnSe50RI6Wj2x" +
       "F7pMqBV6JmAxKS2TSodNYCSQpqN41Far+tLHlqrcZlf42FZEascsTDuuMj2b" +
       "6aKozLliZwXH/W7fJvIpTXRqQ0qrsxJGDsdRb2TCcJwzQRvJ0QDPl9pqMuGF" +
       "qtLLfdfKQKqXOtp0QKW2GywWW4M03Sml9fxJoAfLEbqbbRVk2lm15uiEipYV" +
       "dFXTc2mqUmh/bUcTBeszecXM5Wm92YJb+niS8svtUmjWxwt2FGD9VdOh4/F0" +
       "1+pVFsP2otKEhYQFHmYsZtiQiUVUwDltuOkay2gS46y3oqKAXonMYqmwGNrz" +
       "YHeBNlv+MmtpmNTPIpJ1ct8ZYfWQ7e/ayawLfC7qdEa2NG0vc1glvR0yE7qs" +
       "1pxP+ou6JXpho5/VSIPC8S4TqDKOSXlPktaz2orRk+pC6MBKZT4cYGLH1JYe" +
       "gTdjV+2PeAxVmLzP4fVRXqnocZhLddeQJcnHfcrCYH867C4stNVK3HzS09bt" +
       "VR7AaH/mbIJGFOA7RMfy3ThJx4yf5KipVHyvrjbhrNVWEQvv0QmWm83xxiD7" +
       "QzRcBMnETHIFnU637V1tJsy6MdcUFPCIuJthW0uSbVUVxEY9jgifr4UE7RoN" +
       "utHQULizpbe7XmVFNYmlHNj2okWBzUZqcEQbH00jfrfsujCTpWikhDEKo6Ko" +
       "+SnC7zBWqi2wHttgK/R0accdywGZgptHMBo1pkhQzWNny3XFSqVfDeGcS3GW" +
       "VeYND+Gq4lxuzbGG7zc6oxEybxrLOdGfCnbiesGyujM7kuPoKyvgFiMFU5vz" +
       "iK3p837oWgIGDCn0mP7UoIbpYLPo0LZZ6SeUuiSnHC70R/MIQZVEJCq5iuFh" +
       "x2TELd8hWDdhmDAi4wSl4Q4/IS2k2s+mZq1LsrqVMKjGkD6Tz7o9bpkODMpu" +
       "1lWm28PGs7q58zEUaY3jAcnbLmGSXgcWvTrcmo14hfCxGBe6tmpTxBbxu2mC" +
       "d7Nat7VzZ02qLTdFapsbzAwjx4zBEtOA7XNoMPYYVMc5kGbhpDJf9KgoWqRq" +
       "o0bUhuyCkAa45drLtYZOEw41dGNlYIpYIbs0tx13QsY2Kp4nCkNyKDZaq5Eq" +
       "8hIuN5u4ybsknKydbpKS5DykhAgfjIU1Cktb1EpX6wWG436HgZVQcfqpjAWj" +
       "rrSc2RQjAv5bYrnrssNNndzR28YiC6h0yyejrhmOY9/V7O5gzqW1Dp63pkyu" +
       "C9UZX0WYWb9JpvKYVFc2hek5HgxHdh9zicFysOiGsmrIk16FrWczr7qohO24" +
       "jSKoTQRLllyliTmsq+RIQVI5FhOeslqh3wosTtEGyMYRNWk2DdEtiNNsA+uQ" +
       "uYJk014l7y4QzF4kyUTCnUrVmAbT4TjscyOapkkvmbNtZ2M229X+MvP51bbj" +
       "ZcKs1ciSPkoIGMEJZr3vtdttro6yne6SY+JBzi8mDdkSmXw6GQg9ujJuspsp" +
       "3unu8rW5xLJRG2/mqtVptXxl1xaWWqVZbSy8sBf3/DTHwxHelgu/TOLKzM58" +
       "o6KMe8s2TDRtZ+gElLTZmQMr15a8gTqNnYJUVKrlSgifqq01W4snao0YYQA0" +
       "MmI5pdHqxHE4mHHsYtkj9KA6RXuCMWs1G4FRl8BuwRmsPmiuMlNlqaaH+Yy/" +
       "8KIpHEqe4OPjWjJU2vW8VZFJ0dzW0klsOMzcmicbh66sJ4PBahiOswTBJnO9" +
       "47qToCq4fnOHx96ubwvYfNFpzmxc3Dnopr1aBC3PoVo5M6VHPLzGljQ8SQmx" +
       "s9PCRaxvOXm6SXYq2hjTebbNe+qu2pm15ckMnZAems2cTmuy0kl4yxALnQqt" +
       "CRX7JJVGMtLZEY5GebDaN9hwasOqsWmtBu4i2NQMHO/PvIW07RqDftbBwGsM" +
       "NeWT9URDGCNNhDXcG3SiMT2va00bCfoh2Vp1e7hT7+c4z+HYjupsXUlYmJbL" +
       "eg1Ppug0IRYBWlGq7sLOc4YzGrCndmhxTDHZnA3zUGwxuoFplp3m1IByvU3d" +
       "drsScB5PkuyuklHhtDHvb/vEGCbGShpXhiFTo8NFym6yhkGvEWEk7Do6kqbt" +
       "aT5vJJpNieE4mk6xJUOrlM2IlQVqD0YrHKktNaWedLph1nHUrYduOr1mNtUI" +
       "ZDlJ2t4KJGqyLFdmOpLsgjiF6RXRC40KL+dmPBrpaGMmUlWFxrZ0tReHcm2u" +
       "yfRO3cJS163wwFd3Zt8fWDWfn88IcW6r3AjkDjDqKO4c3SoNf0YmMb3g2zqx" +
       "zf1F31pLdK3FU5g6nw6pxKoEE8XvBF4VZ+fYlrAUA9Fr22Fzt1vR9LoxmA6c" +
       "tjurMxt4UKnhPWFHmngbFZw6H23gbFP17U0thXU1blMNVCL7M3utw6ppIb7L" +
       "+3lCIZLU7FfxCkj6EsoHynPhCkrKA7Wxdsczvs6KW05qLOspk3FVrS/GZrsj" +
       "qO1OtoKDrN5u+s6KpLIKoTbak6o5VCOqnsKTHrLyZWSECGEqeUiGB0HQBCEZ" +
       "r3ALPqnELR0VYx5G1n2E2Ap+zW/H/Ry1ScHOhvUEoRFDxPVljdUFyun2rHVo" +
       "aQrVVJeV1gZsw1nxHjquV8ghSKhHowW29dt1cZMPJp1Bj2/UnSHSXCTptucQ" +
       "aYXJRBgjMhB0bZse9HatAEtlvBGQWjsYIdlCkWxNqyKpjmRzkMguWcboO2qf" +
       "Jpch4/eDfGOnFUNvddgOeLNP1xNXnKMNb7FikgaZ5puFGFSGabdbHA384Bs7" +
       "nXm4PIg6/sK4sdpFB/kGTiX2Xc8W1fPHh9fl35Wjr1FHv6cPr09ONC8dHXq1" +
       "Lv46w8+JWn3/TWbmaXKkk7KjWXpQHNQ8dafvjuUhzWc+9Mqr2uSna5cPD5IX" +
       "EfRA5Hp/wdIT3Tq1krcCTi/c+UBqXH52PTng/PUP/dcnhfeu3/8GPtu849w6" +
       "z7P82fHnvky8S/3bl6F7jo87b/kgfHbQi2cPOa8FehQHjnDmqPOpY8U8Uujh" +
       "WVDah4pp3/7TyW2N6FJpRHvTueCcPr6gLy0qL4KuG3rEgFWHQN36jBuWVndi" +
       "cP7rHYOd5ls22GchPg3Kew8hvvfNh/jBC/r+alH9SAQ9CCDSripbzKF2TuF7" +
       "+W7xPQUKfogPf/Px/a0L+n6sqD4SQW8B+I6M8MiFn76TC+/99kQAf+MuBPDE" +
       "UUBhDwXAvjkCuFwSXD7C8vzFWA5vlhxRP1pQp4h6oLn2weEH5HKWn7hAlJ8u" +
       "qk9E0CNqoIOARgSytzbVkHG1Y4k+e8sqjCQ6uIWyFOqP34VQHywa3wXK6lCo" +
       "qzdHqPecbD+fKqpXj4C9cFtgxTeR4rPrGVmUjD9/gRz/XlF9NoKeVGLT0m7L" +
       "o6D4womofvYuRFV+fv5OUF45FNUrb74D/soFfV8qql+KoKuaGQKgewPgS477" +
       "pYoRdG/imtoJ3F++C7jfVTTWQfn0IdxPvxG4YKv1AjfS1UjXXhf1Vy7o+6dF" +
       "9asR9DZz/6HQlG9V8E+dIP61u0D8aNFY7CCfPUT82Tdfwb97Qd/vFdVvgwhb" +
       "fCE9tOXbKfmq4rqWLjsnqP/l3Zp1A5RfOkT9C39GEaDUVEn6ny4QwteK6t+B" +
       "DLX06fOa/kcnmP/objF/PyivHWJ+7c3BfOlsZvvM6c0BJJ1OBFK/+PDqZXK0" +
       "U/yPC6TxraL6Bohw6zLp7U/GhSTA9qsHwLFKHufE8t/vViwtUP7FoVj++Zsj" +
       "lsMd9tgKXi2oLkF3xn2ppP022CH3uIsbWqZj3A7vn9wtXhiU3z/E+2//TMzg" +
       "ey9+wSkzCifi9cOLNBjAbBwqtxTGgxcI6kZRXY2g5/aCuojXWcFduv8uBPdQ" +
       "0Vi8QvzHQ8H9+zcquC+/Xsz4wpH0bpx2oqM4sLegJy8QzNNF9dixBR2mZuU1" +
       "4HOCePyNCCKLoMdue1+wuPz0xC2XlfcXbNUvvHr9/re9Ovvd8src8SXYB2jo" +
       "/lVsWafvqpx6vuIF+sos5fTA/uaKVyJ7PoKeutCiIui+8rdY/KWb+0HfA3bQ" +
       "OwyKoCvKcZp+RF85FPxpesC3/D1NdxBB107oAKv9w2mSWgTdA0iKx7p3pNX6" +
       "nRB0lTAKZDU6Hfn3Es72DvXEaZMsQ8Aj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("r6fA4yGnL+oV7/nlHfSjd/J4fwv9JfWLr46YH/5m66f3FwVVS87zgsv9NHR1" +
       "f2exZFq81z97R25HvK6Q7/72Qz//wPNHZxAP7Rd84h6n1vaO29/Kw20vKu/R" +
       "5f/gbb/wfT/z6h+UV3P+P1DO7YMcMAAA");
}
