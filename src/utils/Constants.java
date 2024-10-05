package utils;

import java.awt.Dimension;

public class Constants {

    public static final String SEPARATOR = ";";
    public static final String APP_TITLE = "Exosky!";

    private Constants() {
    }

    public static final class TAP {
        public static final String URL = "https://exoplanetarchive.ipac.caltech.edu/TAP";

        private TAP() {
        }
    }

    public static final class Path {

        public static final String SEPARATOR = "/";

        public static final class Assets {
            public static final String LOGO = getPath("logo.png");

            private Assets() {
            }

            private static String getPath(String fileName) {
                return SEPARATOR + String.join(SEPARATOR, new String[] { "assets", fileName });
            }
        }

        private Path() {
        }
    }

    public static final class GUI {
        public static final Integer FRAME_WIDTH = 1400;
        public static final Integer FRAME_HEIGHT = 900;
        public static final Dimension WIDGET_DIMENSION = new Dimension(300, 40);

        private GUI() {
        }
    }

    public static final class DefaultData {
        public static final String NAME = "Tommaso Bocchietti";

        private DefaultData() {
        }

        @Override
        public String toString() {
            return String.join(Constants.SEPARATOR, new String[] { NAME });
        }
    }

}
