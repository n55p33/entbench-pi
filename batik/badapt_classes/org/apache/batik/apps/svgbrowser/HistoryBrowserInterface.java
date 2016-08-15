package org.apache.batik.apps.svgbrowser;
public class HistoryBrowserInterface {
    private static final java.lang.String ATTRIBUTE_ADDED_COMMAND = "Attribute added: ";
    private static final java.lang.String ATTRIBUTE_REMOVED_COMMAND = "Attribute removed: ";
    private static final java.lang.String ATTRIBUTE_MODIFIED_COMMAND = "Attribute modified: ";
    private static final java.lang.String NODE_INSERTED_COMMAND = "Node inserted: ";
    private static final java.lang.String NODE_REMOVED_COMMAND = "Node removed: ";
    private static final java.lang.String CHAR_DATA_MODIFIED_COMMAND = "Node value changed: ";
    private static final java.lang.String OUTER_EDIT_COMMAND = "Document changed outside DOM Viewer";
    private static final java.lang.String COMPOUND_TREE_NODE_DROP = "Node moved";
    private static final java.lang.String REMOVE_SELECTED_NODES = "Nodes removed";
    protected org.apache.batik.apps.svgbrowser.HistoryBrowser historyBrowser;
    protected org.apache.batik.apps.svgbrowser.AbstractCompoundCommand currentCompoundCommand;
    public HistoryBrowserInterface(org.apache.batik.apps.svgbrowser.HistoryBrowser.CommandController commandController) {
        super(
          );
        historyBrowser =
          new org.apache.batik.apps.svgbrowser.HistoryBrowser(
            commandController);
    }
    public void setCommmandController(org.apache.batik.apps.svgbrowser.HistoryBrowser.CommandController newCommandController) {
        historyBrowser.
          setCommandController(
            newCommandController);
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createCompoundUpdateCommand(java.lang.String commandName) {
        org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand cmd =
          new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          commandName);
        return cmd;
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createNodeChangedCommand(org.w3c.dom.Node node) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          getNodeChangedCommandName(
            node));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createNodesDroppedCommand(java.util.ArrayList nodes) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          COMPOUND_TREE_NODE_DROP);
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createRemoveSelectedTreeNodesCommand(java.util.ArrayList nodes) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          REMOVE_SELECTED_NODES);
    }
    public void performCompoundUpdateCommand(org.apache.batik.apps.svgbrowser.UndoableCommand command) {
        historyBrowser.
          addCommand(
            command);
    }
    public static class CompoundUpdateCommand extends org.apache.batik.apps.svgbrowser.AbstractCompoundCommand {
        public CompoundUpdateCommand(java.lang.String commandName) {
            super(
              );
            setName(
              commandName);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "f7C2GSodAAA=");
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowser getHistoryBrowser() {
        return historyBrowser;
    }
    public void nodeInserted(org.w3c.dom.Node newParent,
                             org.w3c.dom.Node newSibling,
                             org.w3c.dom.Node contextNode) {
        historyBrowser.
          addCommand(
            createNodeInsertedCommand(
              newParent,
              newSibling,
              contextNode));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeInsertedCommand createNodeInsertedCommand(org.w3c.dom.Node newParent,
                                                                                                                  org.w3c.dom.Node newSibling,
                                                                                                                  org.w3c.dom.Node contextNode) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeInsertedCommand(
          NODE_INSERTED_COMMAND +
          getBracketedNodeName(
            contextNode),
          newParent,
          newSibling,
          contextNode);
    }
    public static class NodeInsertedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node newSibling;
        protected org.w3c.dom.Node newParent;
        protected org.w3c.dom.Node contextNode;
        public NodeInsertedCommand(java.lang.String commandName,
                                   org.w3c.dom.Node parent,
                                   org.w3c.dom.Node sibling,
                                   org.w3c.dom.Node contextNode) {
            super(
              );
            setName(
              commandName);
            this.
              newParent =
              parent;
            this.
              contextNode =
              contextNode;
            this.
              newSibling =
              sibling;
        }
        public void execute() {  }
        public void undo() { newParent.removeChild(
                                         contextNode);
        }
        public void redo() { if (newSibling !=
                                   null) {
                                 newParent.
                                   insertBefore(
                                     contextNode,
                                     newSibling);
                             }
                             else {
                                 newParent.
                                   appendChild(
                                     contextNode);
                             } }
        public boolean shouldExecute() { if (newParent ==
                                               null ||
                                               contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ZfWwUxxWfO3/b+BMMxIABc1DxkbuQhDaRKQk4NpiezQmD" +
           "q5rCMbc3Zy/e21125+yzKUmIVOFUCqUUCI0If7REJIiEKG3UVg2RK9QkNGml" +
           "JLRpUgFVi1RoShtUlTalNH0zs3f7cb6jrppa2tm9mffevPfmze+9GZ+6hkpM" +
           "AzUTlQbpiE7MYLtKI9gwSbxNwaa5Cfqi0pNF+C/brnTf70elfahmAJtdEjZJ" +
           "h0yUuNmH5siqSbEqEbObkDjjiBjEJMYQprKm9qFG2exM6oosybRLixNG0IuN" +
           "MKrHlBpyLEVJpyWAojlh0CTENQmt9g63htEUSdNHbPKZDvI2xwijTNpzmRTV" +
           "hXfgIRxKUVkJhWWTtqYNtFTXlJF+RaNBkqbBHcoKywXrwytyXNDyYu2Nm/sH" +
           "6rgLpmJV1Sg3z9xITE0ZIvEwqrV72xWSNHeih1FRGFU5iCkKhDOThmDSEEya" +
           "sdamAu2riZpKtmncHJqRVKpLTCGK5ruF6NjASUtMhOsMEsqpZTtnBmvnZa0V" +
           "VuaYeGhp6OCT2+peKkK1fahWVnuYOhIoQWGSPnAoScaIYa6Ox0m8D9WrsNg9" +
           "xJCxIo9aK91gyv0qpilY/oxbWGdKJwaf0/YVrCPYZqQkqhlZ8xI8oKxfJQkF" +
           "94Ot021bhYUdrB8MrJRBMSOBIe4sluJBWY1TNNfLkbUx8AUgANayJKEDWnaq" +
           "YhVDB2oQIaJgtT/UA6Gn9gNpiQYBaFDUlFco87WOpUHcT6IsIj10ETEEVBXc" +
           "EYyFokYvGZcEq9TkWSXH+lzrXrlvl7pO9SMf6BwnksL0rwKmZg/TRpIgBoF9" +
           "IBinLAkfxtPPjPkRAuJGD7Gg+f5Xrj+4rHn8DUEzawKaDbEdRKJR6Xis5u3Z" +
           "bYvvL2JqlOuaKbPFd1nOd1nEGmlN64Aw07MS2WAwMzi+8bUvPXqSfOhHlZ2o" +
           "VNKUVBLiqF7SkrqsEGMtUYmBKYl3ogqixtv4eCcqg++wrBLRuyGRMAntRMUK" +
           "7yrV+G9wUQJEMBdVwresJrTMt47pAP9O6wihBnjQDHg+QOKPvykaDA1oSRLC" +
           "ElZlVQtFDI3Zb4YAcWLg24FQDKJ+MGRqKQNCMKQZ/SEMcTBArAGs62bIHOqP" +
           "GdowoGFoHaCOZoysET87M8EbZEGn/3+nSzPrpw77fLAws72woADVOk2JEyMq" +
           "HUytab/+QvRNEXJsm1h+oygMGgSFBkGuQZBpELQ1CObRINANwAxADbsK4EdL" +
           "JrEaRz4fV2Ya005ECKzvICAFyJiyuGfr+u1jLUUQmvpwMSwOI21xpaw2G04y" +
           "OSAqnW6oHp1/cflZPyoOowYs0RRWWAZabfQDtkmD1vafEoNkZueUeY6cwpKh" +
           "oUkkDpCWL7dYUsq1IWKwfoqmOSRkMh7b26H8+WZC/dH4keE9vY/c5Ud+dxph" +
           "U5YAAjL2CAP/LMgHvPAxkdzavVdunD68W7OBxJWXMuk0h5PZ0OINF697otKS" +
           "efjl6JndAe72CgB6imFjAoY2e+dw4VRrBvOZLeVgcEIzklhhQxkfV9IBCCa7" +
           "h8dxPf+eBmFRyzZuCzx/snYyf7PR6TprZ4i4Z3HmsYLnlM/36E//6udX7+Hu" +
           "zqSfWkfd0ENoqwPymLAGDm71dthuMggBugtHIt88dG3vFh6zQLFgogkDrIUd" +
           "wPI3uPmrb+x8/9LF4+f9dpxTyPmpGJRO6ayR5cymmgJGwmyLbH0AMhXAERY1" +
           "gc0qxKeckHFMIWxj/bN24fKX/7ivTsSBAj2ZMFp2ewF2/x1r0KNvbvtbMxfj" +
           "k1jKtn1mk4k8MNWWvNow8AjTI73nnTnfeh0/DRkFUNyURwkH5mLug2Ju+Uyo" +
           "4Dgny85BkZ2zAwyJhu+RgnEtGWTgwvrv4w1f8BWc8C7e3sucxeUiPtbKmoWm" +
           "c+O496ajLItK+89/VN370avXuaXuus4ZJ11YbxWhyZpFaRA/wwts67A5AHT3" +
           "jnd/uU4ZvwkS+0CiBNBubjAAe9OuqLKoS8o++PHZ6dvfLkL+DlSpaDjegfkG" +
           "RRWwM4g5ALCd1h94UATGMAuVOm4qyjE+p4MtztyJl709qVO+UKM/mPG9lSeO" +
           "XeQRqgsZszh/EcskLkTmpwMbFE6++7lfnPjG4WFRXyzOj4Qevpn/2KDEHvvt" +
           "33NczjFwgtrHw98XOnW0qW3Vh5zfBiPGHUjnZj8AdJv37pPJv/pbSn/iR2V9" +
           "qE6yqvFerKTYFu+DCtTMlOhQsbvG3dWkKJ1as2A72wuEjmm9MGhnXfhm1Oy7" +
           "2oN8DRnku2SBwiUv8vkQ/+jiLJ/h7RLW3JkBmgrd0ChoSeIerKkvIJaiSpUM" +
           "98gAUWp/dttN5QJWsqZbCHsgb0yuddswH57L1mSX89jQK2xgTSRX1XzcYCGo" +
           "CtkSonQiTb84SU0XwHPVmutqHk23FtQ0HzdFVZI4dLnAzKHrtgK6pideYT/7" +
           "DEI+Mfmpzl7j4ow6rvLXmU/sXY4YlM3Jd0Lhp6vjjx08Ft/wzHKxzxvcVX87" +
           "HGqf/+Wtt4JHfnNugpKy1Dph2hMWs/lcsNLFT272Hr1Qc+B3Pwz0r5lMjcf6" +
           "mm9TxbHfc8GCJfmRyqvK64/9oWnTqoHtkyjX5np86RX5XNepc2sXSQf8/Jgq" +
           "wCPneOtmanVDRqVB4DyubnIBxwJ3yTQHnhvW6t/whrIdejyOl+YWIvlYC6Td" +
           "4QJjI6yBarGMpIkEh2+zYLqIGHISqrEh66gb2t1wafDoledF+Hlzg4eYjB38" +
           "2ifBfQdFKIrLgwU553cnj7hA4GrWCUd8An8+eP7FHmYD62BvyABt1il2XvYY" +
           "y5KmgeYXUotP0fH707t/9OzuvX7LJzsoKh7S5LgNAebt4Kpwsmcd7TrvV93B" +
           "0ATPx9aKfjz5YMjHWmDBnygw9nXWjIH1KTXOz+8P2y54/NN0wS3LjluTd0E+" +
           "1gJmPlVg7ChrDoELDJLjgsOfggvYVQgKQE1QImSK96RckJe1gJknCow9x5pv" +
           "U1QNFW5KibdngcFxCcBAvycVM6lnk98d2S6NBSKXBSLcMQGDoGt8NvRE73s7" +
           "3uLoXc7SRRYzHakC0orj6FnHmkeEY3c5vvcAesU0TSFYzdrjy95cTHPrIKZ/" +
           "6PHaV/Y3FHVAHutE5SlV3pkinXE3lpeZqZhDKfs+0UZ2SyMGQhT5lmSKdB4s" +
           "3/lfBEuaoqkTXOBkzmL3/be3QuCXmTkX1OJSVXrhWG35jGOb3+M5PnvxOQWW" +
           "KZFSFGd97Pgu1Q2SkLlTpohqWeevMxTNu52SUNbaP7hprwjmcYoaJ2SG7cle" +
           "Ttqz1snUSUtRCX876V6D2Ww6qILEh5PkHEVFQMI+f6r/565eDcFtQEm0GbBT" +
           "HNn5WqV97pIuGyCNtwsQRxW4wJWS+X8gMjGdEv+DiEqnj63v3nX9s8+ICxVJ" +
           "waOjTEoVRLK428nWQfPzSsvIKl23+GbNixULMxmxXihsQ9EsB160w0bT2YG2" +
           "yXPbYAaylw7vH1/56s/GSt+B5L8F+TCE9ZbcE1taT0EBuiWcu2OhZuTXIK2L" +
           "nxpZtSzx51/zM7G1w2fnp49K509sfffAzOPNflTViUog2ZM0P0o+NKJuJNKQ" +
           "0YeqZbM9DSqCFBkrLjioYdGP2e0H94vlzupsL7uOo6glt4jJvcSsVLRhYqzR" +
           "ILNagFJl97j+NWLtqMqUrnsY7B4HKr4kMIitBsRtNNyl65miyH+nznHku15Y" +
           "5J2c+wL/ZM3FfwP+WnwHnRwAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "iC/nHTWXjALWJEqetuIW+ApfdBd6c7nU6ku8w8z6jkuZtVWrjUoxU7ZtL1kM" +
           "aC1m2zkyYBnKJYy6k9D4uOMkE8xeGmquMcTZvunXlHJB9fERJ7LEokfNmyGJ" +
           "xpG2HLLO2hwMx+pUVshBTI3GekedTIb+asb6reHU6LTgAc/W9dWiTgg2lURT" +
           "N0r8ZMo2k1mAsibiEWVXoR2zM85zSmFdi8khnpuTIR6t3HEFjSccS0iamm8N" +
           "2q1RSWvolNrsDlWzyeF4wnsib2IB6mpzh/JNSyA6q8GYcuhho02V3KBVZpcY" +
           "N/IZtesxuLdy5kPfqpuhNedz43HAz6S26pS7jSEKOxKlU3kwlpOxFcy6Kmn3" +
           "J22uZ2E2J/DkjC9345xZbdYmrscqtbjTiEm7xlO1vJKEuRVApBlix4tJW6Q6" +
           "ES/nkNnYbfRm81VfX6nGvBqTVZuK5U5fb9WKXT+H5hfqbCS69SrjdgZ1huvW" +
           "SanoGUGnPpnlhywr0/piFFexkYKxfNKh8ObE4lczddyso3af5DuKP0RGWLlt" +
           "1RRgsf1ZnW81R0ZLsKuVSdcZEcKwTHrkMp/Dhzg+rk8FfJa0bH0WtucCvqoN" +
           "9Qk3JWBj7U5dIzQqTrfGMXK5Hlm6R+fciDLnCjIcOKRSt1s1sq5ZNKbLsd/r" +
           "LXv6AAs67WalrcByaeou4aJLWNXmCF/zEcU3F7g4oDqD8lTzSkFhvpiFIY12" +
           "VkY34KlFryXmrS54cOAmbLmIRbkKw6ETLGLWGlxdjMLedMXJXZUw5qg9ZoFJ" +
           "1Wlt1apwurvy8Dbjj2ZmnZoZBVtZabEfFqWGsFJgOHLr9CBI2gMGs/wBM6Iq" +
           "iTuG27Vo1O/gTF0cRyAa7LhDxi9WHKxX65YjTa1by36TUOB+l+qFic43sbzN" +
           "DegGbsyNcd9vNUkgf3GGCRNaQYutfpPqwEx7sKL6bIOh+nOEwxlhWMdcrO2V" +
           "0QVJdFe9tmhHdrtlE3yjO7cTDx9WK0wVX8zxtoUUYItb91wnqlRkGou8ChrZ" +
           "WHPc1dEOnjArYpT4/AKB++GAxacdz8yrsJ0oTFvhWnW9HfTndQen+/lGdzEg" +
           "WYyNsBhrLjyqiIt0x8X5wbooj9EZn8uV8Aa1DskG1ko6WhK0ZRcO8kt6NOqb" +
           "oRMxXNQl0Xzs8BHazhWTLoetrEnZJpw8IsjGvJfYXTuaebnBYDLB5vxC7jd9" +
           "3WzmQ17GbVafB9JImpWFyKFUe6TrTacxoSvibOSt8uSEimR7ZXa5gc6olQVa" +
           "JqrwZN5ARKKoS3gtnCFCaSTCICxXR6UZhi1ptIH1EJpRiLCHxbq45sOxGFjN" +
           "cnVS6dbjzmTKBHpOLfXmuS7Jtsq1iu1TnCQvjXLHEjGpgjaUelkzW0vMnqES" +
           "LEbF8cCth905LY0VASfXuqGq/ViXx8CSGw2+olbFuCfDUt1sDZL1PGisY8Sz" +
           "Zolc6Q3KQ8edF7XivECY3oy2DAYplHEEKQfitAITwRqY50SXxRzO2quol5g0" +
           "1m6albzoqwGjKPVA8QnSr1bFdiFsqeV1n24ptqI3XXIkRj2yEPRMdwHHVaRG" +
           "t4qwXBOdeJj0TKfdGXTLfDIoCYlpKp12ZCb0gshhjDrF8MEsrwi5VUxJgk60" +
           "GHISL5EFixZlaopUtHDocXVsic6ZloNKUQtF4rybo9hwEfoLJpaXen5J+Vbe" +
           "1It6lWEnk5C1oyq2HJKVgmUNLVlSc0hzoLdGbDIaRDpRMulAQTsBPErsYlOx" +
           "kmqprs/RNRYlHTWAB4qF++3JUIlCNyxGeblanwjVRkUqeIEQSyOt5y8o056Y" +
           "Atwt1sr8kiZ9Cq7WkDFbqOT4cBrw0yDwivNOPj9bxBM1mTstfoAhUeR75QpW" +
           "wohhYWmJSDAqzsNI5+BcQ6uz9WCxxDCp1g1WNGVzVRuGe8S8LIYALGm4aXAO" +
           "31xKiqy3gdlGTFEpYXRDzKu14ggbthksGHfN4ipZ4rBTZPy1n3SMSq62Gnfh" +
           "EcUgZq9dMzipO5X6g5Xizb21iuCCp9P60AQes2jhZRiuGLLVW7aLk9Zgmqy7" +
           "y2JfCh0LQakmToShXyiwwnrZihTfJaJaddq1JrnVpDBWS2u5rvXaxGhpzZdV" +
           "TOyEhYrT64SIs+AsRBug49oKLyersCW51HDWCuBmwx8yRlfte4uwXRAnOtXJ" +
           "8x6KAcQI8KVp1pi2ak1l1cx3kwpqs9XmwNIDlKtH2iishnofgZca3UHUyoCe" +
           "FDp63VRcMddQbU4iQR96SHZ4jXNGTK2qYKOJg4i+z5b6nYm3mi8ahKcsckkg" +
           "il5ElCp03uSm1dqyT6GxMuQG0/x0Lcwabbvh65xt9bXholrkRrlpRPTGZuCv" +
           "CB0ttPx+jliLrfGcLIq0ha0pwvUVquxoojQbIpUmTsKMbDpro7Is2lHZDemp" +
           "OUK86aw4M5hCR8zRYHEOl8s4V235SLQmqHgdh8J4Wq0Q7ZWMwBPfL3YI2WID" +
           "xaGSfNNRUZWZeIgheCzdGqIVlHDzfQGuF3rROueWDGYpyGUwdMN4QchCtd3o" +
           "yOYADDpVLiI1e2INVzbh68lyWrKcankwLU1ZyRFQb8r15SrSUVZRo2dJXd/k" +
           "rXFzsBrXi80kWFhkPY46hWTYJyw1nJSBrKpLitIy6RrwbEKGxqxRHorFfmdJ" +
           "lpM677YZh9RxFYXXM3pFtgmSW7m4Wi4rC9TPg+ihaRuS2IIJY60UpdmyXqii" +
           "mlyX+2KLIl1aiUalUkGwlhUVK7bdSWMkVjGrCku9SoswZ80yWg8TrO7nNQOd" +
           "hrNZUqJMRZpNR7bfy8lEJVfxkVp3HYTTCt1ZezalVrgSrbCYtPCLlBN5piBW" +
           "hm44rhXqOWzYi0GYIy/XpRmzJCZms24lSlSzppMlSeSp4bS7hqs9NCkVEZbN" +
           "RVyBXhrBEIAjnFc6Zs8YK5WG6jZtnG526KXidWVFCWfjvkL18XyfNDmqVh4I" +
           "ekcC5LrVsKNaXHLCUb7PtiYlSluIliK04oZQx8JEGDNlw9JrVRHlymydo6Z1" +
           "jhaYfrtpt/0qGw7wSsGrFALangoVbjCYrQleb+Rsd1luWYQJFp9ZQSiFoYBJ" +
           "3ig35Fqzteguk1pJGBI9l6TmSLlH8GNkVmgRY4wIfLzEGeOCA3ZHU7xgONJ8" +
           "NVeblOzBudEc5RKm3VeHJQPoINaLXgEx5Doe8PZKB6NS19cmDXYZUqEfNKbm" +
           "UJ/mux1uPHXVSbtQWra7iwLMlHpWGHf7kwk1b3Gttlir9JQg30c5nTaGjq2u" +
           "JpIUMvGQDUooN2IXfK+iOm60NIWZzXdQrl0RDAkE2+u8Z41AnDtoAN8oj8tN" +
           "dBKVVySNgzVTJ/Bxq8+QsFx2kVK5JDUF4Jm4mWsv6kOCtUqT1bhWccignTRY" +
           "P/L6g3hSjDoTDp5WFWbZFvEQbmr4ylqWC2HBmta8Kkw24jEIc7vLIW6PBzRV" +
           "RKvWpC/31pwXkpSBFuD2gtXiEc3EZjzVVK9fw716vpyLcoshOmujybS3mGF8" +
           "YkSVkMgDsTykzflwvURXW/CwgdfmCwHP+/wwh9cDbSIEaFedB8MpSaG0FTtz" +
           "n1vHpTyyZirtfITKllOsUaVczZNlGVt3e6xsDMfayFbAipjr5WyYpTpBh6X6" +
           "uZkE0I2pNblVAwRULr3U7JnY7qFSjqgVQ2MdOB5dCbp2WTH84rITCpw3pgfq" +
           "bLUekDTLK62OUassYXZC+ytmNXItb1apFwnKLeoMqfl1b+CzbGKUS6aWELC1" +
           "tgg9yJdmpQ4qwBGNzJlCS4568MSKCGsQgU3pm96UbleDV3ZicFN2EHJwH/oj" +
           "HIHEl+9wZ9vh9ng9Ox1NM0eu1g4fr2/PTaH0UOCuK91+ZgcCz7zrqafF7ofy" +
           "O3vnzWCff3rvUnrL5yRg89CVTz6Y7OZ3ewj6mXf9853DN6uPvIJroXuOCXmc" +
           "5UeYZz/Xfp3w6zvQNQdHopfcSR9t9PDRg9CzruQHYJd+5Dj0rqNXM3eB56W9" +
           "YX3p+Dnddj4vf0j3+o09XOUs/1evUvdEmjzmQ2ekWBICf3N/pB8yHNuHToa2" +
           "Jm4t6vGXO3s53EdW8ItH1b0TPN/dU/e7P351f+sqdR9Mk/cClQJLzO6Qn9zq" +
           "9b4fh17f39Pr+z9+vT58lbqPpMlvA71c6RK9fuf/oFd6lw5dACKe2rTdvH+8" +
           "ev3+Veo+mSYf96EbPNUODBG/spGeWdggYOKtrd7PvRK9Yx+65TKX2ftXadUf" +
           "9YYcINgdl/xZZ/MHE+HjT5+79vanR3+b3Qcf/AnkOhq6Vg4M4/BlyqH8aceV" +
           "ZC0bnOs2VytO9vq0D937ckL60NntR6ba85vGf+ZDt162MbCo9HWY9jN7F4uH" +
           "aX3oVPY+TPeXoLctHYD3TeYwyV/50DWAJM1+0fnhhxpbeL7LC/4I+PDmxjWb" +
           "q/jE0SXowBBufjlDOLRqPXBkucn+jbW/NASb/2NdFJ57usO+/cXyhzb34YLB" +
           "r9cpl2tp6Mzmav5gebnvitz2eZ0mHvzejZ+47rX76+CNG4G3XnVItnsuf/mM" +
           "m46fXRev/+j2P3jjh5/+anYV8b+AFG/RJicAAA==");
    }
    public void nodeRemoved(org.w3c.dom.Node oldParent,
                            org.w3c.dom.Node oldSibling,
                            org.w3c.dom.Node contextNode) {
        historyBrowser.
          addCommand(
            createNodeRemovedCommand(
              oldParent,
              oldSibling,
              contextNode));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeRemovedCommand createNodeRemovedCommand(org.w3c.dom.Node oldParent,
                                                                                                                org.w3c.dom.Node oldSibling,
                                                                                                                org.w3c.dom.Node contextNode) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeRemovedCommand(
          NODE_REMOVED_COMMAND +
          getBracketedNodeName(
            contextNode),
          oldParent,
          oldSibling,
          contextNode);
    }
    public static class NodeRemovedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldSibling;
        protected org.w3c.dom.Node oldParent;
        protected org.w3c.dom.Node contextNode;
        public NodeRemovedCommand(java.lang.String commandName,
                                  org.w3c.dom.Node oldParent,
                                  org.w3c.dom.Node oldSibling,
                                  org.w3c.dom.Node contextNode) {
            super(
              );
            setName(
              commandName);
            this.
              oldParent =
              oldParent;
            this.
              contextNode =
              contextNode;
            this.
              oldSibling =
              oldSibling;
        }
        public void execute() {  }
        public void undo() { if (oldSibling !=
                                   null) {
                                 oldParent.
                                   insertBefore(
                                     contextNode,
                                     oldSibling);
                             }
                             else {
                                 oldParent.
                                   appendChild(
                                     contextNode);
                             } }
        public void redo() { oldParent.removeChild(
                                         contextNode);
        }
        public boolean shouldExecute() { if (oldParent ==
                                               null ||
                                               contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Ffkg577Cu6y5+m9ccMYxmxwAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1aa+wjV3Wf3Wx2kyXJbhbyaEreCyUx+o/fY2uBYo/HHttj" +
           "z9vjGSib8bzteXke9oxpWkBtE5UqjdrwqAr50AZRUCCoLWqliiqoD6BQJCrU" +
           "l1RAVaXSUlTyobQqbemd8f+9jxCKasnXM/eee+45557zu+fe6+e/Dd0YBlDB" +
           "9+zUsL1oR0uinbld24lSXwt3BkSNkoNQU1FbDkMO1F1WHvrUue9+72nz/Eno" +
           "tAS9WnZdL5Ijy3NDRgs9e6WpBHTuoBazNSeMoPPEXF7JcBxZNkxYYXSJgF51" +
           "qGsEXST2RICBCDAQAc5FgFsHVKDTrZobO2jWQ3ajcAn9DHSCgE77SiZeBD14" +
           "lIkvB7Kzy4bKNQAcbsreJ0CpvHMSQA/s677V+QqF31eAn/nAO87/9g3QOQk6" +
           "Z7lsJo4ChIjAIBJ0i6M5My0IW6qqqRJ0u6tpKqsFlmxbm1xuCboQWoYrR3Gg" +
           "7Rspq4x9LcjHPLDcLUqmWxArkRfsq6dbmq3uvd2o27IBdL3zQNetht2sHih4" +
           "1gKCBbqsaHtdTi0sV42g+4/32Nfx4hAQgK5nHC0yvf2hTrkyqIAubOfOll0D" +
           "ZqPAcg1AeqMXg1Ei6J5rMs1s7cvKQja0yxF093E6atsEqG7ODZF1iaA7jpPl" +
           "nMAs3XNslg7Nz7fHb3rqnS7unsxlVjXFzuS/CXS671gnRtO1QHMVbdvxlkeJ" +
           "98t3fubJkxAEiO84Rryl+b2ffumtb7zvxc9vaX78KjTkbK4p0WXludltX3kt" +
           "+kjzhkyMm3wvtLLJP6J57v7UbsulxAeRd+c+x6xxZ6/xReZPxXd9XPvWSehs" +
           "HzqteHbsAD+6XfEc37K1oKe5WiBHmtqHbtZcFc3b+9AZ8ExYrratJXU91KI+" +
           "dMrOq057+TswkQ5YZCY6A54tV/f2nn05MvPnxIcg6AL4QndB0IkSlH+2vxG0" +
           "gE3P0WBZkV3L9WAq8DL9Q1hzoxmwrQnPgNcv4NCLA+CCsBcYsAz8wNR2G2Tf" +
           "D+FwZcwCbx1qAYwDOPCCtL197e85707mdP7/73BJpv359YkTYGJeexwWbECF" +
           "e7aqBZeVZ+I29tInL3/x5H6Y7NotgoZAgp2tBDu5BDuZBDsHEuxcQ4KLY0/V" +
           "GM3xABCgnuPIrgqdOJHL8ppMuK2DgOldAKAALG55hP2pwWNPPnQD8Ex/fSqb" +
           "IUAKXxvJ0QNo6ecAqgD/hl784Prdk58tnoROHoXkTCFQdTbrTmVAug+YF4+H" +
           "4tX4nnvim9994f2PewdBeQTjd7Hiyp5ZrD903PSBp2gqQM8D9o8+IH/68mce" +
           "v3gSOgUABIBmJAMnB3h03/ExjsT8pT38zHS5ESise4Ej21nTHuidjUwwMQc1" +
           "uU/clj/fDmx8LguCB4Gtsd2oyH+z1lf7WfmarQ9lk3ZMixyf38z6H/7rL/9T" +
           "JTf3HpSfO7Q4slp06RB8ZMzO5UBx+4EPcIGmAbq/+yD1q+/79hNvyx0AUDx8" +
           "tQEvZiVwp2wtBGb++c8v/+brX3vuqycPnCYC62c8sy0l2Vfypkyn266jJBjt" +
           "9QfyAPixQUxmXnORdx1PtXRLntla5qX/de51pU//y1Pnt35gg5o9N3rjyzM4" +
           "qP+xNvSuL77j3+/L2ZxQsuXvwGYHZFtMffUB51YQyGkmR/Luv7j31z4nfxig" +
           "M0DE0NpoOcidym1wKtf8DpCm5D2zlW5nu9LtN2RRva4oO6rn7GSBmtWX8yKf" +
           "cDgnfDQvdzJj5XyhvK2WFfeHhwPnaGweSnEuK09/9Tu3Tr7zhy/lmh7NkQ77" +
           "yUj2L21dMyseSAD7u46jBC6HJqCrvjh++3n7xe8BjhLgqACYDMkA4FhyxKt2" +
           "qW8887ef/aM7H/vKDdDJLnTW9mS1K+cBCt0MIkMLTQCBif+Tb916xjpzlfO5" +
           "qtAVym8d6u787TQQ8JFrY1M3S3EOwvvu/yTt2Xv+/j+uMEKOSldZ2Y/1l+Dn" +
           "P3QP+pZv5f0P4CHrfV9yJbaDdPCgb/njzr+dfOj0n5yEzkjQeWU315zIdpwF" +
           "nQTyq3AvAQX56JH2o7nSNjG4tA9/rz0OTYeGPQ5MB2sKeM6os+ezx7AoX6Ef" +
           "AuFZ3w3T+nEsOgHlD2je5cG8vJgVP7EX+jf7gRcBKTV1N/q/Dz4nwPd/sm/G" +
           "LqvYLvwX0N3s44H99MMHC95Z4BCsBQDENfaD4nzOrJ4VnS3j5jU95i1H9cmw" +
           "9dKuPpeuoc/oGvpkj73cSDhQDcgFFi6QJ1xNrPErFOthwH6XdPt7FbG4H0Ss" +
           "VynbjcMREDkkGP+yguWMkhNg9m4s7yA7xez9bVcf+obs8Q0A4cN8zwJ66JYr" +
           "23uy3DW3lYt7szoBexgQYhfnNpI1F4/Jhf/AcoFIv+0ARwkP7Bfe+w9Pf+mX" +
           "H/46CMcBdOMqCxUQhYfAdhxnW6hfeP59977qmW+8N1+cgN0m73rdv+YJqXo9" +
           "7bLiclY8tqfWPZlabJ4QEnIYjfL1RFMzza6PQlRgOWDZXe3uD+DHL3x98aFv" +
           "fmKb+x+HnGPE2pPP/OL3d5565uShHdfDV2x6DvfZ7rpyoW/dtXAAPXi9UfIe" +
           "3X984fE/+K3Hn9hKdeHo/gED2+NP/OV/f2nng9/4wlWS01O2t43SH2pio9ue" +
           "w6thv7X3IUqSLqz5JBF0stKE9WorGQmdFt5lGk20ujBYsc4aQ7LDSq7SIAyQ" +
           "ZcydcayGib5C2DqiwDPJxtcGw1kT2lp0aYtC8bTIoGzfZM24NOGpBTrnB9zE" +
           "81GhLE98dBlMOLnbETzZXk4i4DTlWWU2h2Mj8H05Dpyao+vaitKdjVZo9qQC" +
           "Mg+9ET7jOZOe+TEmj8QByK1LRsUaG77YoETUGSVVZcHCpKqW4CBuyFRKT2h4" +
           "3i9pLSZeCOkwlVuppUkDix+u+wlpzJkerfBSUWTacHfSHU5olbZ6XGnASSJm" +
           "6fKy72BYq2RRHiqNlizS5WtcUWj1PcdU2hw/UBbNVh2p0FXD8boTJq6kgoKk" +
           "nVAdVdepLDdtfkyLZXGMK6zZHXALfkGvZS6OvFieDatFMmW90YITx0itKwjo" +
           "RupOYqHqkVTX9Jor3KzFNbQuGsyk66vrhrgOkwnu8FYb58V+s5yyjI9gPOVJ" +
           "/f7SxWg+YftSWxyv5b4pdJh5wBe75UhhBtI0nBCL2hgl/WmbFGmTjtTWign7" +
           "dc72Da+ULBaTLkGoYXVUspC+4ESyI1BWqAmmV4Rj2U39docfeYY0qAv6Eh22" +
           "MJPne2sZW/RYrR7yVd7irL5jciKC1y22ZAmDZarO5vKiT0+5bi+BE6sUjoY8" +
           "48pNv7AOypiw4fj1YNKUkxrK1OjSspCa/RRfjyUpWpYdUy2FeCsN7UUroUTM" +
           "RKxUKAITYqwjI4Vpv2ya1VbLakXsYFAnUHkq+/yaQ1tOWKQXMyztkku82CV7" +
           "BsGMTLrDDwUvGA64mhBSKNquWiNGZvBg6ZH0hJ+oa2beF6yu1ZDsNYuUyJk0" +
           "UPTClGzOlLKlhzae9BPYI9qDtrQKpq0uiZjlBcEyqLruLNY9IZ4yIjIXGMWB" +
           "aaOtiDFeHnK1ja/GFUKzdM0bL8oSifvBuMGVMK+DmyqxKSAzR2ULDV8UfF5e" +
           "emaolCqCUqMElZVRWSnRA1MSRDsc+ZbkjoO0bCo6yYeF5pBa4jYdL/H+Ep3i" +
           "/GBoAn8dDlYe5jEjjbc6Zc+yTGtQg1c0M6XnRWM44pXKIOn3PK7sTUipU2MD" +
           "uMPWhkZr7nhO4LFFH93odInrqzWqXjTNQWAaJY9pLEsYPIIbvmMsxsO1w9IG" +
           "IQwwfsxwk4kgwxhNYJY4XpnFcWJRS2Yx7Dlqa95eDD3K5DoYmJNkEKBOj+3O" +
           "VdSKl2WyZS57Y6OzXFIBosFjh0PVqoFugghGIsWxF7DY2LhGtSzVq3y3Jxvl" +
           "ZTDoNwfmekwIhXpDJEJOHy96FJ5Q/RlDF1rtRZcz0s60PzKK6NiT263Iw0ij" +
           "I45r6MLyWrSsyVxv0GU6Vb1U5h2+UR1h47mG0a0h1u0hEQ67flTmcJanHdUX" +
           "h2po9snSWpITslcspkO25bi9QuyUzKqqTbpUuhx7PTEstllBoAeyv260o9Zi" +
           "Xoqd1ZwfxWGJGrYW6lCc2fRkzVutZX/CWmXBxrw1U9bn3VGpyI6MBYXLRbo6" +
           "5bgJ0iyq7CDkFRwPEHUOb2JiNBSI1qglkQljrkrSvNWsFllSr/TlTmlTLeiV" +
           "FJZjsj9MS3boLMgBQprrJIymKx0zezzRGMUJCoedClmaGNSIXyMLDO1VKkHc" +
           "Q5fTVq/hLyJbaK/pSOCEnsT1mOa0WO71B9MYMysYhzQKWNgzjVpFNE1Mm6rA" +
           "Zca1WPVnvXKJTpCuo2jDijksTFO4ueIoHSYQEnGQUdNx1xOs3GyPZNVqaVhz" +
           "NgrlyqATxRFpdVtqYYI1eys8MGFl44yEYXtmC5tOS5gbbQIvd5ykiYgFGMFL" +
           "66au2qtk43TtQWFIFwR+Y/pSKqRLotxfBMQMKxkKza9FUZxgXHkotXTMG6CK" +
           "aq8NRKASTwgqm9q8qsgbzqJFluYYK4oJpaWtysWmFnPj6bQZ1cqDRitciVHY" +
           "DEfz0XhDtOygOS5RI6TIduD6JkhXq2pdNz0a7fdqfazKzRXLrdCsU9E7Iq8M" +
           "Um6gaYYjpRtsnfaTuMoby6Hc6QxCURtXGlVpVUB9UutEK6RMkFW3z7jreCMF" +
           "uEl15nFYcLzUIdCqEuolutRokt54tnSQAKd6LAsLa0fyQkca9EK2onndqL+R" +
           "e4ZWj5ezqjrXCZ6TWlW03e/SuDQP1wjtVKSuDRBtsuoReClVIn0VYTG3YiIh" +
           "tcJJvGk1vKU35GgxMWmyXFTjZlNy2FE4afu1oWzh5HjTjubOZgQmYVIazPXh" +
           "2FmZcR3Rp27HLtm85knhUlzDNiGgAFG4IYyPLUOhZuoGrhQ3XY2a11w7UQmU" +
           "JeemA1cqmynRWA9h2I7H6dzr1lizQcHljlcZOeVNwOuKW53N22alPyjP4FaH" +
           "nqlVZGPN4Grc8OA6pk/o1GJCbJkY2trtDXC93Rry6JjzeKqN+H6lWxs7NYYj" +
           "jbikEEmrbq+mqDcoFT2l4AkzmDQqacMkF61R14wMZbAkYKKGkXBR8WdUAxcl" +
           "eVOftSRvyU0UX8ZsrNMUi12mC4wrYEB0DBvyI0mE1Q5aMzrCqs718ErX2ww6" +
           "QnXWw5d4oEzRtrAWR72SwXHMtMQTioj2PDRasN6c1X27IPpLmRBbZaJEbUiv" +
           "4JKe7wnVpewx8w6QtrpWClZ9WbXiur5GkJ6u9kmaM0rwEukU4408ny/dulpQ" +
           "6EJNNNvlWYJ2E6YQc36zShq+oo82w0ZpU4nXcSFYGdxq1djASG2y6mBBithL" +
           "dk4ENAAnoeULjUZ3iAC3dGS9yK5KTAXZrJQOXYhdXuulIcxIE5wKm3iaiBPT" +
           "8lfDZUOPW9Rsspp24oLGBItypTAmgsbc1cKmWg7aGEkSblSiOQofxFG57oTt" +
           "MF26PFqqdO3lOqx2A5vwXWcNEiUBWal1urkgKQbB08qIWPDDkFGJWBj0aooq" +
           "taKJ2S4u2FaMqMy4W8JUdjEoqZanqqMxIsAFkeQWkaaPGxTltI1G4nCbeo0v" +
           "oGa1LnuCVcDZzTCeVRFN2VRa9ZrjFZw+V+hQ7VoTDunCxqDL61nDaLmqaKsL" +
           "vNwNY9b3qkLXJgmiiTdjmEJWMBzC3riQpioyRD11wk4Z0+jMJ257Qo2djcHW" +
           "x/N0FYs9q+OKiUwmS1Wft3jRKqdVvsE7ejiU01m74NNWI14hNCIS+KpRnOqo" +
           "ISlap1hR231VtKR5bSKR1YVcrbfRCstWq8TcrfYJIbKVFsXpouokIuzFQ5Cs" +
           "JKP1htFkTWwUK8PhsoPOFdsqlSQRbzVa8w6NFOFuR/NqNVzF1HXMGZq54ni2" +
           "StCFDqvq6Yy0Boaul1ejKRPXhraVJg5p97t+e4qXZiQzpguzeVRx653GsN6e" +
           "TCeSbQyEmCLAZmekkpGBuA2wMFdW+LAay/SsYRvUcrH2i1GVrzO4KnRrpk/2" +
           "SV/buEx7JRFiUUS7+EKoiX4RzL1OjWGMTfw1MVWatdVoom1iGJbG6HidkgW1" +
           "VnYTtjupVkuTjqQ5wUzbbLpSrdGUy70pZtkSWHjwuVuv+T6JJXiJlZMZ0VsV" +
           "6vS4hwrpYjCRK02jtipb4aIB0mVi6ohVV9sQ7HTFxL5Rl9nFstpsknGkih2p" +
           "bBsp0Uc65oCwu3zLYsNCSkVURS+Rnhnh7NKa0aha88oqUprKtTrihSucUZar" +
           "qtJm2xZIDRwdhvsMxQ71EYyBfA4e2mNdj+IAB9GLNRips05Aps/TKDrjNitp" +
           "5JgmLSwkQeNndrMe6kh3qbCiOfYXw3LRKCZrbDqddsgxLuszfdQYm1YbGaw6" +
           "hbo+XVHBPNUHlT6lrphNbVQUN1HMaOVoIKMFd4wMKL1Fh25/WsRRttaQp0ho" +
           "NWRVb1hxoiodt7uUKVTSKQTfVFJywyHTGl+sUsP+WOPGRHNQmRfiGYqjy069" +
           "D7L3+XBdXBomPUjTanHZ05l50523YY2oKfU6gprIXCa9PgLQYlrpBIPZZCQP" +
           "V5O0lwiuyYrVQhWedy1Xni/toVTrkWumnVoFCeuDyCv3yyVrMWmO0rGEwUsc" +
           "EwuSOO3qC6OGIGhcT2sFp6koIzFxkjXYlL75zdl2NX5lJwa35wch+9ehP8QR" +
           "SHL1AU8eDHhwvJ6fjt5+/Gbt8PH6wbkplB0K3Huty8/8QOC59zzzrEp+pHRy" +
           "97wZ7PNP795JH/A5Bdg8eu2Tj1F+8XtwCPq59/zzPdxbzMdewbXQ/ceEPM7y" +
           "Y6Pnv9B7vfIrJ6Eb9o9Er7iSPtrp0tGD0LOBBqLF5Y4ch9579GrmXmDO0a5Z" +
           "R8fP6Q7m8+qHdG/Y+sN1zvJ/6TptT2XFExF0Rks0JY6290eLQ47jRdCplWep" +
           "Bx715MudvRweI6/4uaPq3gMkp3bVpX706v76ddo+nBXvByrFrppfIT99oNcH" +
           "fhR6TXf1mv7o9froddo+lhW/AfQKtCv0+s3/g153ZZUXgYhv39Xr7T96vX7n" +
           "Om2fzopPRtCtoenFtopd20nPzDzP1mT3QO8XXoneSQRduPIue+8mrfHD3o8D" +
           "ALv7ir/qbP9eonzy2XM33fUs/1f5dfD+X0BuJqCb9Ni2D9+lHHo+7QeabuW2" +
           "uXl7s+LnP5+NoAdeTsgIOnvwkqv24rbzH0fQHVftDBwq+zlM+7nde8XDtBF0" +
           "Y/57mO7PskuWfTqA7tuHwyR/HkE3AJLs8cv+D27q1iyMAlmJeBDC2wvXfK6S" +
           "E0dXoH0/uPByfnBo0Xr4yGqT/xdrb2WIt//Guqy88Oxg/M6X6h/ZXocrtrzZ" +
           "ZFxuIqAz25v5/dXlwWty2+N1Gn/ke7d96ubX7S2Dt20FPgiqQ7Ldf/W7Z8zx" +
           "o/y2ePP7d/3umz767Nfym4j/BYj9TaUkJwAA");
    }
    public void attributeAdded(org.w3c.dom.Element contextElement,
                               java.lang.String attributeName,
                               java.lang.String newAttributeValue,
                               java.lang.String namespaceURI) {
        historyBrowser.
          addCommand(
            createAttributeAddedCommand(
              contextElement,
              attributeName,
              newAttributeValue,
              namespaceURI));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeAddedCommand createAttributeAddedCommand(org.w3c.dom.Element contextElement,
                                                                                                                      java.lang.String attributeName,
                                                                                                                      java.lang.String newAttributeValue,
                                                                                                                      java.lang.String namespaceURI) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeAddedCommand(
          ATTRIBUTE_ADDED_COMMAND +
          getBracketedNodeName(
            contextElement),
          contextElement,
          attributeName,
          newAttributeValue,
          namespaceURI);
    }
    public static class AttributeAddedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Element contextElement;
        protected java.lang.String attributeName;
        protected java.lang.String newValue;
        protected java.lang.String namespaceURI;
        public AttributeAddedCommand(java.lang.String commandName,
                                     org.w3c.dom.Element contextElement,
                                     java.lang.String attributeName,
                                     java.lang.String newAttributeValue,
                                     java.lang.String namespaceURI) {
            super(
              );
            setName(
              commandName);
            this.
              contextElement =
              contextElement;
            this.
              attributeName =
              attributeName;
            this.
              newValue =
              newAttributeValue;
            this.
              namespaceURI =
              namespaceURI;
        }
        public void execute() {  }
        public void undo() { contextElement.
                               removeAttributeNS(
                                 namespaceURI,
                                 attributeName);
        }
        public void redo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 newValue);
        }
        public boolean shouldExecute() { if (contextElement ==
                                               null ||
                                               attributeName.
                                               length(
                                                 ) ==
                                               0) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "tRNbHQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
    }
    public void attributeRemoved(org.w3c.dom.Element contextElement,
                                 java.lang.String attributeName,
                                 java.lang.String prevAttributeValue,
                                 java.lang.String namespaceURI) {
        historyBrowser.
          addCommand(
            createAttributeRemovedCommand(
              contextElement,
              attributeName,
              prevAttributeValue,
              namespaceURI));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeRemovedCommand createAttributeRemovedCommand(org.w3c.dom.Element contextElement,
                                                                                                                          java.lang.String attributeName,
                                                                                                                          java.lang.String prevAttributeValue,
                                                                                                                          java.lang.String namespaceURI) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeRemovedCommand(
          ATTRIBUTE_REMOVED_COMMAND +
          getBracketedNodeName(
            contextElement),
          contextElement,
          attributeName,
          prevAttributeValue,
          namespaceURI);
    }
    public static class AttributeRemovedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Element contextElement;
        protected java.lang.String attributeName;
        protected java.lang.String prevValue;
        protected java.lang.String namespaceURI;
        public AttributeRemovedCommand(java.lang.String commandName,
                                       org.w3c.dom.Element contextElement,
                                       java.lang.String attributeName,
                                       java.lang.String prevAttributeValue,
                                       java.lang.String namespaceURI) {
            super(
              );
            setName(
              commandName);
            this.
              contextElement =
              contextElement;
            this.
              attributeName =
              attributeName;
            this.
              prevValue =
              prevAttributeValue;
            this.
              namespaceURI =
              namespaceURI;
        }
        public void execute() {  }
        public void undo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 prevValue);
        }
        public void redo() { contextElement.
                               removeAttributeNS(
                                 namespaceURI,
                                 attributeName);
        }
        public boolean shouldExecute() { if (contextElement ==
                                               null ||
                                               attributeName.
                                               length(
                                                 ) ==
                                               0) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "E2lgHQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "W79TxtFWc1oSWpMOXSnhGdEebjA+T2RIOmiLbMOL6kF3PEO3azHik24qepUO" +
           "2mXnopCs7IpIU5KLE9EqJSi/JTSYLbaS2E1bwMpbeirO3S2N9Ss23krQ9TgI" +
           "qIW6suIsgCOtUd5Mo0i0J0K22rZnZXNrGppUEVEcm4Msi8Jlvw6SLyMoITmT" +
           "lc3AXFXgBG2o3eZwAMN20t5k1lQKHFLnM7K64BlnG87WzXWVAcCEtiv+lko7" +
           "6aCRhqu6AFNJGusGM5wMNyBwq8G2o9eIMcmsRRDsEpIgG6Yel7eNejnaCt2g" +
           "k1bqTbiC1elwSlbVAe7NS768aI2XTSJyA4cRiWWGdRlq1STwJRm2yO50gDiN" +
           "FTnXo2HbFfqiiNm+mc6VWjxzKcoWaAdVaAR2Gll5tKgE9ZUgNf0mX1eUhcvK" +
           "TU2NaIKOpzhNrqK2IMQe1UTEfqagQ2nmlyqaXlNlhHfKMCf2Y7rJ1WNVqseC" +
           "U0Yle1ZBtsqCgtN2J3EXbJg4QdvpU1xl2o6QWh8XN93Y7zl1ouuYYt3GpGqC" +
           "tnjVEbOZIwpTkd+YZLw0sUk9ycZ1b2R7coX3UfBX7jAOjtNoSVLoTVYZCBky" +
           "5wMr4mfsZDwvIzNr3ZsgKYvCjgS3muxMiCablh3MzV44TDZ06ix4cTXfbOoa" +
           "GWyak9nM6jdLCDktKeOZ3c0QPxGr5BhN15jhTGupOl1vEpHUKys5dmtWK02D" +
           "7VAszWCf5mOk0Qom/TFsrYazRa+/ppIqukgkLUzBgre29JzlRo2a054+n5bK" +
           "SFqvr2NXgmOhNHUBkhiLtBlVF91MClzRNarbVlaqWOkw6Q4cDoPnXqL3FZru" +
           "C1RnOZguVITjG/W4qvGzRqst8E144HKj6sb1VzA61FbDGHe6tXjNVL2ti281" +
           "vqQ3cKSbZoxO4TA2M5obuO4JiyGme/2xvBYSb7gW+jAhS41Zucs25ZCyE7eF" +
           "6nELdWMf5dqrmkS08OV00O2SxpBjrMaa83W3ReA9f9pvt2qG3OmqszYf19lA" +
           "wstcgqzSBe8jbsNcxmuDnLYbPcxdAmeaZGmJ65fTWWXK6Hofxaa1KT+Yl1Sx" +
           "qSCl1XZGp8Z8vp0xpDlEcbxTQ0IMRmdTVI7chtVTQsbhgDnc0OrFjCUTRtXb" +
           "GAhbpzzSAAnW8HolA2dmplYahlUA2YEue0lpbjI4QxuyEK7rfnOgMGhrtSUs" +
           "fi36XlL2V/54OR1O7A1aW4Yy357XWx4R8unMoyeKSMz6m4pfw0oxbYPdGqPA" +
           "FsMj6xaq9BFcrQwz1B8G43ZPS1Glg5rZmhqiVbNuuwN1iLeseDU2OtRoNJfi" +
           "ZjjtEUpp0qTG1cDIltu1AEuTpt+AWw7V00kOrVZRVcd1Z1urRD2n3Ez0ct9O" +
           "dGHRUCYRLbLDWk+RFpVwlqb2rMxaq8BKTXQz0WcV3etMUbHWNZREYbhSZbyZ" +
           "bSSPD6Itg1N1SVu0LDWtwguweRGodYyUwyYbkEtEHDoLRtA7gmEE2JKR1wFf" +
           "qgUA9I12PKSdMgOTI53pLzV/2NMis6qy/BQlMnbGLlZzq7aQeISJEnLB6XWe" +
           "KvGcG8PDlsrwsVWSGhTRyqxaX9yYm4607vtdu9zrKZ6/laTJuue2JvGUjsxJ" +
           "ZRKkCD1bGDJb7XGN0Ii6bpmJG5a22Y4qLXYNspE2XetEgPB0WKbwCOPoQYd1" +
           "Gk2zKXclEauGQ0ZiODGNkQ66puvTFbyJhDo9t2BYYtWajAj8qonq8w2suaFb" +
           "L+uO63isZ1utADPGvFXP2jBBUmgHrkVauTMZ+nW77It42zLZrWXMh0F7XVb0" +
           "RbbUQ0aZSpbmyyUW700cetWVFg3StlbdQTwvdyVa6U3a81qn1oAbtuEGcTac" +
           "jEokV2KJLFE5ptttYDNqYcIg89jlOT7RApJKSo252u4DA6MVWq2stxU0DWGq" +
           "YoPkgGH5tvbnn9vJwt3FgcmVO94f46gku/aAB/sB99cFxSnv3WevC0+cPJ04" +
           "/4Xyw4MHrnejWxwcfORtTz2tDj6KHBydm6cxdMvRRfuez82Azauuf0LCFbfZ" +
           "+8Pcz7/tn+8XHl++6Tlccz10RsizLD/GfeKL7Zcrv3oA3XTlaPeqe/bTRI+d" +
           "PtC9PdTiJHSFU8e6D5y+anoAmLNyZNbK2QO9/Xxe+zTvlTt/uMGdxHtv0Pa+" +
           "vHhXDF3QMk1J4t19WHjCcdYxdPPaM9W9R7372c5oTo5RVLzztLr3AzVrR+rW" +
           "fvLq/voN2j6SFx8GKiWuWtyLf2Cv19M/Cb1ec6TXa37yen3qBm2fyYuPAb1C" +
           "7Sq9Pv5/0Ou+vPIy0OfxI70e/8nr9fs3aPvDvPhsDN0ZLb3EVqnrO+mFhefZ" +
           "muzu9f6d56J3FkP3XeeC/vh6sPnj3vwDFHvRVS8h7V6cUT719MVb73ta/Kvi" +
           "jvvKyy239aBb9cS2T14MnXi+xQ813SwMdNvumsgvvr4QQw8/m5AxdPv+R6Ha" +
           "53fEX4qhF16TGHhV/nWy71di6NLZvjF0vvg+2e+rYLR9PwDxu4eTXb4WQzeB" +
           "LvnjX/g/uqmxRRSHshKLII53t8jFXGXnTqehK85wz7M5w4nM9ciplFO8ZXac" +
           "HpLde2ZPKJ9+mu2/+Xv1j+7u+BVb3m5zLrf2oAu71w2upJiXXJfbMa9bmEd/" +
           "cNdnbnvZcS68ayfwPrJOyPbQtS/UKcePiyvw7e/d99uv/Y2nv15cW/wvKGHC" +
           "nv4nAAA=");
    }
    public void attributeModified(org.w3c.dom.Element contextElement,
                                  java.lang.String attributeName,
                                  java.lang.String prevAttributeValue,
                                  java.lang.String newAttributeValue,
                                  java.lang.String namespaceURI) {
        historyBrowser.
          addCommand(
            createAttributeModifiedCommand(
              contextElement,
              attributeName,
              prevAttributeValue,
              newAttributeValue,
              namespaceURI));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeModifiedCommand createAttributeModifiedCommand(org.w3c.dom.Element contextElement,
                                                                                                                            java.lang.String attributeName,
                                                                                                                            java.lang.String prevAttributeValue,
                                                                                                                            java.lang.String newAttributeValue,
                                                                                                                            java.lang.String namespaceURI) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeModifiedCommand(
          ATTRIBUTE_MODIFIED_COMMAND +
          getBracketedNodeName(
            contextElement),
          contextElement,
          attributeName,
          prevAttributeValue,
          newAttributeValue,
          namespaceURI);
    }
    public static class AttributeModifiedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Element contextElement;
        protected java.lang.String attributeName;
        protected java.lang.String prevAttributeValue;
        protected java.lang.String newAttributeValue;
        protected java.lang.String namespaceURI;
        public AttributeModifiedCommand(java.lang.String commandName,
                                        org.w3c.dom.Element contextElement,
                                        java.lang.String attributeName,
                                        java.lang.String prevAttributeValue,
                                        java.lang.String newAttributeValue,
                                        java.lang.String namespaceURI) {
            super(
              );
            setName(
              commandName);
            this.
              contextElement =
              contextElement;
            this.
              attributeName =
              attributeName;
            this.
              prevAttributeValue =
              prevAttributeValue;
            this.
              newAttributeValue =
              newAttributeValue;
            this.
              namespaceURI =
              namespaceURI;
        }
        public void execute() {  }
        public void undo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 prevAttributeValue);
        }
        public void redo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 newAttributeValue);
        }
        public boolean shouldExecute() { if (contextElement ==
                                               null ||
                                               attributeName.
                                               length(
                                                 ) ==
                                               0) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "WmmzQHdGkTtQHYValD949cOK3g9fvM3Udld6Tqfp4tRWw09pszAFy9d7UW4t" +
           "pw8A3f3j3V+slsbvwIp9sCIPYK+v1wCNUy4XM6mLpvzypVdmbLtSgPwdqExS" +
           "OKGDY9GKSiFMsD4AQJ5SH3rYcJNh6jfVTFWUoXzGAD2pOdl9oD2hEnZqoxfr" +
           "v7/i1MnrzF1VY42ZjJ9eK2a54JndF2yEOPP2p39+6mtHh42KoyU3LHr4Gv6+" +
           "Xort/c3fMkzOADFLNeTh7wudfaaxbeVNxm8jE+UOpDLzIaC7zXvvmcRf/M3F" +
           "P/ajKX2omjfr815OStJ474OaVLeKdqjhXfPu+tIoplrTyDvLi4qObb2YaOdh" +
           "6FNq2q/wwCCraloAGfaYCLHHC4M+xDpdjOVu1i6izacs1ClVNYWAlFjwAE9N" +
           "nmUJquSNG4MjCB8wIJe2K2jTbSz4UE6/XOPWg8L54+aGj+fQo9fQgzaRTHFz" +
           "cRNUkb6FdptmXe6R9vOTlHYJ7POUud9TOaTdklfaXNzgQ6qGh9IFFHOsbCJv" +
           "naTIi2Gzg+amB3OILOQVORc3oRfF4YklxpOUeCHsdcTc80gOiQfzSpyLm6By" +
           "GmA6lLZ404bObMJKeYRNZY8nP+0GIZXr7FZtR1ShJY/r+uFM5TamIpo4Zue6" +
           "IbLb7djewyeF9c8uNVC11n3rapeTied+8c83gsd//XqWkr7YvOHbGxbS/Vwg" +
           "3sVuzjYivld56Lc/CPSvnkx5TceaJiig6fc5oMGi3HnBK8qre//YuHHlwLZJ" +
           "VMpzPLb0LvmdrrOvr1nIH/KzZwIDqjOeF9xMrW6ALtMwSWryRhdMz3dXq7Ph" +
           "1C+Yp3/B68u26zFHXpxZA+ZizVPkPJZnbh9tdhO4ZKcwDyGr503OEU1MQCE8" +
           "ZD41hHbVvj/4zI3nDPfzZmIPMd5/+MmPgwcOG65oPN7Mz3g/cfIYDzhMzGrD" +
           "EB/Dnw/+/0X/qQ50gH4CVraZrwhz088ItETR0Lx8YrEtOn5/btcPT+/a5zdt" +
           "kiKocEgRBRsC9kyEV/lLKzrQrrLxnW5naISTvGie6MXJO0Mu1jwH/q08cydo" +
           "cxS0T8oCez/5im2CY5+kCS6ZelyavAlyseZR83SeuTO0+TaYQMMZJhj7BExQ" +
           "T+cCIP/Lph4vT94EuVjzqHkhz9wLtDkPtRLcJ5KS0J4GBsf7CwX9nmRMJ54g" +
           "vzeyjd8fiPzOQIS7sjAYdHWnQ0/3Xtv+BkPvEpou0pjpSBWQVhy3/mraPG0Y" +
           "9glH/6uAXjFFkTAnp/XxpR+NprtlMLZ/5ImqHx2sLeiAPNaJSpKyuCOJOwU3" +
           "lk/RkzGHUPZ7ro3spkQUhAjyLbKuRMxZvvu/cBZAooZcD2jWXfiB//ZpDozT" +
           "kPErgfGyzT9/sqqk/uSmayzRp1+fy+Gs4klJcl5JHP1iKFfjIrNMuXFBUdnH" +
           "ZYLmTiQkQWX2F6baTw3mNwmqy8oMMUo/nLRXCKr20hJUxD6ddFdhN5sOSiGj" +
           "4yS5RlABkNDuO+p/bupV4OEa1EWbAECNJxN2Vimfu65Le0ndRF7iKAXnu/Iy" +
           "+xnIcuyk8UNQlD93cl33o7eXP2s8aPESNzpKV5kK7my8raWLoXk5V7PWKl7b" +
           "cqfyfOkCKy3WGALbeDTTARrtEG0qfUNo9Lz26IH0o8+7Yyte/Nn+4regAtiM" +
           "fBxB0zZnXpJTahKq0M3hzLCFwpE9Q7W2fHNk5ZL4n37FniHMMJ+Vmz7KXz21" +
           "5e1DDWNNfjS1ExVBxscpdnt/ZETegPkhrQ9ViHp7CkSEVUROcmFCJfV+jr4+" +
           "MbuY5qxIj9LnUIKaMyuZzEfkMkkZxtpqBdKriSpT7RHX71NmRJUlVdXDYI84" +
           "oHHcACJ6GuC30XCXqlqVkX+pysDkJS82skHGfZN1afPBvwHsJPV+Ih4AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "55976Ke/4Uee/4vyruN/AcQ0fgnhKAAA");
    }
    public void charDataModified(org.w3c.dom.Node contextNode,
                                 java.lang.String oldValue,
                                 java.lang.String newValue) {
        historyBrowser.
          addCommand(
            createCharDataModifiedCommand(
              contextNode,
              oldValue,
              newValue));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CharDataModifiedCommand createCharDataModifiedCommand(org.w3c.dom.Node contextNode,
                                                                                                                          java.lang.String oldValue,
                                                                                                                          java.lang.String newValue) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CharDataModifiedCommand(
          CHAR_DATA_MODIFIED_COMMAND +
          getBracketedNodeName(
            contextNode),
          contextNode,
          oldValue,
          newValue);
    }
    public static class CharDataModifiedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node contextNode;
        protected java.lang.String oldValue;
        protected java.lang.String newValue;
        public CharDataModifiedCommand(java.lang.String commandName,
                                       org.w3c.dom.Node contextNode,
                                       java.lang.String oldValue,
                                       java.lang.String newValue) {
            super(
              );
            setName(
              commandName);
            this.
              contextNode =
              contextNode;
            this.
              oldValue =
              oldValue;
            this.
              newValue =
              newValue;
        }
        public void execute() {  }
        public void undo() { contextNode.
                               setNodeValue(
                                 oldValue);
        }
        public void redo() { contextNode.
                               setNodeValue(
                                 newValue);
        }
        public boolean shouldExecute() { if (contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "5NyXeJc1l/8DaMIo2qIcAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "z341e4r4Xwr8uJUnJwAA");
    }
    public void appendChild(org.w3c.dom.Node parent,
                            org.w3c.dom.Node child) {
        historyBrowser.
          addCommand(
            createAppendChildCommand(
              parent,
              child));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AppendChildCommand createAppendChildCommand(org.w3c.dom.Node parent,
                                                                                                                org.w3c.dom.Node child) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AppendChildCommand(
          getAppendChildCommandName(
            parent,
            child),
          parent,
          child);
    }
    public static class AppendChildCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldParentNode;
        protected org.w3c.dom.Node oldNextSibling;
        protected org.w3c.dom.Node parentNode;
        protected org.w3c.dom.Node childNode;
        public AppendChildCommand(java.lang.String commandName,
                                  org.w3c.dom.Node parentNode,
                                  org.w3c.dom.Node childNode) {
            super(
              );
            setName(
              commandName);
            this.
              oldParentNode =
              childNode.
                getParentNode(
                  );
            this.
              oldNextSibling =
              childNode.
                getNextSibling(
                  );
            this.
              parentNode =
              parentNode;
            this.
              childNode =
              childNode;
        }
        public void execute() { parentNode.
                                  appendChild(
                                    childNode);
        }
        public void undo() { if (oldParentNode !=
                                   null) {
                                 oldParentNode.
                                   insertBefore(
                                     childNode,
                                     oldNextSibling);
                             }
                             else {
                                 parentNode.
                                   removeChild(
                                     childNode);
                             } }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (parentNode ==
                                               null ||
                                               childNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "kltyqNBl4Le2dFf+dhYo+MjVaamdrW4OPfuu/xxYs/f+/X9cNgg5IV0hqJ+o" +
           "L8HPf/xu4q3fy+sfMkNW+97kcloHK8HDuqVP2/+28+CZP92BzkrQLcreMlOQ" +
           "rSjzNwksrYL9tSdYih4rP75M2q4JHjtgvtefZKUj3Z7kpMNwAp4z6ez5/Aka" +
           "yoPzw8ByB3seOjhJQ6eg/IHIqzyQpxez5Gf2vf6c57sh0FJT9xz/x+BzCnz/" +
           "J/tmzWUZ25h/G7G38Lj/YOXhgVh3EzAIEBtAKD5wiS37ZWk1S5rbtvGrGs1b" +
           "j0N6A4DC7UHirgKJvgqk7LGTjxMZQjcD1Rhga2MTUJszv5JuzCvU7UGg03RP" +
           "t+lVdONejm7nvWuOGf8K9cqi0eN7ej1+Fb3e/nL0Oqdka4+rqfWOl1QrbyY5" +
           "BWzr+tIutlvM3mdX7vh09vhGEHqCfDMFauimI1v7mty5sJSL+zYngM0VIICL" +
           "CwvLiosn9CJftl6Ah24+JHjKBRuZD/zDh772wYe+DciiB12/zhwZcMSRKMBE" +
           "2d7ul55/5p7XPP2dD+RRE4ya8O6H/zVfKS+vhS5L9CyZ78O6O4M1zleqlByE" +
           "dB7oNDVDdm2OZH3TBuuB9d7GBX7ytm8vP/7dz2w3JScJ8YSw9v6nf/nHu089" +
           "vXNkK/jQZbuxo3W228Fc6Zv2RtiHHrhWL3mN9j9+7snf/40n37fV6rbjG5sW" +
           "2Ld/5i//+2u7H/vOV66war7OcrdO+hNNbHjzn5DloFvf/1CI1Jw0eCERCxG8" +
           "NAjdJlt1dzlsG3GB7KBWnwobTNRhuuSQm/WaQyMlJMrBcBsrLWf6mlWrGIXb" +
           "S55YbizNpM2eMVa7dWm0WRWb9UknkBmhVGs3vJkYdlNEXiHsSm6go9RadAJu" +
           "ZSIOu9aw9VrCBpQip1JpFqLYBnVQkh2wuoJV8Kqynrb7ar2ItCrLTnVm9PEO" +
           "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");
    }
    public void insertChildBefore(org.w3c.dom.Node parent,
                                  org.w3c.dom.Node sibling,
                                  org.w3c.dom.Node child) {
        if (sibling ==
              null) {
            historyBrowser.
              addCommand(
                createAppendChildCommand(
                  parent,
                  child));
        }
        else {
            historyBrowser.
              addCommand(
                createInsertNodeBeforeCommand(
                  parent,
                  sibling,
                  child));
        }
    }
    public org.apache.batik.apps.svgbrowser.UndoableCommand createInsertChildCommand(org.w3c.dom.Node parent,
                                                                                     org.w3c.dom.Node sibling,
                                                                                     org.w3c.dom.Node child) {
        if (sibling ==
              null) {
            return createAppendChildCommand(
                     parent,
                     child);
        }
        else {
            return createInsertNodeBeforeCommand(
                     parent,
                     sibling,
                     child);
        }
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.InsertNodeBeforeCommand createInsertNodeBeforeCommand(org.w3c.dom.Node parent,
                                                                                                                          org.w3c.dom.Node sibling,
                                                                                                                          org.w3c.dom.Node child) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.InsertNodeBeforeCommand(
          getInsertBeforeCommandName(
            parent,
            child,
            sibling),
          parent,
          sibling,
          child);
    }
    public static class InsertNodeBeforeCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldParent;
        protected org.w3c.dom.Node oldNextSibling;
        protected org.w3c.dom.Node newNextSibling;
        protected org.w3c.dom.Node parent;
        protected org.w3c.dom.Node child;
        public InsertNodeBeforeCommand(java.lang.String commandName,
                                       org.w3c.dom.Node parent,
                                       org.w3c.dom.Node sibling,
                                       org.w3c.dom.Node child) {
            super(
              );
            setName(
              commandName);
            this.
              oldParent =
              child.
                getParentNode(
                  );
            this.
              oldNextSibling =
              child.
                getNextSibling(
                  );
            this.
              parent =
              parent;
            this.
              child =
              child;
            this.
              newNextSibling =
              sibling;
        }
        public void execute() { if (newNextSibling !=
                                      null) {
                                    parent.
                                      insertBefore(
                                        child,
                                        newNextSibling);
                                }
                                else {
                                    parent.
                                      appendChild(
                                        child);
                                } }
        public void undo() { if (oldParent !=
                                   null) {
                                 oldParent.
                                   insertBefore(
                                     child,
                                     oldNextSibling);
                             }
                             else {
                                 parent.
                                   removeChild(
                                     child);
                             } }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (parent ==
                                               null ||
                                               child ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "dGHkX6UyLHnRC41skHHfYF3afPAfKQCTZvkdAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ZaQoAAA=");
    }
    public void replaceChild(org.w3c.dom.Node parent,
                             org.w3c.dom.Node newChild,
                             org.w3c.dom.Node oldChild) {
        
    }
    public static class ReplaceChildCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldParent;
        protected org.w3c.dom.Node oldNextSibling;
        protected org.w3c.dom.Node newNextSibling;
        protected org.w3c.dom.Node parent;
        protected org.w3c.dom.Node child;
        public ReplaceChildCommand(java.lang.String commandName,
                                   org.w3c.dom.Node parent,
                                   org.w3c.dom.Node sibling,
                                   org.w3c.dom.Node child) {
            super(
              );
            setName(
              commandName);
            this.
              oldParent =
              child.
                getParentNode(
                  );
            this.
              oldNextSibling =
              child.
                getNextSibling(
                  );
            this.
              parent =
              parent;
            this.
              child =
              child;
            this.
              newNextSibling =
              sibling;
        }
        public void execute() { if (newNextSibling !=
                                      null) {
                                    parent.
                                      insertBefore(
                                        child,
                                        newNextSibling);
                                }
                                else {
                                    parent.
                                      appendChild(
                                        child);
                                } }
        public void undo() { if (oldParent !=
                                   null) {
                                 oldParent.
                                   insertBefore(
                                     child,
                                     oldNextSibling);
                             }
                             else {
                                 parent.
                                   removeChild(
                                     child);
                             } }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (parent ==
                                               null ||
                                               child ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "KgxHXnbDIhtk3LdZlzbv/wfnVdoF8R0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public void removeChild(org.w3c.dom.Node parent,
                            org.w3c.dom.Node child) {
        historyBrowser.
          addCommand(
            createRemoveChildCommand(
              parent,
              child));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.RemoveChildCommand createRemoveChildCommand(org.w3c.dom.Node parent,
                                                                                                                org.w3c.dom.Node child) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.RemoveChildCommand(
          getRemoveChildCommandName(
            parent,
            child),
          parent,
          child);
    }
    public static class RemoveChildCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node parentNode;
        protected org.w3c.dom.Node childNode;
        protected int indexInChildrenArray;
        public RemoveChildCommand(java.lang.String commandName,
                                  org.w3c.dom.Node parentNode,
                                  org.w3c.dom.Node childNode) {
            super(
              );
            setName(
              commandName);
            this.
              parentNode =
              parentNode;
            this.
              childNode =
              childNode;
        }
        public void execute() { indexInChildrenArray =
                                  org.apache.batik.dom.util.DOMUtilities.
                                    getChildIndex(
                                      childNode,
                                      parentNode);
                                parentNode.
                                  removeChild(
                                    childNode);
        }
        public void undo() { org.w3c.dom.Node refChild =
                               parentNode.
                               getChildNodes(
                                 ).
                               item(
                                 indexInChildrenArray);
                             parentNode.insertBefore(
                                          childNode,
                                          refChild);
        }
        public void redo() { parentNode.removeChild(
                                          childNode);
        }
        public boolean shouldExecute() { if (parentNode ==
                                               null ||
                                               childNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL16eezs1nUe33vSk/Ri60nyIle1ZEl+TmNP8OOQnI1Q6obk" +
           "LBzODDmcIYfDSWKZ+zLchttwJlXrGEhkxIFjJ7LjbEIQ2IlrKHZiJG2ANoWK" +
           "LM6OugjaJEDioCjQtKnR+I8siNuml5zf/hbZrtEB5g5577n3nu/ec75zl3nl" +
           "S9D9SQzVotDbWV6YHhlFeuR6zaN0FxnJETNuTpU4MXTKU5JEAHnPa8/+/M2/" +
           "/sqH7UeuQtdX0BuUIAhTJXXCIJkZSejlhj6Gbp7l9jzDT1LokbGr5AqcpY4H" +
           "j50kfW4MfdO5qil0a3yiAgxUgIEKcKUCTJxJgUqvN4LMp8oaSpAmG+ifQVfG" +
           "0PVIK9VLoWcuNhIpseIfNzOtEIAWHizfFwBUVbmIoadPsR8w3wb4ozX4pR95" +
           "zyOfuwbdXEE3nWBeqqMBJVLQyQp6nW/4qhEnhK4b+gp6NDAMfW7EjuI5+0rv" +
           "FfRY4liBkmaxcTpIZWYWGXHV59nIvU4rscWZlobxKTzTMTz95O1+01MsgPXN" +
           "Z1gPCPtlPgB4wwGKxaaiGSdV7ls7gZ5Cb7tc4xTjrREQAFUf8I3UDk+7ui9Q" +
           "QAb02GHuPCWw4HkaO4EFRO8PM9BLCj1x10bLsY4Uba1YxvMp9JbLctNDEZB6" +
           "qBqIskoKvemyWNUSmKUnLs3Sufn5EvttH/rugA6uVjrrhuaV+j8IKj11qdLM" +
           "MI3YCDTjUPF17xp/THnzr3zgKgQB4TddEj7I/Kt/+uVv/9anXv3Ng8w/vIMM" +
           "p7qGlj6vfUJ9+Atvpd6JXyvVeDAKE6ec/AvIK/OfHpc8V0TA89582mJZeHRS" +
           "+OrsN+T3fdr4i6vQjSF0XQu9zAd29KgW+pHjGfHACIxYSQ19CD1kBDpVlQ+h" +
           "B8Dz2AmMQy5nmomRDqH7vCrreli9gyEyQRPlED0Anp3ADE+eIyW1q+cigiDo" +
           "MfCFHoeg+16Eqs/hN4XWsB36BqxoSuAEITyNwxJ/AhtBqoKxtWEVWP0aTsIs" +
           "BiYIh7EFK8AObOO4QImiBE5yS43DbWLEMA3oIIx35OF1eGK8R6XRRf9/uytK" +
           "9I9sr1wBE/PWy7TgASk69HQjfl57KSN7X/7M879z9dRNjscthUZAg6ODBkeV" +
           "BkelBkdnGhzdRYNbM8MPc4OyHQ9MqO8rgQ5duVLp8sZSuYOBgOldA6IATbzu" +
           "nfPvYt77gWevAcuMtveBuSlF4bszOXVGLcOKQDVg39CrH99+z+Kf169CVy9S" +
           "cgkIZN0oq09LIj0lzFuXXfFO7d588c//+rMfeyE8c8oLHH/MFbfXLH392ctD" +
           "H4eaoQP2PGv+XU8rv/T8r7xw6yp0HyAQQJqpAowc8NFTl/u44PPPnfBnieV+" +
           "ANgMY1/xyqIT0ruR2mBiznIqm3i4en4UjPHN0gmeAd7w48deUf2WpW+IyvSN" +
           "BxsqJ+0Sioqf//E8+sk//P3/hlXDfULlN88Fx7mRPneOPsrGblZE8eiZDQix" +
           "YQC5P/n49Ic/+qUXv6MyACDx9jt1eKtMgTmVsRAM8/f+5uaPvvinn/iDq2dG" +
           "k4L4mameoxWnIB8sMT18D5Cgt28+0wfQjwd8srSaW2Lgh7pjOorqGaWV/q+b" +
           "70B+6X986JGDHXgg58SMvvW1GzjL/wck9L7fec/fPFU1c0Urw9/ZmJ2JHTj1" +
           "DWctE3Gs7Eo9iu/5D0/+6OeVnwTsDBgxcfZGRXLXqjG4ViF/E1imVDXLSHd0" +
           "iHSnBaVXbzHtSA/9IzbUK39Hq7mGK5l3VelROU5Vk1BV1iyTtyXnfeaiW55b" +
           "3TyvffgP/vL1i7/8t1+uQF5cHp03kYkSPXewyjJ5ugDNP36ZIGglsYFc41X2" +
           "Ox/xXv0KaHEFWtQAQyZcDCisuGBQx9L3P/DH/+5X3/zeL1yDrvahG16o6H2l" +
           "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" +
           "9azDs9P46kT10csXcedP48/OWqHyxObJu92VVqc1n3j/Sy/r3CeRq8dn1O9J" +
           "oevHV9hn7dwHmnnX3Y+lJtU98dnB6eff/9+fEN5tv/druEV62yUlLzf5Lyav" +
           "/Nbgm7UfugpdOz1Gve0G+2Kl5y4ent6IjTSLA+HCEeqTF29yngRQf/p4WH/6" +
           "8tne2Xze+WDvWw72cI/z/x+8R9lHyuT7U+gBozC0LDXueDCTh45+ZlEffK0z" +
           "mfN9VBkvXoT7BID5qWO4n/rGw335HmU/VSY/CiBlgV7dOP/wGa4f+0bg+swx" +
           "rs9843F9+h5lr5TJJwGu2LgN18/8P+B6vMy8BfB87hjX577xuP7lPcp+uUx+" +
           "IYVen9hh5um9uxvpA2oYeoYSnOH+3NeCu0ihx26/+j65eOt8vdfpgMDects/" +
           "ew7/RtE+8/LNBx9/WfxP1e3x6T9GHhpDD5qZ552/fzn3fD2KDdOpxuahw21M" +
           "VP38Wgo9/VpKptCNs5cK2q8eKn8+hd50x8rAoMqf87K/fXwNeV42he6vfs/L" +
           "/R7o7UwOsPvh4bzIv0+ha0CkfPxC9NUPNaEmaaxoqQhc+HA/W81VceViBDq1" +
           "g8deyw7OBa23X4g21V+3TiJDdvjz1vPaZ19m2O/+cuuTh9tzzVP2+7KVB8fQ" +
           "A4eL/NPo8sxdWztp6zr9zq88/PMPveMkDD58UPjMqc7p9rY7X1X3/CitLpf3" +
           "v/z4L37bz778p9Wx/f8FljHTgFMnAAA=");
    }
    public void setNodeValue(org.w3c.dom.Node contextNode,
                             java.lang.String newValue) {
        historyBrowser.
          addCommand(
            createChangeNodeValueCommand(
              contextNode,
              newValue));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.ChangeNodeValueCommand createChangeNodeValueCommand(org.w3c.dom.Node contextNode,
                                                                                                                        java.lang.String newValue) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.ChangeNodeValueCommand(
          getChangeNodeValueCommandName(
            contextNode,
            newValue),
          contextNode,
          newValue);
    }
    public static class ChangeNodeValueCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node contextNode;
        protected java.lang.String newValue;
        public ChangeNodeValueCommand(java.lang.String commandName,
                                      org.w3c.dom.Node contextNode,
                                      java.lang.String newValue) {
            super(
              );
            setName(
              commandName);
            this.
              contextNode =
              contextNode;
            this.
              newValue =
              newValue;
        }
        public void execute() { java.lang.String oldNodeValue =
                                  contextNode.
                                  getNodeValue(
                                    );
                                contextNode.
                                  setNodeValue(
                                    newValue);
                                newValue =
                                  oldNodeValue;
        }
        public void undo() { execute(); }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "NCEoBmImAAA=");
    }
    public org.apache.batik.apps.svgbrowser.AbstractCompoundCommand getCurrentCompoundCommand() {
        if (currentCompoundCommand ==
              null) {
            currentCompoundCommand =
              createCompoundUpdateCommand(
                OUTER_EDIT_COMMAND);
        }
        return currentCompoundCommand;
    }
    public void addToCurrentCompoundCommand(org.apache.batik.apps.svgbrowser.AbstractUndoableCommand cmd) {
        getCurrentCompoundCommand(
          ).
          addCommand(
            cmd);
        historyBrowser.
          fireDoCompoundEdit(
            new org.apache.batik.apps.svgbrowser.HistoryBrowser.HistoryBrowserEvent(
              getCurrentCompoundCommand(
                )));
    }
    public void performCurrentCompoundCommand() {
        if (getCurrentCompoundCommand(
              ).
              getCommandNumber(
                ) >
              0) {
            historyBrowser.
              addCommand(
                getCurrentCompoundCommand(
                  ));
            historyBrowser.
              fireCompoundEditPerformed(
                new org.apache.batik.apps.svgbrowser.HistoryBrowser.HistoryBrowserEvent(
                  currentCompoundCommand));
            currentCompoundCommand =
              null;
        }
    }
    private java.lang.String getNodeAsString(org.w3c.dom.Node node) {
        java.lang.String id =
          "";
        if (node.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE) {
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                node;
            id =
              e.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVGConstants.
                    SVG_ID_ATTRIBUTE);
        }
        if (id.
              length(
                ) !=
              0) {
            return node.
              getNodeName(
                ) +
            " \"" +
            id +
            "\"";
        }
        return node.
          getNodeName(
            );
    }
    private java.lang.String getBracketedNodeName(org.w3c.dom.Node node) {
        return "(" +
        getNodeAsString(
          node) +
        ")";
    }
    private java.lang.String getAppendChildCommandName(org.w3c.dom.Node parentNode,
                                                       org.w3c.dom.Node childNode) {
        return "Append " +
        getNodeAsString(
          childNode) +
        " to " +
        getNodeAsString(
          parentNode);
    }
    private java.lang.String getInsertBeforeCommandName(org.w3c.dom.Node parentNode,
                                                        org.w3c.dom.Node childNode,
                                                        org.w3c.dom.Node siblingNode) {
        return "Insert " +
        getNodeAsString(
          childNode) +
        " to " +
        getNodeAsString(
          parentNode) +
        " before " +
        getNodeAsString(
          siblingNode);
    }
    private java.lang.String getRemoveChildCommandName(org.w3c.dom.Node parent,
                                                       org.w3c.dom.Node child) {
        return "Remove " +
        getNodeAsString(
          child) +
        " from " +
        getNodeAsString(
          parent);
    }
    private java.lang.String getChangeNodeValueCommandName(org.w3c.dom.Node contextNode,
                                                           java.lang.String newValue) {
        return "Change " +
        getNodeAsString(
          contextNode) +
        " value to " +
        newValue;
    }
    private java.lang.String getNodeChangedCommandName(org.w3c.dom.Node node) {
        return "Node " +
        getNodeAsString(
          node) +
        " changed";
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CbDs2Flevzv7eDybl7HH9nhsj7dp+6lXdTdjA2qtLalb" +
       "ai29gXlWa+lWa19bLWeCMQSbQBknjB1CsCkKE5bYDCFhKwoygSLgwgkxwQES" +
       "FoelwhICThWGiiHkqLvv8u6778483/d8q/S37tE5R//3nf/85z/S0fnEn5fu" +
       "iMJS2ffszcL24st6Fl9e2c3L8cbXo8s02+SVMNI11FaiSAJpV9TX/+gDX/ji" +
       "h5YPHpTunJVeoriuFyux6bmRoEeeneoaW3rgOBW3dSeKSw+yKyVVoCQ2bYg1" +
       "o/gptvSiE0Xj0hPsoQoQUAECKkBbFSDkOBco9GLdTRy0KKG4cRSU/mHpElu6" +
       "01cL9eLS666uxFdCxdlXw28RgBruLv4fAVDbwllYevwI+w7zNYA/XIae+Wdf" +
       "9+CP3VZ6YFZ6wHTFQh0VKBGDm8xK9zm6M9fDCNE0XZuVHnJ1XRP10FRsM9/q" +
       "PSs9HJkLV4mTUD8iqUhMfD3c3vOYufvUAluYqLEXHsEzTN3WDv+7w7CVBcD6" +
       "8mOsO4REkQ4A3msCxUJDUfXDIrdbpqvFpdeeLnGE8QkGZABF73L0eOkd3ep2" +
       "VwEJpYd3bWcr7gIS49B0FyDrHV4C7hKXHr1upQXXvqJaykK/EpdecTofv7sE" +
       "ct2zJaIoEpdedjrbtibQSo+eaqUT7fPng3d88D0u5R5sddZ01S70vxsUeuxU" +
       "IUE39FB3VX1X8L4n2Y8oL//ZDxyUSiDzy05l3uX5yX/w+a9+22PP/fIuz6vO" +
       "yMPNV7oaX1E/Pr//M69G39q5rVDjbt+LzKLxr0K+NX9+f+WpzAc97+VHNRYX" +
       "Lx9efE74D9P3/rD+Zwele3ulO1XPThxgRw+pnuObth6SuquHSqxrvdI9uquh" +
       "2+u90l3gnDVdfZfKGUakx73S7fY26U5v+z+gyABVFBTdBc5N1/AOz30lXm7P" +
       "M79UKt0FjtJ94Hhjafe3/Y1LFrT0HB1SVMU1XQ/iQ6/AH0G6G88Bt0toDqze" +
       "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" +
       "aTbU6x3YaDX7GjpZJO1uNkm7XGXiJHra");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Mhk+SNDKiJKlDN3IDGtqfqsaweyg2nM7eZhEzRrtmC4+4DsGTLmwnm/qC6Vp" +
       "erVwGfeWI79vJth0Q+qDwO7Nmt22MKymUl3IUq0+7uVVHbI2VXuM9KO5kIVr" +
       "idDHQUWOkWovSgS+gmRDmyFsKxpY40k2FtKEMqVYTWYDVWbLc3amqdhq3Mz5" +
       "SgeeN0IRg1erVZ/oYy5Fg6meJqSIr4+E9bhKKl10AZNl29NTJYSqWW6GrVre" +
       "zpsTYwKhLTrLproama4hYuGEXse4rcLLhJR42Gg20kZDsLqTNStZ1Nj2OyDo" +
       "0eR4ggXAEDO/DGxyrRpJjvL5ptmm2hiOiivcrgRkr8WOaAzqN9qiv+B0H6qH" +
       "qwy3qnSlpRLOEBrW8TI/1oI+bTZnVN9Z5utZHbKndUeuJUi9V4s6dK1c1uYb" +
       "Y6SONshw7kPRivehVU9eChjTmdXYFe2TCphH+HKWd7qGvZi1mjrXZgJeFlYp" +
       "2dPqgTqiOHfWmrL8ZCBIIC6dMXHXCgkObqX9KWnDlA2ir1RdpA3a5TTBTefA" +
       "D9BeS6zE2pgIyKmNw6tkETWMAJ9bzoTtwY2ZmnuT5iblw/Uo4QRWmU70URlX" +
       "RxPONVoVFhrpZkJvRNUeM41mnA9iCp80DQol0p5dl5lUafc4JXRwq96utpxh" +
       "xeuaeEWYGhJnUaJR1aeb9XISNSKsrnMTQsynjuQhkdsSzZofVmd2m+rT02SN" +
       "udYmDQ17s1ZSpEXrTUbswHQ1pTujrEzOVwrU5ggwBRzGOEWNOMkZaCZb1qYr" +
       "HuPb+SRPkPXQ1dme5Fpuc1hLytEMF7t2rTeWXdQnxa5u00It64nhYNVXRc5s" +
       "2jnHTVgdgVymShvDylJIZrALJQmtVbQRUZlTE64VDwNC7DudnmfVakmjK8D1" +
       "iGSrnr5sE8RIyFR7oukuMYxraJVv1Xmj5uQ5MehA9jrJylUs8sdiGUdadabf" +
       "kp0whFuGYw4WaLtK0WUlrEowDFxmCs/Z1EiEFgi+Pc6HhrWmynMDnkJypAyN" +
       "EAwr9yxfqLrRmnbg6YDt8AtG1+ylSm/s9SbKDXzc4bplAZ9s0gaXzVU/EFYi" +
       "Uhljs3DTr5HJsEOgZZHwujo7yydgyABzWoijI5HuTDKGcsXljHFlLCM38mbh" +
       "d3EY7i1xX+puKu1GfenbDV3KjJRZd2Vq3ZmkoOt5iQS8FJbomrbBnG7D71TC" +
       "JtzxHQqrYHxzmiw3i75an2X6IMrd+crE3RGgyW64ArNpVCAhYeyN6SN+WEnG" +
       "PJkOSNLPIKsCGp4ic5GrdLhgZc8qdpQQbG3QWNQ1K2RB/Dvtu6o3Gdaibj2u" +
       "qM24roPwVczHTrtsRpNl3KTaIoz3s6xbGzaC+WgBW5V2i4vQJZVinOXzgU63" +
       "YDzT0TygGuG4idZm6XqurpowwQwtWLBWET+l8rbTl4xQrPFwtUXhNIBt99fN" +
       "Oh/V9Fo/hIbjsG0iPinnvSi18y48zxvhIsDk6TQtT+BsDZkY6OJyFQQXC1Oy" +
       "bHZFVaQVBHMJ1LXsqLYBwYSLU3VeySGLxROlYnfFbFLlYGRVlmeBuPKJBdQX" +
       "Vd8LhoiVdH1VWlel1azTtShoggsiVWF5MHNFa2u5o7Ryst+qJXEurMzcbQlE" +
       "FiB107TKHYuvtxrldD7P7XqHMiohx/Si1gAegOkvsRGlziJfR5UGE00MyqkT" +
       "dJMYd+Zl3ZX9zTQVa9WxC88mNW4xbq9rOS3XGtjaHvhqsFlWa6E07thG2egN" +
       "xHI7DqCGX2+ZtQrRRkw51xwBGqP9mQQvrca0ueik8xpvEXYdhv0JZNUTuKn1" +
       "oRXNdkxXbJhlagJ3VSgY6nwoOB24PS/DgjBpilUrYHohubZJwYDIlU7oiZgR" +
       "ZNWtbGgFrdIBylr4krJWbD2XO2TQFdZQ32403BEvjiB8LvqSPGNB+6V1OxjR" +
       "M3IGnOpyU5/mM2kRSP2EYeorbkyk62FfyHujFZq0GZmC26yF6bMa0W9hlMwi" +
       "MQXI9MtKq9doduqEljQazXbIR6Oc5FydmFeNusWDgLYsLxCkeK3zMzf2Zu2h" +
       "7QvDo5XwX8Krwv3SgkK88egN7fbvztKp1dMn3tCeWCBXKt6SveZ6C9y3b8g+" +
       "/r5nPqZx31892C8s/Im4dE/s+W+39VS3T1T1ZlDTk9d/G9jfru8/XvD2S+/7" +
       "00elr1y++wYWBL/2lJ6nq/yh/ic+Rb5J/acHpduOlr9d8+XB1YWeunrR272h" +
       "HiehK1219O01Vy/K7Zd2a0NKh78n330ft93ZL77fsmv7U+s2Lx1nqGwzfOac" +
       "hZ3/pRCfjksvi/TirfepdaHbIv/6hN38eFy6PfVM7dig/uPzvaI8ecdtwqeO" +
       "GCgW5ZfeDI7lnoHlTWeA3Wb43DkM/H4h/ntcepUa6kqsH776l31t99/JFQSD" +
       "L3VN/BPXr3bL4m9fgMXXFYkdcER7FqObyuLRCscC+7quXtY853KxRGZb6H+f" +
       "w+z/KcSfxKVX7JgtyqC7tU0n1lX84TEJf3pREr4CHF+/J+Hrby4JJ9/+X+2N" +
       "BGW9dXFX1J8efu4zH82f/cTu5f5cAV2qVL7e52DXfpFWfETwxnM+hDj+UOiv" +
       "yK947k/+YPSuQyf6oiManipQY+fRcNicZy03B5cuHWxr/NvrN+ulO4rEv45L" +
       "rzxu1ggLPd+/Xrv+zUVdRLFo8dv2gL7t5hv33x3drXpoRefd7dLBEU+XHjiH" +
       "p5cU4t649MSOJ2G7nkzU7e0KrOJriC1zZ1J26UUXoGw7ruDg+MgexEduiT+o" +
       "PK8vlF3N230QsYW4JeU15xBWRB6XXhGXXu0Dp+mFzpk+syj42WOiXnkBoh4t" +
       "EsvgeHZP1LM3h6iTmMrnXHt7Id4EIreFHl+7oO4jxyDffFFr4MDx3B7kczcH" +
       "5G3HwehfHIstrtY5mDuFqMWl+1xg/L39eulTbVq/ANzXFonFAttf3cP91VsO" +
       "Fz0HLl6Ir7zKVx6CPhVasF9yaHG9SrdcftVFTWcAaHlkV3b3e0u5HJ7DpVgI" +
       "Ni69qDAd4Xh17gnL6V8A7WNFIgwUf9Me7ZtuOdp3nYP2SiEmVwVPe8ynDIe5" +
       "kOGcUeeWyef9QuL57Ka/JWXHpH9zmLx9m+H2owjmZEBafJ6vu9vP9NhjsWXS" +
       "Oofl4pPhS0Zcul85/A5l+/X7KbNa3IQ5zqVv2pPxTTeVjEI9+yzUm3NQv6cQ" +
       "8dGUB7kK+02b8ly/2i2pyUUtrAn4+YM9qZ/78pD6/nNI/ZZCvA/Mk45M6Wwf" +
       "9Y0XNaa3Aghf2OP+wpcH93ecg/vDhfhgXHrNKWM621vxFzen67msb7+oQQHn" +
       "fzDZlT2Qbg6xd2wz3HEWscfsfu857H5fIb4bxIhHVnW4ZP6UWX30omb1JEDt" +
       "7tG7X0b0nzwH/bOF+MG49Ngp2zrk4JRxDS9uXGfVvOX3hy5qXWBuefDZPb+/" +
       "fnP4PR1anGD1Z85h9WcL8RPAU6lLJcSUWLmOSf3kTfBUB3+0h/xHtxzyL50D" +
       "+VOF+PkjJ4WeAn7TnNR5FW85/YWLmlEDoN9/EHnbNR9EfmmcHmwzHBxxugtO" +
       "P3sOnb9RiP8MQnHAS7Fty9K0TxvPZ25CKH7bvuzu91YB/R/nAP2DQvz2URSO" +
       "HMO9aVH4derckvg7F7UWCpD3wT2JH7w1PfAEk39xDpOfL8SfgoFs95H0Fm9X" +
       "N7xQP2U4f3YBzK8qEutAu4/vMX/8lmP+4jmY/64QXziynt4x8uOHWZceO4b+" +
       "1xeA/oYiEZS77af20H/qVkM/uOv60A/uKcTBkcPdQS8mnLs2v2kO97yKC04P" +
       "brtoFyJBYLx/AHL7LX8AcvCyczh9pBAPxqX7Qt0vNnE6w+0ePHQTxpfb/T3c" +
       "mzRvP9PtHrzuHKRvKMSrwfiy+wj7LKCvuQnjy+1P74E+fSuBvv0coFAh3nLk" +
       "IYRjuDdtfLlOnVsS33pRa/kqQN7P70n8+VtD4ja4O3jqHBLfWQgY9ItI33qC" +
       "7T42p8ylddFY9i0A4Wf2SD9zK5GS5yDtFaIbl159FMa6C/0I8imT4S4SxV6v" +
       "3i2Z6EXHqXeAWeF9u7K734uTeZIm+Zxr40LwcemVCz1Gz9wuoCj1Pcdgn3fP" +
       "mxcQg93x6B7sozcH7KlXcS98Y4MzXskdKOewVXSjg6+NS69SNE3yrs/XiZ72" +
       "rovyBQGentjz9cTNNw7vnGtBIVYgajl8A/lCAFsXAPySIvH1AOh+b5g7rtkb" +
       "5vkAE8+3AmY3CL3nHNRPFyKNSw8sdv4TiY63sGKPca4vivPNAB+zx8ncIpzn" +
       "PKE9KJ7QHrwvLr0U4OyC3mDpsa4VgAf7NVsnwF7kKe0W7NsAyP3DxN3vxcGe" +
       "HV6c82z2oHg2e/DBnbO7dp55BuyLPEPdwn47gLtfzXXHDa/mOhv2OdHy95yD" +
       "/XsL8V1x6VGAfTdLuGqGcAb4593X5YW0ebYHn93KNv9X5+D+ZCH+5a7Nr439" +
       "zoD9AxeFXQFwv3kP+5tvDexdaPST58D+6UL8GHDdxbh+ZvxyBvR/czNa/EN7" +
       "6B+6OdCvcWm/cA7qXyzEz+0a+9r1dWcg/nc3gjiLS49cJ0Ysdix9xTUbju82" +
       "yVZ/5GMP3P3Ix+Tf2O5ze7SR9T1s6W4jse2T20KeOL/TD3XD3FJyz1be728h" +
       "fjouPf588U1cuvf4nwLGwa/sCv9qXHrZmYXj0u3Fz8m8v7Zf43gyb1y6Y/t7" +
       "Mt9nwd2O88WlO3cnJ7P8Zly6DWQpTn/LP4zSTuyptNtWM9sFcK84aV/bBXMP" +
       "P18jnVhu/YarVgxud4o/XNCc8PuFic9+jB685/Pw9+/271VtJc+LWu5mS3ft" +
       "thLeVlosin7ddWs7rOtO6q1fvP9H73nj4drD+3cKH9v6Cd1ee/Zmubjjx9v1" +
       "hvlPPfJv3/EDH/vd7aZS/x+08ULQwl8AAA==");
}
