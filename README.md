## SidedBlacklist
Blacklist certain mods from being loaded on certain side, client or dedicated server.  
Useful for modpacks to blacklist client-side mods that doesn't declare themselves as clientSideOnly, so the pack can be installed on server without manually removing those mods.  

Coremods can't be blacklisted yet. However, the mod in the same jar of the coremod can be blacklisted.  

### Configuration
In `config/sidedblacklist.json`, for every mod needed to be disabled on certain side, add modid of it to the blacklist of that side.