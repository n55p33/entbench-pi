package org.apache.batik.swing.svg;
public class SVGUserAgentGUIAdapter extends org.apache.batik.swing.svg.SVGUserAgentAdapter {
    public java.awt.Component parentComponent;
    public SVGUserAgentGUIAdapter(java.awt.Component parentComponent) { super(
                                                                          );
                                                                        this.
                                                                          parentComponent =
                                                                          parentComponent;
    }
    public void displayError(java.lang.String message) { javax.swing.JOptionPane pane =
                                                           new javax.swing.JOptionPane(
                                                           message,
                                                           javax.swing.JOptionPane.
                                                             ERROR_MESSAGE);
                                                         javax.swing.JDialog dialog =
                                                           pane.
                                                           createDialog(
                                                             parentComponent,
                                                             "ERROR");
                                                         dialog.
                                                           setModal(
                                                             false);
                                                         dialog.
                                                           setVisible(
                                                             true);
    }
    public void displayError(java.lang.Exception ex) {
        org.apache.batik.util.gui.JErrorPane pane =
          new org.apache.batik.util.gui.JErrorPane(
          ex,
          javax.swing.JOptionPane.
            ERROR_MESSAGE);
        javax.swing.JDialog dialog =
          pane.
          createDialog(
            parentComponent,
            "ERROR");
        dialog.
          setModal(
            false);
        dialog.
          setVisible(
            true);
    }
    public void displayMessage(java.lang.String message) {
        
    }
    public void showAlert(java.lang.String message) {
        java.lang.String str =
          "Script alert:\n" +
        message;
        javax.swing.JOptionPane.
          showMessageDialog(
            parentComponent,
            str);
    }
    public java.lang.String showPrompt(java.lang.String message) {
        java.lang.String str =
          "Script prompt:\n" +
        message;
        return javax.swing.JOptionPane.
          showInputDialog(
            parentComponent,
            str);
    }
    public java.lang.String showPrompt(java.lang.String message,
                                       java.lang.String defaultValue) {
        java.lang.String str =
          "Script prompt:\n" +
        message;
        return (java.lang.String)
                 javax.swing.JOptionPane.
                 showInputDialog(
                   parentComponent,
                   str,
                   null,
                   javax.swing.JOptionPane.
                     PLAIN_MESSAGE,
                   null,
                   null,
                   defaultValue);
    }
    public boolean showConfirm(java.lang.String message) {
        java.lang.String str =
          "Script confirm:\n" +
        message;
        return javax.swing.JOptionPane.
          showConfirmDialog(
            parentComponent,
            str,
            "Confirm",
            javax.swing.JOptionPane.
              YES_NO_OPTION) ==
          javax.swing.JOptionPane.
            YES_OPTION;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze2wUxxmfO7/fD54xYMAYKvO4C2kIoiY0tmODyRkcDJYw" +
       "Dcfc7tx58d7usjtnn01pEqQEGrWIEgKkSmj/cEqKIKSPqE3bIFdRm5CklSCk" +
       "CY0CVVuptClqaNS0atqm38zu3T7u4VgqPWnn9ma+b2a+b37fa+7MDVRk6KiR" +
       "KDRARzViBDoV2ot1g4gdMjaMrdAXFo4X4A93Xt+0xo+KB1D1IDZ6BGyQLonI" +
       "ojGA5kmKQbEiEGMTISLj6NWJQfRhTCVVGUAzJKM7rsmSINEeVSSMoB/rIVSH" +
       "KdWlSIKSbmsCiuaFYCdBvpNgm3e4NYQqBVUbtclnO8g7HCOMMm6vZVBUG9qN" +
       "h3EwQSU5GJIM2prU0TJNlUdjskoDJEkDu+VVlgo2hlZlqKDp+ZqPPj48WMtV" +
       "MA0rikq5eMYWYqjyMBFDqMbu7ZRJ3NiDvoQKQqjCQUxRcyi1aBAWDcKiKWlt" +
       "Kth9FVES8Q6Vi0NTMxVrAtsQRQvdk2hYx3Frml6+Z5ihlFqyc2aQdkFaWlPK" +
       "DBGfWBY8enxn7XcLUM0AqpGUPrYdATZBYZEBUCiJR4hutIkiEQdQnQKH3Ud0" +
       "CcvSmHXS9YYUUzBNwPGn1MI6ExrR+Zq2ruAcQTY9IVBVT4sX5YCyfhVFZRwD" +
       "WWfaspoSdrF+ELBcgo3pUQy4s1gKhyRFpGi+lyMtY/N9QACsJXFCB9X0UoUK" +
       "hg5Ub0JExkos2AfQU2JAWqQCAHWKGnJOynStYWEIx0iYIdJD12sOAVUZVwRj" +
       "oWiGl4zPBKfU4Dklx/nc2LT20F5lg+JHPtizSASZ7b8CmBo9TFtIlOgE7MBk" +
       "rFwaOoZnvnTQjxAQz/AQmzQ/+OLNe5Y3Trxq0szJQrM5spsINCyMR6ovzu1o" +
       "WVPAtlGqqYbEDt8lObeyXmukNamBh5mZnpENBlKDE1t+vv2h0+R9PyrvRsWC" +
       "KifigKM6QY1rkkz09UQhOqZE7EZlRBE7+Hg3KoH3kKQQs3dzNGoQ2o0KZd5V" +
       "rPLfoKIoTMFUVA7vkhJVU+8apoP8PakhhErgQZXwNCPzw78pEoODapwEsYAV" +
       "SVGDvbrK5DeC4HEioNvBYARQPxQ01IQOEAyqeiyIAQeDJDUwAggKGsMApv71" +
       "28AftsWAdf227jYRa4CpAEOb9n9aJ8nknTbi88FRzPU6AhlsaIMqi0QPC0cT" +
       "7Z03nwu/boKMGYalKYpWwtIBc+kAXzrAlw7A0oHsSyOfj684nW3BPHg4tiFw" +
       "AOCBK1v6Hti462BTASBOGykEnTPSJlck6rC9RMq1h4Vz9VVjC6+ufNmPCkOo" +
       "Hgs0gWUWWNr0GLgsYciy6soIxCg7VCxwhAoW43RVICJ4qlwhw5qlVB0mOuun" +
       "aLpjhlQgYyYbzB1Gsu4fTZwYebj/wdv9yO+ODmzJInBsjL2X+fS07272eoVs" +
       "89YcuP7RuWP7VNs/uMJNKkpmcDIZmryY8KonLCxdgF8Iv7Svmau9DPw3xWBv" +
       "4BobvWu43E9rypUzWUpB4Kiqx7HMhlI6LqeDujpi93Cw1vH36QCLCmaPC+FZ" +
       "Yhko/2ajMzXWzjLBzXDmkYKHirv7tKff+eUfP8vVnYoqNY50oI/QVocnY5PV" +
       "c59VZ8N2q04I0L13ovfxJ24c2MExCxSLsi3YzNoO8GBwhKDmR17dc+Xa1fHL" +
       "fhvnFEJ5IgIZUTItJOtH5XmEhNWW2PsBTyiDl2Coad6mAD6lqIQjMmGG9a+a" +
       "xStf+POhWhMHMvSkYLR88gns/tva0UOv7/x7I5/GJ7BIbOvMJjPd+zR75jZd" +
       "x6NsH8mHL8178hX8NAQKcM6GNEa4v/VZts42NRuiLufEIzTAVKYqYGP8PFdx" +
       "gtt5eyfTBWdDfGwNaxYbTrtwm54jmQoLhy9/UNX/wfmbXBB3NuaEQQ/WWk3k" +
       "sWZJEqaf5fVbG7AxCHR3Tmz6Qq088THMOAAzCuCXjc06+M+kCzQWdVHJr3/6" +
       "8sxdFwuQvwuVyyoWuzC3P1QGwCfGILjepPb5e8xzHymFppaLijKEz+hgup+f" +
       "/VQ74xrl5zD2w1nfX3vq5FUOQM2cY07a4c51OVye09s2f/rN1W+d+tqxETMr" +
       "aMnt6Dx8s/+5WY7s/+0/MlTOXVyWjMXDPxA881RDx7r3Ob/taxh3czIzgoG/" +
       "tnnvOB3/m7+p+Gd+VDKAagUrh+7HcoJZ8ADkjUYqsYY82zXuzgHNhKc17Uvn" +
       "ev2cY1mvl7MjJ7wzavZelc2xLbae1LvLsfkQf7mPs3yGNcsyPUYuboA3uCDC" +
       "oqhlWKz7LtNZsvZzrAmZgLg7G/6S2dbln2JvvuT0VDbAELOieblSWp6Oj+8/" +
       "elLc/MxKE2L17jSxE6qgs7/69xuBE7+5kCUjKaOqtkImw0R2rFnClnSBuodn" +
       "+zZC3qs+8rsXm2PtU0kgWF/jJCkC+z0fhFia2068W3ll/58atq4b3DWFXGC+" +
       "R53eKb/dc+bC+iXCET8vbUzoZpREbqZWN2DLdQI1nLLVBdtFbtguh2eFBYAV" +
       "2eNxPszmYvU4fU+sqOWejhlnwCzQ+EpCnkgRY81OiipFydBkPNqp61Bw5nVl" +
       "vboUh0Rg2Cqegvvqrw09df2siU+v3/IQk4NHH/skcOioiVWzHF2UURE6ecyS" +
       "lO+11lTTJ/DxwfMf9jBBWIdZktR3WHXRgnRhxBy6jhbm2xZfousP5/b9+Nl9" +
       "B/yWYvopKhxWJdF2BOE8juBTBCLW0aHx/gE3VJbCs9o679VTh0ou1vxQmWZD" +
       "pTMpEI0ZFV9sbx60PMiaYQ9aWJ9sq2nkVqkpAE+7JWv71NWUizW7mthPkc/6" +
       "WB59fIU1j1BUbemjB/IcHCMejTx6qzTSAk+3JVb31DWSi3UyjRzPo5EnWXME" +
       "Ig9kbSNtYInUo4zHb4Ey6tnYXHjutyS6f+rKyMU6mTLG8yjjW6z5BkXlTBlQ" +
       "MULCyRltbXzzVmpjuyXS9qlrIxerR1g/34ifC2Wr5Dt5VPI91pzJp5Kzt0Al" +
       "09hYIzyiJZc4dZXkYp0MIOfzaGOCNS9SVMG0AUl3VNLj7jselnb1JSIG9QTS" +
       "O3p3CQebe39vRt3bsjCYdDOeDX61/+3db/D8qZQlbOmsxZGsQWLnuFmoZU3c" +
       "1K3keFcpKomoqkywkhFVdDTdvQdz+Xu/XPOTw/UFXZBJdqPShCLtSZBu0Z1N" +
       "lRiJiGNT9i0w73DuiAV6inxLU0Uax8uP/hd4SUL1nv2KjhWQszP+GTBvs4Xn" +
       "TtaUzjq57W2eKKdvnCtB09GELDtLHMd7saaTqMTlqjQLHo1/XaKoIfcNIkUF" +
       "0PL9XzTp34I9Z6enqIh/O6nfgezQSw10/NtJ9y7Ypk1HUbH54iS5CnsBEvZ6" +
       "TUvlE4FPeflpqTXpc1dB6eOcMdlxOgqnRa4klf/Lk0JgwvyfJyycO7lx096b" +
       "dz1j3m4JMh4bY7NUAO7Mi7Z03bAw52ypuYo3tHxc/XzZ4lSOWGdu2PYdcxy2" +
       "3QFmoTH0NHiufozm9A3QlfG1539xsPgSpMM7kA9DVrYjs75Oagko2HaEMu0L" +
       "aix+J9Xa8vXRdcujf3mX32CgjHsLL31YuHzqgTePzB5v9KOKblQE6S9J8sL/" +
       "3lFlCxGG9QFUJRmdSdgizCJh2WW81QzomJUXXC+WOqvSvexulKKmzLQ+80a5" +
       "XFZHiN6uJhTRMv8KuydVP7pKr4SmeRjsHocPu2B6DHYagNZwqEfTUmVCxRWN" +
       "W/1r2Xz2a5z7r/yVNR/+F/412fMBHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/wObLef7SSgAAA==");
}
