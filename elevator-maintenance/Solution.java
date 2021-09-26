import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {
    public static String[] solution(String[] l) {
        List<Version> versions = new ArrayList<>();
        for (String versionStr: l) {
            versions.add(new Version(versionStr));
        }
        versions.sort(Version::compare);
        return versions.stream().map(Version::toString)
            .collect(Collectors.toList()).toArray(new String[0]);
    }
}

class Version {
    private int major = -1;
    private int minor = -1;
    private int revision = -1;
    private String displayValue;
    
    public Version(String versionStr) {
        displayValue = versionStr;
        String[] values = versionStr.split("\\.");
        if (values.length == 1) {
            major = Integer.parseInt(values[0]);
        } else if (values.length == 2) {
            major = Integer.parseInt(values[0]);
            minor = Integer.parseInt(values[1]);
        } else {
            major = Integer.parseInt(values[0]);
            minor = Integer.parseInt(values[1]);
            revision = Integer.parseInt(values[2]);
        }
    }
    
    public int compare(Version givenVersion) {
        if (major > givenVersion.getMajor()) {
            return 1;
        } else if (major < givenVersion.major) {
            return -1;
        }
        if (minor > givenVersion.minor) {
            return 1;
        } else if (minor < givenVersion.minor) {
            return -1;
        }
        if (revision > givenVersion.revision) {
            return 1;
        } else if (revision < givenVersion.revision) {
            return -1;
        }
        return 0;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getRevision() {
        return revision;
    }
    
    public String toString() {
        return displayValue;
    }
    
}