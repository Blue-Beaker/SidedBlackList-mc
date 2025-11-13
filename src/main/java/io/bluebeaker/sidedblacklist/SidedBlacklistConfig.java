package io.bluebeaker.sidedblacklist;

public class SidedBlacklistConfig {
    public static final String[] COMMENT = {
        "Add modid of mods to these blacklists, then they won't be loaded on the corresponding side.",
        "Coremods are not supported yet. This comment will be reset on every startup. The example entries can be removed safely."
    };
    public String[] _comment = COMMENT;
    public String[] blacklist_server = {"example_modid_1"};
    public String[] blacklist_client = {"example_modid_2"};
}