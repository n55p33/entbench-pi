package org.apache.batik.util.gui.xmleditor;
public class XMLTextEditor extends javax.swing.JEditorPane {
    protected javax.swing.undo.UndoManager undoManager;
    public XMLTextEditor() { super();
                             org.apache.batik.util.gui.xmleditor.XMLEditorKit kit =
                               new org.apache.batik.util.gui.xmleditor.XMLEditorKit(
                               );
                             setEditorKitForContentType(org.apache.batik.util.gui.xmleditor.XMLEditorKit.
                                                          XML_MIME_TYPE,
                                                        kit);
                             setContentType(org.apache.batik.util.gui.xmleditor.XMLEditorKit.
                                              XML_MIME_TYPE);
                             setBackground(
                               java.awt.Color.
                                 white);
                             undoManager =
                               new javax.swing.undo.UndoManager(
                                 );
                             javax.swing.event.UndoableEditListener undoableEditHandler =
                               new javax.swing.event.UndoableEditListener(
                               ) {
                                 public void undoableEditHappened(javax.swing.event.UndoableEditEvent e) {
                                     undoManager.
                                       addEdit(
                                         e.
                                           getEdit(
                                             ));
                                 }
                             };
                             getDocument(
                               ).addUndoableEditListener(
                                   undoableEditHandler);
    }
    public void setText(java.lang.String t) {
        super.
          setText(
            t);
        undoManager.
          discardAllEdits(
            );
    }
    public void undo() { try { undoManager.
                                 undo(
                                   ); }
                         catch (javax.swing.undo.CannotUndoException ex) {
                             
                         } }
    public void redo() { try { undoManager.
                                 redo(
                                   ); }
                         catch (javax.swing.undo.CannotRedoException ex) {
                             
                         } }
    public void gotoLine(int line) { javax.swing.text.Element element =
                                       getDocument(
                                         ).
                                       getDefaultRootElement(
                                         ).
                                       getElement(
                                         line);
                                     if (element ==
                                           null) {
                                         return;
                                     }
                                     int pos =
                                       element.
                                       getStartOffset(
                                         );
                                     setCaretPosition(
                                       pos);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aaewr11Wf9/L2LO8lbZaGZn8tJG7/47E9njHpEtsz42XG" +
       "M+OxPV6gfZ19xrN6Fo/tEroISERRqGhaAmoDH1JBq7SpgLIICkEI2qoVUlHF" +
       "JtFWCIlCqdR8oCAClDvj//5e0kaNsDTX1/eec+85557zu2fu9bPfhk5HIVQI" +
       "fGdtOH68o63inbmD7sTrQIt2ugzKS2GkqU1HiqIhaLui3P+Zi9998YPmpZPQ" +
       "mRn0Gsnz/FiKLd+LBC3ynaWmMtDFg1bS0dwohi4xc2kpwUlsOTBjRfHDDHT9" +
       "IdYYuszsiQADEWAgApyLANcPqADTjZqXuM2MQ/LiaAH9NHSCgc4ESiZeDN13" +
       "dJBACiV3dxg+1wCMcC77LQKlcuZVCN27r/tW56sU/nABfvKX33npt66DLs6g" +
       "i5Y3yMRRgBAxmGQG3eBqrqyFUV1VNXUG3expmjrQQktyrE0u9wy6JbIMT4qT" +
       "UNs3UtaYBFqYz3lguRuUTLcwUWI/3FdPtzRH3ft1WnckA+h624GuWw2prB0o" +
       "eMECgoW6pGh7LKdsy1Nj6J7jHPs6XqYBAWA962qx6e9PdcqTQAN0y3btHMkz" +
       "4EEcWp4BSE/7CZglhu58yUEzWweSYkuGdiWG7jhOx2+7ANX53BAZSwzdepws" +
       "Hwms0p3HVunQ+nybfcsT7/ba3slcZlVTnEz+c4Dp7mNMgqZroeYp2pbxhoeY" +
       "j0i3fe7xkxAEiG89Rryl+b2feuGRN939/Be2ND9yDRpOnmtKfEV5Rr7pK69v" +
       "Pli7LhPjXOBHVrb4RzTP3Z/f7Xl4FYDIu21/xKxzZ6/zeeEvpu/9pPatk9CF" +
       "DnRG8Z3EBX50s+K7geVoYUvztFCKNbUDndc8tZn3d6CzoM5YnrZt5XQ90uIO" +
       "dMrJm874+W9gIh0MkZnoLKhbnu7v1QMpNvP6KoAg6Cx4oBvA82Zo+8m/Y0iF" +
       "Td/VYEmRPMvzYT70M/0jWPNiGdjWhGXg9TYc+UkIXBD2QwOWgB+Y2m5HbgQj" +
       "seCV62iqBRwdnvSYIYglMv+1k3lb8P80zyrT91J64gRYitcfBwIHxFDbd1Qt" +
       "vKI8mTTIFz595Usn9wNj11IxhICpd7ZT7+RTb5cSTL2zP/XOkamhEyfyGV+b" +
       "ibClBstmAwAA0HjDg4N3dN/1+P3XAY8L0lPA5hkp/NII3TyAjE4OjArwW+j5" +
       "p9L3ie8pnoROHoXaTGzQdCFj5zOA3AfCy8dD7FrjXnzsm9997iOP+gfBdgS7" +
       "dzHgas4shu8/buDQVzQVoOLB8A/dK332yucevXwSOgWAAYBhLAHnBThz9/E5" +
       "jsTyw3u4mOlyGiis+6ErOVnXHphdiM3QTw9a8pW/Ka/fDGx8febcd4CntOvt" +
       "+XfW+5ogK1+79ZRs0Y5pkePuWwfBx/72L/+lnJt7D6IvHtr0Blr88CFYyAa7" +
       "mAPAzQc+MAw1DdD9w1P8hz787cd+IncAQPHAtSa8nJVNAAdgCYGZf/YLi7/7" +
       "+tee+erJA6eJwb6YyI6lrPaVzNqhCy+jJJjtjQfyAFhxQMhlXnN55Lm+aumW" +
       "JDta5qX/ffENyGf/7YlLWz9wQMueG73p+w9w0P66BvTeL73zP+7OhzmhZNva" +
       "gc0OyLZY+ZqDkethKK0zOVbv+6u7fuXz0scA6gKki6yNloMXlNsAyhcNzvV/" +
       "KC93jvUhWXFPdNj5j8bXofTjivLBr37nRvE7f/xCLu3R/OXwWvek4OGte2XF" +
       "vSsw/O3HI70tRSagqzzP/uQl5/kXwYgzMKICkCziQoA4qyOesUt9+uzf/+mf" +
       "3faur1wHnaSgC44vqZSUBxl0Hni3FpkArFbB2x/ZLm56DhSXclWhq5TfOsUd" +
       "+a9TQMAHXxpfqCz9OAjRO/6Lc+T3/+N/XmWEHFmusese45/Bz370zubbvpXz" +
       "H4R4xn336moUBqnaAW/pk+6/n7z/zJ+fhM7OoEvKbh4oSk6SBc4M5D7RXnII" +
       "csUj/UfzmO2m/fA+hL3+OLwcmvY4uBygP6hn1Fn9wjE8uSmz8hvBA++GGnwc" +
       "T05AeeXtOct9eXk5K350L3zPB6EfAyk1dTeCvwc+J8Dzv9mTDZc1bDflW5q7" +
       "mcG9+6lBALam6xNP9XuSBxKtbTp5K1A13/d2ohQkcjtZ/87ogGgLcllZyopH" +
       "tjOjL+lSP54VxOoEEPd0aQfbKWa/6WurdF1W/TEAS1GeQAMO3fIkJzccEYMQ" +
       "cZTLe2qIQF7gU5fnDrYn96U8HLLV29lmocdkJX5gWYG733QwGOODhPYD//TB" +
       "L//iA18HPtmFTi8zfwGueGhGNsly/J979sN3Xf/kNz6QoyxYI/FnXrzzkWxU" +
       "8eU0zgouK/g9Ve/MVB3kiQsjRXEvB0ZNzbV92VDkQ8sF+8dyN4GFH73l6/ZH" +
       "v/mpbXJ6PO6OEWuPP/nz39t54smTh14JHrgqKz/Ms30tyIW+cdfCIXTfy82S" +
       "c1D//Nyjf/ibjz62leqWowkuCd7fPvXX//Plnae+8cVr5FKnHP+HWNj4pte2" +
       "K1GnvvdhkCkxThVhNdY4GHzWQskjcE+ZrUYFOY77Nhe0yY6KlCrKJrIDdcFY" +
       "MeP1MKWMsjEml7UNVxork+JmNrAGdt8cCmzd9Qly4Qz6gT9C6KAuCeKoLyYI" +
       "xYxYp0NLHbtujZodqdP3rX7b3kRlHQynch2EjDB1VUFDBMVrVbyGFctKYbqm" +
       "Q7aHkJVia9EZNkKquRQW7JTtWbhQEce1aX9OTpzpelIJsWgpy0XH6i3ao0lx" +
       "ME5769i29H48qLDTdEwHARUNpkNpHZmKMhV6U4faEFSPEouyYJVoZIavRVIc" +
       "Vzt1rVtZGd2NTCzqzlCyFiu2OanVjM6I6W+IoTUokFVP5mtFUQjHa9lOK2ir" +
       "mOAmNiFotsfJncgyQ0KDyakTd0cjaZxO41Yy7zjjluxXexKzYMn+mmWEyWRc" +
       "kKdkXNFnlS4XoL7Gwwt/3J+zOBmFLbuKasGsVHGdRalnt+0pu3Gt5cBhxvyy" +
       "j4qNbosdoJY1D4mxRA6aXbEuUTPZTIPSpKgVVTpoo4Wwj5GhY0ZpSWDJAbbu" +
       "tFivTU8suVlL01CkurKKV3olC+OkQVLcUPzKFycDe8xhLawmG+aiNZpyFiEz" +
       "8Zqpd5s23Uqluk0NOBcRSrwNG6kUM0YETLYYN0RXFvgkdgbCXOgVywQ+lrk0" +
       "lYXGsIkNI2GsdAqmG7jjhbvxEDJemxgP06Tla3URkdtiiTI9JGo3BpHoNuYz" +
       "gybKNTsKJI6mFqpvz/B5UOK9oELWx814YDZlxKPNAaH06pI5TXy3GwsNn0Rq" +
       "bMtghF4jVYr0LJioFOVKKc/4ZYsUuk67kBjW1Fj4i9AwW/WYYiaV9dKkleJ8" +
       "o9Oyx6EwMyb6+hKZz8K+MKjzitYNGaaGpI1hUqkFXNHu28W60uzJkqO15gk/" +
       "mVUHjWaf3Vid1bQ4LMOl9aIUlvACTLfmLlUlZlQcM7PGQhzi8mKCLPtRgR6T" +
       "ocQObK5MteVKO0JQh5xErlTt1fvzoeskwnAqre2CVoYL/U0NrbhYOhPUIb5w" +
       "yiPE63fAqxyDOHTLXzFrVeoNSac3xEbCRKjMEXxp1sQ+UYiAW/RkO7IZksFG" +
       "ErAWHiDwvDCl6xTTa7BiH4EF0luU5FJTQvlSzxCaC6MOi2motKwhXBgglDJI" +
       "/KDjkjOpsnAHK2o4gwOZtBoc0VrLTosxahI3CCSVVUiqyxYVm2hX+11+SrJ4" +
       "tzMOyDU9m5DUpFGsTqsNvEGQIwuGGXyAb3QDXit2qo81tpF2U6q+xPt0o0m0" +
       "ymNkaKx8mBZqtKzRJW3OpJE3rVDmuLKw4kG92iUH7aRlrpxmveo0eirumy2j" +
       "35xwXYBZIkFE02IToFsTqVamy9aSAZDKkct6ZYqlI7mHdrjNerboqQ1rsC4K" +
       "BXGzmYyHg3U10YfVziDi/JYSFefieDxmQpac1iNNHXDV2J+iTcMTB6tS0F+M" +
       "K8WV2vWo+sLtBClSdUYmPu+aiScxs9Acp9Z0TYbUCJ83dI3fmLi+LMEeP1Ra" +
       "I7Upt2fzTs+ol1YmarpdjMDsCkybghQX2vVA1/n2rDxoTzZp0I0jJ9rMZ0RQ" +
       "LLTLTRmt+st2Z6VbYRWj+h5bjsQKoVNkC6/PNaTQErBKVQmanMo5pClw1daU" +
       "XpTShVRgF+58iChjjeRK0RDD8VZcNU1cNVrljY/1eXvplorImIjbHKFveig+" +
       "5ikRV+JGBe1qS3hJzcvsZhayjEEbSqupIeuO4Mhh15mLAT+P7Z7bGYFwBcIZ" +
       "aU3lwyZTWK/6TLNoR10O4acNQ+kIBrqM9TKvj7mVyk8Mo6rbFdOR1PmoQTmK" +
       "vVgrYr9moB1Dlt1Nu9hoUmKzqY3KHmGU8VHR9jl6OqCcOSw5Vqm2sOF2KR3p" +
       "C6I5YCVWdGpYfazimDUrYniCwTWMc1KvwzR6GOvxnQaz4RVHTli7iKe6JCQa" +
       "jJhirVYf4k2rz9RLYsdtKqq8apXqBboVo3Cor9lE1tu9clSSZuhkVpDLa5Re" +
       "SL7OzZtaeYSVy8ukGRfiuCCsPXhUZ8MFqWGUq/WlsVfotQO8PB0YjDrUtHI5" +
       "dn0vxGk6xQhrTtdDbMI2ukRPIzZEYFXDAjvmPRdWccTvNpeSKTmTNj7Eeka6" +
       "Eo2JMqRTr+LOyYIqRZUyT9FSY4EuLJMvyGljljQoc1pI2JLYl5NNF8MRVIm4" +
       "gFxpqLNyrLluoyJVNvqiqCVE0tD1BeuWa4WqFbdXxQnAJFLZTFa4rMNKEMkl" +
       "GJ7q2gCAISUZDN9eEcXYawfYJIIpdZPg9WbCJxtu4NH9hmOWdbWqDnXDLDt8" +
       "WrUstz2i2YTC7WoUOO6UsNmV1BqHs7Xl8jqv9e3aiBWLaEptjMaGm4yJwojT" +
       "bKHgr6WaFuNVasLPvTqqdztqqdvRl326o8I+uk5L+ERxwUK76YLo9jylkwzU" +
       "dZsqjzYMGQtDccFUU3ZqFIJhwPRKow4+qa+psE2HMtmNeGzS7DQ663XN5KLS" +
       "gLZVQVyP5xRSL8VjVJdJGA9rzqwvp6v1UmhuisCgoeq5pu4xsC3wKxnYl5pg" +
       "M6xZNLQCVajxBogLhK7y5nJiAURABKEsWnN73rISdzDuBS1t0JgbtZRoh2o1" +
       "4eE1hpU1TmYWWtGn2VgszLUWATNpxxHNKc8sa+NJPIeDskO0UBYLFyw95vqb" +
       "oAx35bSkaJpXQnXG7DBwsdmG+WS9Ql15gU8cNCbDuSqNetoEgRcbVWAqXLJp" +
       "S82lQk+TCpGgMKX1kJkS1OdSqTTB1DXXEsBW0ZmwpUqX6BKaQ02jimY1QyOM" +
       "OqHomu1qZyENjCQwNgwqDESexSppQeecVWUWFDy+J9gFe06U0z7nmWRCuxV/" +
       "jbHJWqpqSr/mjAubkTj367DBpLyi1+akWqoTWGM4DKNBjbHKXLk7m9aHjGAH" +
       "LrIigeAAd5BNix02KnRpqFWNRVvoiYUO10jqsx7XILrNSqnYKqf4MKlN4g5d" +
       "rjRqSJ2fYOsJNW4pFZy2Z2iCmsO+VJyhRKcQBHPDd/miIRCxiRJIqdCcLtLN" +
       "gvfqRJvVp1G5Nq3TQ7TrGfiqIDaHoWHVgqpAw3qjJ06tUpNCy3J32i6mbZnz" +
       "GSScCLrcKaIloVxZ9j0nqffVJsI3ZzVN02QNgc0CtemSdoejxHK33qDb1SI2" +
       "XDcCddyajxC11h5NHWsJsyi72cg0UugskyJDDHEcoTaDBuIu2sjYZcei7i6H" +
       "7eXIVKeSOA+NIioXcU6OE2w6Mpujcd0x6lOdn0uEXV4P2akSLMyNsFBQbdpe" +
       "c3hCwKlDGkQS4ZvUimC3zGhYccSUsHVJ6LHOhOWwtjUMChtlgRixR9pWKIVJ" +
       "MyqLzEbt2U6zMgjH1mTOVzaY0nCHMEmn+ojC7AJSoItTosYU1bWFtYlWkQm7" +
       "yyIrDIrUumEP00p1ViM9WvFQyeotsTDwEskHahFWVfKTnlvot6MGaU5rK3vu" +
       "FgkvqS8JRmESUloLw15DjrkxlySiJBRKCxydVUkrhsOoUlVFHx+TuqOstZLM" +
       "lLF1pOiUqhbHynhol9Ziy2s4+Jju02VuTFHFOEFkFDXFSRUt+ONAZqUiYqVp" +
       "1di0dVQlVNKNKEXuYkvCjRF0UV3LaFnB2RUf4LFurgaFZjpKBZktoSpu9uyp" +
       "VI1itaKv++aM7k+qVUz0VvE04RcrqlbYjGsBzdUSdKHxa1PlyvqkVZGloVJ3" +
       "l9WR6thMt2s6tUQOlv3YZNFNY9VSpyDGKmScWj4tzpHKqFew6jK7sNglxbqq" +
       "Kgf9Gu4QI1ss0ChRYNMpUvK6lqz2LJ5dMCOuyWlquY+li3BoJtRcIWeKzZtI" +
       "fcREbK8e+wWykeLWmPXJZctMhWXSbgtDrJOIsDNRZRxjCgYlSuza9EGa9Na3" +
       "Zq+Hxit7Q785P4zYvx8DL+ZZh/AK3ky3XfdlxRv2T4Xyz5njdyqHD2APTuWg" +
       "7G37rpe69srftJ95/5NPq9zHkZO7p5lyDJ2P/eDNjrbUnGMHfA+99KlCL7/1" +
       "Ozhl+/z7//XO4dvMd72Cu4N7jsl5fMhP9J79YuuNyi+dhK7bP3O76j7yKNPD" +
       "R0/aLoRanITe8Mh5211Hz+/vAw+1a1nq2uf31z5sy71gu/bHDotPHBAIOcGj" +
       "L3Oa/J6sWMXQ2UiLs9uenOgdhzxFiqFTS99SD1xo/f0ONw7PkTckR3W+DTy9" +
       "XZ17r47Oh1X6hZfpeyIrHgMqZaeIWf19B3o9/mroNdzVa/jq6/XUy/T9alZ8" +
       "COgValfp9eQPq9f94Lmyq9eVV9VHr+Vt11lenPM88zL6fiIrfi2Gzhl+7Gf3" +
       "x8d0/vVXojNw/xuPXHZmNzd3XPUfi+3/ApRPP33x3O1Pj/4mv+/bv7s/z0Dn" +
       "9MRxDh+0H6qfCUJNt3LRz2+P3YP86zMx9MAPcBcLQHK/nov/3Jb9t2PodS/J" +
       "DkwJysPkvxtDt16TPAsI8HWY9g9i6NJx2hg6nX8fpvujGLpwQBdDZ7aVwyR/" +
       "AiQBJFn1+WDvbPz2w2f63a3decnTVieObij7S3rL91vSQ3vQA0d2jvxPNXso" +
       "n2z/VnNFee7pLvvuF6of395/Ko602WSjnGOgs9ur2P2d4r6XHG1vrDPtB1+8" +
       "6TPn37C3q920FfggNg7Jds+1LxtJN4jz68HN79/+O2/5jae/lp/Y/x9uyPaU" +
       "7SQAAA==");
}
