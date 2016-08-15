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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HMCx74hs2gywJphlBweKfOtzFR3nHu2/wT1ZKIPyD++s0lySd2do3HMJj5yu" +
       "r1h8+o5Xef6z7qJqIBISGUly1kKO9zJVIwmR76nGqIxU/nMCzpDF7xYoKoGW" +
       "r/+4ofMARS3z60Bet96dWqcoCni1KCrlv06571BUZctBpWW8OEW+C2sCEfY6" +
       "q+bQkn9FwsgT2AWOCkQLjlJNmYDQcVg563PXOpZnm67lWUd5tNqFdH4dnANj" +
       "ZtgMqPOndw7eeeVTDxpnZUHCMzNslGqAoHEit6qDVfOOlhurbEfH1bpHK9fk" +
       "YsZ1VneujeMLIoSfa1s8h0e93TpDvja7+elfHCp7GaJ9F/Jhihbuyq/Ls2oG" +
       "UsOucH6oQSXFT7XdHQ9Mb+lMvPc6P/mgvPOOVz4qXDyz55WjS2bh9Fvdj0qh" +
       "liRZfmC4bVoeIcKkFkG1ot6bhSXCKCKWXHFcx3CP2UUxt4tpzlqrl12iUNSW" +
       "dyNc4OoJTolTRNumZOS4yQTVdo/rnjpXYGVU1aNg9zhSzmGDPIzsUhIND6hq" +
       "7gaiaqXKCeDrXj7jnVz7cf7Kmif+BbKuwe8qGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "x9VAtwaNipYGkI4bSS9WlyxpRw0VnbteGlLIKF4TSss0Ox07UIUSMkpUccjJ" +
       "7HJcUbsYHHQUJsbh1oLUmzy2VtnVSi8F5XUFXCxCWIgmmoCy67LramVusey0" +
       "emO6JvuYyMkTEXOYtdNMS8gaHqONNVEVZv1VHPZgFpUpC3PqGDKps2ueqsxD" +
       "DdGWXdALcYKny95iQrTC6drTCLAqgFSaghOsPifCqdluJ/N53d50NrAsNRxW" +
       "LsEQphOMgE1YioMqG6zZYvuUtWyLE5DfhMaiMp5U6jWq1VK7EsG3LFiDEhRD" +
       "/UZEor6TKBCoRONWCeuPVLKCwiOatDalstioreSxJfv9HorW1901KKn8bIxg" +
       "LXNCwGq2x4zb6ISsYqm2GTVSDE6CRgVGrFT0NWtMVMjWouPWzBjhumio82u+" +
       "AhN+Y6qNBk6Dd1tDZdYjTDMLrKBCK0RcTtEqvKolmkNLUJef9CGhFngwHpMl" +
       "ldRifRHJQawI/SUxwelGv93DW7w/82hvPPRLMFJvlNF0LcycTaPWXvVVKuGD" +
       "uNWyJbzsLnVshfZWXgmBhnNqiEllbFTlbVI31xi6NMURAWqRMrScyoaNB1al" +
       "VC6pqddPNqPVnCIlNzRtdDGxTSPRPNww9NFyjFSQZN323Dh1lww45SmvC87d" +
       "RSKgJdBqIEZEqsNVs13XTUqI9FJF66TIEI4UhO2WYZRHVmpAk6bSSHpOOQFr" +
       "cN0roQvDbouCkHYYhGoHUyJUxU5zAI1xqWcqYz9C1y67WamKG9TtypJJB2Ro" +
       "N5QMvJ31gFk1oIobw6yowpjGe1WnObDqpDGxQJQTVnLFUeKpx6HzKihORyvP" +
       "bk6YCYGH5dQhxv6I9BqtKUGKdYkwTNQb0aFYTkWGnlO2xw9sZlatBoqNxTLc" +
       "WKZ6hTSYoFsdaIreK5cazqqxltDSEJosCBMWxH4c2fXGmDC4jrFWZoHGZ0Ch" +
       "o60eBkfWujeemzSot8ZGpe7pfLdHxK7Umw4lSS6NN3hfpCi+Bk/7Edt0Zs14" +
       "oqgwKFHjir8xlEXoNgYzFC9By1Ai9RQkFJxpGD3KcVQvTSr1SX09scN+aQ4R" +
       "nM/jk3K6XsQx74xDqzScz1dITZ3TyXwzsIeRN0IqOCF6TbrWrHszv01MFYw0" +
       "7XkEY149aAuMWmmTqYBIalNMer45TwVlM9tMvLbENBUkmZeZkdKu4ZLKmpse" +
       "hdI4TcRL2qjywkhVYdvQKF+H4oY8jpVWvxKgJD0bzlNOUe2Vu3J1R/F7G2Jd" +
       "DqiNrtuzNo9PF5DfkhIcJTFThtJB4pj9WatjMrWa3obKWn0x7RE+FYzluDqB" +
       "lsPBnBQXFRFCux2TZFNSm0eYR62H4sTQawLFo94MlOdUc93tt3yuJRhgsORp" +
       "hIAwtS0oVlAO+CgGe/gUjyio0e2BbLMfdWrN2aYlNQjel0udNTouMeawTlkV" +
       "rIPSdbnZSmJIUZsbySynQp+tt5CQq/p1Cc0Mb1W5mT1DRFYoL6jEHZQ3A05Z" +
       "dSdUkLaQdaNsEEgzGs0HWuhXmFo/RBuV+noYsEGtJpsNJCj1VbBUkgkp5Z00" +
       "WUqpmnTLEwVBA3TTLaWT5WjaW4y5aWuK8WGlUUM9uJKsjepAmo8CfdqFxVSo" +
       "IfEwS64tozHCg6C+Wpkyoo5o1tDCcc1p1LwuuWghTJuv+fSG6zRb3JKPqsvN" +
       "mAXbFIsnaNUM4NkmZjzTbsZ6x+DClBArDhXBYDyAph2a37RK2Q5gb/oarLkV" +
       "imXmyCbyIbNecpGxbtRSdMWs6CbdJyV7Ay06XCNlhnS8FNGaQ67oRAIdFk+9" +
       "FoEmE7fjkiMfLFVdg8XEfiWtlZt62Khpo5Xq4o4FdXDfXpdrCAo1pakaNr3R" +
       "qM61RyUcDvC2MamtSoqwcBpEHMwGMDbi8IXQndtMbzlpCepwhtQq/Jjzps6y" +
       "htojSUPC3orQqKrmYL35NJyxK55ztBjVdX04aCWeM5UonE17gU2uMJdqW2Ft" +
       "1RoaHGebka+0DQpSPKrTMBaTYAoNHT2a62yXdvuGDAV1s6w3KgOvtZ7LaEm3" +
       "DQr3UFJmGgTImJapRJsV2A1gl5QCLlKpmiv0x8QAHWuU0GCVkp3thGqNB5ez" +
       "Nc9xw7S6Grc2KYKM5n1YMRvEWpuXV6ZtiVNjiVeVoavTamdBLEjIDWuK2R/j" +
       "HbwzGlOEmlRwHpakJKyGXmqvfBuCLanXH2mbnlrlXGbg2gMxexOfcv3qRhgM" +
       "NRf0nbk3npBDCZJ7s0Zq9tMl2eLpNJBMuteqmSt0JlvyatzB9ZY/nqNzZ5ii" +
       "qoF2lpZRaiqdKNbrK3KGYfkrpPHq3uJvLw4sDm7Jspf3vEN4FW+v266H8uLR" +
       "g/Og4nPmOmfNR87jgPyN/L5rXX4Vb+OfeP8zz2ncJ6GdvXNMOQTOhq73U7a+" +
       "1u0jonYySW++9skDW9z9HZ6vfen9/3Lv4K3mO17FDcIDJ/Q8KfLT7PNfId+o" +
       "/uoOcMPBadsVt5LHmS4dP2M75+th5DuDYydt9x149v7cY49lD7TnWejqp/hX" +
       "P2Y7jIJtAFznrPhd1+l7d17EIXDLTA/3zcibyMOQSV7pwOOozKIhPLCxIHt9" +
       "9iB7NiKvwsZThY1XNW9nL0j2DuPuu+YhYs/V9H2qR4sDtPwifBcLQ99SolDX" +
       "cDOLCjXUfTrUi9uJYrynruOyp/PiF7Yuy4cQIyc4dhJ1PFpFOS6WwGX1D4Vv" +
       "f/3j6QvPbw+aFDnQQ6B0rb8SXPlvhvxW6tHr3KwdXjL/kPzpF7/7j8O37S+y" +
       "Ww7m45bcivPXm499Z9129OB/e0ny7GFMfODVxEQSAndcea+YX4zcc8XfGbZX" +
       "8Ornnjt/893PSX9dXK0dXJOf7QI3G5FtHz3HPlI/4/m6YRUWn92eanvF18dC" +
       "4P7rX3uGwA1ZWSj+m1ue3wqBe6/Nk4HWQf0o12+HwIWTXCFwuvg+SvfJEDh3" +
       "SBcCZ7aVoySfynTKSPLqp739Sbny9jaPc193NN3X/fwg2l1YzuyIl5NTx/H5" +
       "YAbveKUZPALpjxyLuuKfKvugGfF7wf3Cc0zvnS/VPrm9VFRtOU1zKTd3gZu2" +
       "95sHwPvQNaXtyzpDPfbybZ8/++h+/N62VfgQKo7o9sDVb+3aSy8s7tnSP7j7" +
       "997yO899szgk/x+P2gD7QiQAAA==");
}
