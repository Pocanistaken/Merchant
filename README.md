# Merchant

Merchant puts your items for sale you can arrange these items for sale as you wish through your own store.

# Features

Fast and optimized.   
Special purchase guis.    
Register unlimited items and create categories to Merchant.   
Easy item register.   
Easy item add.    
Easy stockadd.    
Easy installation.    
Fully adjustable.   
Custom stores.    
Fully yaml based.   

# Requirements

Skript 2.5.3 -> https://github.com/SkriptLang/Skript/releases/tag/2.5.3     
Skript-reflect -> https://forums.skunity.com/resources/skript-reflect.1146/   
Skript-yaml -> https://github.com/Sashie/skript-yaml    
TuSKe -> https://github.com/szumielxd/TuSKe/releases/tag/v1.9.1   

Put this jars to /plugins

# Installation

After providing all the requirements to your server restart your server after   
Put merchant.sk to plugins/Skript/scripts in your server.   
Execute console command /sk reload merchant.sk    
After installation is done if you want if you want to Use custom menus created by me not test menus 

# Special Categorys IDS

ID: 'null' -> Returns nothing     
ID: 'store' -> Returns player's store


# MerchantAPI

If you know the SkriptLang here is functions apis for you to use as you wish

```function MerchantAPIPurchase(total : number, amount : number, d : object, item : item, uuid : text, p : player):```
```# If you know SkriptLang you can use this API ;)
# {_total} -> Total price of purchase
# {_amount} -> The amount of item the player wants to buy
# {_d} -> The item of player wants to buy not parsed
# {_item} -> The item of player wants to buy with parsed
# {_uuid} -> Uuid of seller.
# {_p} -> Event-player

