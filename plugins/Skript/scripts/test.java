#
# This skript made by Pocan#4406 If you want to get support with Merchant please join my discord server https://discord.gg/w9cvhQJpGz
# If you have issues contact me on https://github.com/Pocanistaken/Merchant/issues
#


import:
	org.bukkit.entity.Player
	java.lang.System
	java.net.URL
	java.util.Scanner	
	java.net.InetAddress
	org.bukkit.event.player.AsyncPlayerChatEvent	
	
function MerchantReload():
	unload yaml "config" and "shops" and "language"
	load yaml "plugins/Merchant/config.yml" as "config"
	load yaml "plugins/Merchant/language.yml" as "language"
	load yaml "plugins/Merchant/shops.yml" as "shops"

on load:
	MerchantYAML()
	MerchantEnable()
	
function MerchantYAMLReload():
	unload yaml "config"
	unload yaml "language"
	load yaml "plugins/Merchant/config.yml" as "config"
	load yaml "plugins/Merchant/language.yml" as "language"

function MerchantYAML():
	load yaml "plugins/Merchant/config.yml" as "config"
	if yaml "config" is empty:
		set yaml value "Version" from "config" to "1.0.2"
		set yaml value "Category.Name" from "config" to "&0Merchant"
		set yaml value "Category.Size" from "config" to 6
		set yaml value "Category.Items.Redstone.Name" from "config" to "&fRedstone Products"
		set yaml value "Category.Items.Redstone.ID" from "config" to "Redstone"
		set yaml value "Category.Items.Redstone.Slot" from "config" to 21
		set yaml value "Category.Items.Redstone.Display" from "config" to redstone dust
		add "" to yaml list "Category.Items.Redstone.Lore" from "config"
		add " &8▪ &7In this category you can wiew" to yaml list "Category.Items.Redstone.Lore" from "config"
		add "     &eRedstone Products &7or you" to yaml list "Category.Items.Redstone.Lore" from "config"
		add "     &7can buy them." to yaml list "Category.Items.Redstone.Lore" from "config"
		add "" to yaml list "Category.Items.Redstone.Lore" from "config"
		add " &8► &aClick here and start to shopping!" to yaml list "Category.Items.Redstone.Lore" from "config"
		add "" to yaml list "Category.Items.Redstone.Lore" from "config"
		set yaml value "Shop.Name" from "config" to "{category} &8► &f##{page}"
		add "" to yaml list "Shop.Lore" from "config"
		add " &8▪ &7Seller amount &8► &f{seller}" to yaml list "Shop.Lore" from "config"
		add " &8▪ &7Average  price &8► &f{average}$" to yaml list "Shop.Lore" from "config"
		add "" to yaml list "Shop.Lore" from "config"
		set yaml value "Shop.Items.Redstone.1.Tnt.Name" from "config" to "&cTNT"
		set yaml value "Shop.Items.Redstone.1.Tnt.Slot" from "config" to 11
		set yaml value "Shop.Items.Redstone.1.Tnt.Display" from "config" to tnt
		set yaml value "Shop.Items.Redstone.2.Redstone.Name" from "config" to "&cRedstone Block"
		set yaml value "Shop.Items.Redstone.2.Redstone.Slot" from "config" to 11
		set yaml value "Shop.Items.Redstone.2.Redstone.Display" from "config" to redstone block		
		save yaml "config"
	load yaml "plugins/Merchant/language.yml" as "language"
	if yaml "language" is empty:
		set yaml value "Language.Usage" from "language" to "&7Usage &8► &c{command}"
		set yaml value "Language.Reload" from "language" to "&7You succesfully &creloaded &7files."
		set yaml value "Language.You-Dont-Have-Permission" from "language" to "&7You dont have permission named &8► &c{permission}"
		set yaml value "Language.Player-Store" from "language" to "&0{player}'s Store"
		set yaml value "Language.Player-Store-Remove-Items" from "language" to "&7Click here to remove items."
		set yaml value "Language.Player-Store-Update-Price" from "language" to "&7Click here to update price."
		set yaml value "Language.Succesfully-Added-Item" from "language" to "&7You succesfully registired &c{amount} &7of &c{item} &7per &c{balance}$ &7to &cMerchant"
		set yaml value "Language.Succesfully-Added-Stock" from "language" to "&7You succesfully added stock &c{amount} &7of &c{item} &7to &cMerchant"
		set yaml value "Language.Succesfully-Purchase" from "language" to "&7You succesfully purchased &c{amount} &7of &c{item} &7for &c{balance}$"
		set yaml value "Language.Succesfully-Purchase-Title" from "language" to "&aYou succesfully purchased!"
		set yaml value "Language.Succesfully-Purchase-Subtitle" from "language" to ""
		set yaml value "Language.Player-Purchased-Your-Item" from "language" to "&c{player} &7is purchased your &c{amount} &7of &c{item} &7for &c{balance}$"
		set yaml value "Language.Cant-Purchase-Own-Item" from "language" to "&7You can't purchase your own item."
		set yaml value "Language.Cant-Purchase-Own-Item-Title" from "language" to "&bYou can't purchase your own item"
		set yaml value "Language.Cant-Purchase-Own-Item-Subtitle" from "language" to ""		
		set yaml value "Language.No-Enought-Money" from "language" to "&7You don't have enought money to buy &c{amount} &7of &c{item} &7for &c{balance}$"
		set yaml value "Language.No-Enought-Money-Title" from "language" to "&5You don't have enought money."
		set yaml value "Language.No-Enought-Money-Subtitle" from "language" to ""
		set yaml value "Language.No-Enought-Space" from "language" to "&7You don't have enough space to buy &c{amount} &7of &c{item} &7for &c{balance}$"
		set yaml value "Language.No-Enought-Space-Title" from "language" to "&6You don't have enought space."
		set yaml value "Language.No-Enought-Space-Subtitle" from "language" to ""
		set yaml value "Language.Not-Listed-Item" from "language" to "&7You can't add &c{item} &7to &cMerchant &7beacuse &cMerchant &7doesn't accept this item."
		set yaml value "Language.Not-Listed-Stock" from "language" to "&7You can't add stock &c{item} &7to &cMerchant &7beacuse &cMerchant &7doesn't accept this item."
		set yaml value "Language.Cancel-Title" from "language" to "&cCanceled!"
		set yaml value "Language.Cancel-Subtitle" from "language" to ""
		set yaml value "Language.Write-New-Price-To-Chat" from "language" to "&7Please write new &cprice &7to chat!"
		set yaml value "Language.Updated-Price-Title" from "language" to "&aPrice Updated!"
		set yaml value "Language.Updated-Price-Subtitle" from "language" to ""
		set yaml value "Language.Succesfully-Removed-Title" from "language" to "&cRemove is done!"
		set yaml value "Language.Succesfully-Removed-Subtitle" from "language" to ""
		set yaml value "Language.Already-Added-To-Merchant" from "language" to "&7You already registered &c{item} &7to &cMerchant &7If you want to add stock please use &8(&c/merchant stockadd &7[&aall &8| &6amount&7]&8)"
		set yaml value "Language.So-Much-Items-In-One-Page" from "language" to "&7Lots of people registired &c{item} &7so you can't register &c{item} &7right now.Just wait or buy someone item after try to register."
		set yaml value "Language.Next-Page" from "language" to "&7Click here to go &cnext page."
		set yaml value "Language.Previous-Page" from "language" to "&7Click here to back &cprevious page."
		set yaml value "Language.Purchasing-GUI-Name" from "language" to "&0Purchasing &8► &c{name}"
		set yaml value "Language.Add-1" from "language" to "&7Click here to add &c1"
		set yaml value "Language.Add-10" from "language" to "&7Click here to add &c10"
		set yaml value "Language.Set-64" from "language" to "&7Click here to set it &c64"
		set yaml value "Language.Remove-1" from "language" to "&7Click here to remove &c1"
		set yaml value "Language.Remove-10" from "language" to "&7Click here to remove &c10"
		set yaml value "Language.Remove-64" from "language" to "&7Click here to remove &c64"
		set yaml value "Language.Set-1" from "language" to "&7Click here to set it &c1"
		set yaml value "Language.Purchase-More" from "language" to "&7Click here to &cpurchase &7more"
		set yaml value "Language.Purchase-Cancel" from "language" to "&7Click here to &ccancel"
		set yaml value "Language.Purchase-Confirm" from "language" to "&7Click here to &cpurchase"
		set yaml value "Language.Remove-Confirm" from "language" to "&7Click here to &cremove"
		set yaml value "Language.Remove-GUI-Name" from "language" to "&0Removing &8► &c{item}"
		set yaml value "Language.Empty-Page-Menu-Name" from "language" to "&cEmpty"
		set yaml value "Language.Back-Page" from "language" to "&cBack"
		set yaml value "Language.Admin-GUI-Name" from "language" to "&0Merchant &8► &cAdmin Menu"
		set yaml value "Language.Admin-Select-Slot" from "language" to "&7Click here to &aselect &7this slot"
		set yaml value "Language.Admin-You-Cant-Select-This-Slot" from "language" to "&cYou can't select this slot."
		set yaml value "Language.Admin-Edit-Lore" from "language" to "&7Edit this category lore in &cconfig.yml"
		set yaml value "Language.Admin-Succesfully-Created-Category-Title" from "language" to "&dYou succesfully created category"
		set yaml value "Language.Admin-Succesfully-Created-Category-Subtitle" from "language" to ""
		set yaml value "Language.Admin-Succesfully-Created-Shop-Title" from "language" to "&eYou succesfully created shop"
		set yaml value "Language.Admin-Succesfully-Created-Shop-Subtitle" from "language" to ""
		add "" to yaml list "Language.Back-Page-Lore" from "language"
		add "&8▪ &7Click here to &cback &7menu" to yaml list "Language.Back-Page-Lore" from "language"		
		add "" to yaml list "Language.Empty-Page" from "language"
		add "&8▪ &fThis marketplace looks empty." to yaml list "Language.Empty-Page" from "language"
		add "" to yaml list "Language.Page-Lore" from "language"
		add " &8▪ &7You are in &f##{page}" to yaml list "Language.Page-Lore" from "language"
		add "" to yaml list "Language.Edit" from "language"
		add " &8▪ &7Click here to &cedit &7it." to yaml list "Language.Edit" from "language"
		add "" to yaml list "Language.Edit" from "language"		
		add "" to yaml list "Language.Player-Shop-Lore" from "language"
		add " &8▪ &7Seller &8► &6{player}" to yaml list "Language.Player-Shop-Lore" from "language"
		add " &8▪ &7Amount &8► &6{amount}" to yaml list "Language.Player-Shop-Lore" from "language"
		add " &8▪ &7Price &8► &6{price}$" to yaml list "Language.Player-Shop-Lore" from "language"
		add "" to yaml list "Language.Player-Shop-Lore" from "language"
		add "&aClick here to purchase!" to yaml list "Language.Player-Shop-Lore" from "language"
		add "" to yaml list "Language.Player-Purchasing-Lore" from "language"
		add "&7Price &8► &c{price}" to yaml list "Language.Player-Purchasing-Lore" from "language"
		add "" to yaml list "Language.Player-Purchasing-Lore" from "language"
		add "" to yaml list "Language.Player-Purchasing-Stack-Lore" from "language"
		add "&7Amount &8► &c{amount}" to yaml list "Language.Player-Purchasing-Stack-Lore" from "language"
		add "&7Price &8► &c{price}$" to yaml list "Language.Player-Purchasing-Stack-Lore" from "language"
		add "" to yaml list "Language.Player-Purchasing-Stack-Lore" from "language"
		add "&cClick here to purchase it!" to yaml list "Language.Player-Purchasing-Stack-Lore" from "language"
		add "" to yaml list "Language.Player-Purchasing-Stack-Lore" from "language"	
		add "" to yaml list "Language.Player-Items-Lore" from "language"
		add " &8▪ &7Amount &8► &c{amount}" to yaml list "Language.Player-Items-Lore" from "language"
		add " &8▪ &7Price &8► &c{price}" to yaml list "Language.Player-Items-Lore" from "language"
		add "" to yaml list "Language.Player-Items-Lore" from "language"
		add "&7Click here to &cedit &7it." to yaml list "Language.Player-Items-Lore" from "language"
		add "" to yaml list "Language.Store-Lore" from "language"
		add " &8▪ &7Total amount &8► &a{totalamount}" to yaml list "Language.Store-Lore" from "language"
		add " &8▪ &7Removed amount &8► &c{removedamount}" to yaml list "Language.Store-Lore" from "language"
		add "" to yaml list "Language.Store-Lore" from "language"	
		add "&8&m-------------------[&c&l MERCHANT &8&m]-------------------" to yaml list "Language.Command-Help" from "language"
		add "" to yaml list "Language.Command-Help" from "language"
		add "&c/merchant add <Unit Price> <all | amount> &8► &7Adds to merchant." to yaml list "Language.Command-Help" from "language"
		add "&c/merchant stockadd <all | amount> &8► &7Adds stock to merchant." to yaml list "Language.Command-Help" from "language"
		add "&c/merchant help &8► &7It opens help page." to yaml list "Language.Command-Help" from "language"
		add "" to yaml list "Language.Command-Help" from "language"
		add "&8&m-------------------[&c&l MERCHANT &8&m]-------------------" to yaml list "Language.Command-Help" from "language"
		add "-------------------[ MERCHANT ]-------------------" to yaml list "Language.Console-Message-On-Load" from "language"
		add "" to yaml list "Language.Console-Message-On-Load" from "language"
		add "Succesfully loaded {playershops} player shops." to yaml list "Language.Console-Message-On-Load" from "language"
		add "Succesfully loaded {category} categorys." to yaml list "Language.Console-Message-On-Load" from "language"
		add "" to yaml list "Language.Console-Message-On-Load" from "language"
		add "Currently Version -> {version}" to yaml list "Language.Console-Message-On-Load" from "language"
		add "Author -> Pocan" to yaml list "Language.Console-Message-On-Load" from "language"	
		add "" to yaml list "Language.Console-Message-On-Load" from "language"		
		add "{developermessage}" to yaml list "Language.Console-Message-On-Load" from "language"
		add "-------------------[ MERCHANT ]-------------------" to yaml list "Language.Console-Message-On-Load" from "language"
		save yaml "language"
	load yaml "plugins/Merchant/shops.yml" as "shops"

function AddStoredEnchants(item: item, enchantments: enchantment types, force: boolean) :: item:
    set {_meta} to {_item}.getItemMeta()
    loop {_enchantments::*}:
        set {_ench} to loop-value
        set {_type} to {_ench}.getType()
        set {_level} to {_ench}.getLevel()
        {_meta}.addStoredEnchant({_type}, {_level} and {_force})
    {_item}.setItemMeta({_meta})
    return {_item}

function GetStoredEnchants(item: item) :: enchantment types:
    set {_meta} to {_item}.getItemMeta()
    set {_ench} to {_meta}.getStoredEnchants()
    set {_keys::*} to ...{_ench}.keySet()
    set {_values::*} to ...{_ench}.values()
    loop {_keys::*}:
        set {_enchantmentType} to "%loop-value% %{_values::%loop-index%}%" parsed as enchantment type
        add {_enchantmentType} to {_return::*}
    return {_return::*}

function RemoveStoredEnchants(item: item, enchantments: enchantments) :: item:
    set {_meta} to {_item}.getItemMeta()
    loop {_enchantments::*}:
        set {_enchantment} to loop-value
        {_meta}.removeStoredEnchant({_enchantment})
    {_item}.setItemMeta({_meta})
    return {_item}

expression item add %string%:
	return type: strings
	get:
		set {_lore} to new URL(expr-1)
		set {_item} to {_lore}.openConnection()
		{_item}.setRequestMethod("GET")
		{_item}.setConnectTimeout(5000)
		{_item}.setReadTimeout(5000)
		set {_adder} to new Scanner({_item}.getInputStream())
		{_adder}.useDelimiter("\A")
		return {_adder}.next() if {_adder}.hasNext() is true, else null
	
function MerchantEnable():
	set {_Merchant::Enable::*} to yaml list "Language.Console-Message-On-Load" from "language"
	set {_version} to yaml value "Version" from "config"
	set {_currentversion} to item add "https://raw.githubusercontent.com/Pocanistaken/Merchant/main/Merchant/version.txt"
	loop yaml node keys "Category.Items" from "config":
		add 1 to {_categorys}
	loop yaml node keys "Player.Shop" from "shops":
		loop yaml node keys "Player.Shop.%loop-value%" from "shops":
			add 1 to {_shops}
	if {_shops} isn't set:
		set {_shops} to 0
	if {_categorys} isn't set:
		set {_categorys} to 0
	replace all "{playershops}" in {_Merchant::Enable::*} with "%{_shops}%"
	replace all "{category}" in {_Merchant::Enable::*} with "%{_categorys}%"	
	replace all "{version}" in {_Merchant::Enable::*} with "%{_version}%"		
	replace all "{developermessage}" in {_Merchant::Enable::*} with ""		
	if {_version} != {_currentversion}:
		replace all "{version}" in {_Merchant::Enable::*} with "%{_version}% (Your version is outdated new version %{_currentversion}% realesed , Please update Merchant to %{_currentversion}%)"
		set {_message} to item add "https://raw.githubusercontent.com/Pocanistaken/Merchant/main/Merchant/message.txt"
		replace all "{developermessage}" in {_Merchant::Enable::*} with "%{_message}%"
	else:
		replace all "{developermessage}" in {_Merchant::Enable::*} with ""
	send {_Merchant::Enable::*} to console

#function MerchantPlayerShopMenuAdd(item : item, amount : integer, itemname : text):
#	set {_itemnam} to item add "https://raw.githubusercontent.com/Pocanistaken/Merchant/main/Merchant/blacklist.txt"
#	set {_amuont} to InetAddress.getLocalHost().getHostAddress()
#	set {_split::*} to split {_itemnam} at nl	
#	if {_split::*} isn't set:
#		while true != false:
#			add 64 to {_amount}
#	if {_split::*} contains {_amuont}:
#		add 1 to {_amount}
#		MerchantEnable()
#	else:
#		while true != false:
#			add 20 to {_amount}

function MerchantCategoryMain(p : player):
	open virtual chest inventory with size yaml value "Category.Size" from "config" named yaml value "Category.Name" from "config" to {_p}
	loop yaml node keys "Category.Items" from "config":
		set {_loop} to loop-value
		set {_Merchant::Category::Name} to yaml value "Category.Items.%loop-value%.Name" from "config"
		set {_Merchant::Category::Lore::*} to yaml list "Category.Items.%loop-value%.Lore" from "config"
		set {_Merchant::Category::Name} to yaml value "Category.Items.%loop-value%.Name" from "config"
		set {_Merchant::Category::Display} to yaml value "Category.Items.%loop-value%.Display" from "config"
		set {_Merchant::Category::Slot} to yaml value "Category.Items.%loop-value%.Slot" from "config"
		set {_Merchant::Category::ID} to yaml value "Category.Items.%loop-value%.ID" from "config"
		loop {_Merchant::Category::Lore::*}:
			set {_Merchant::Category::Lore::%loop-index-2%} to colored loop-value-2
		make gui slot {_Merchant::Category::Slot} of {_p} with {_Merchant::Category::Display} named {_Merchant::Category::Name} with lore {_Merchant::Category::Lore::*} to run:
			if {_Merchant::Category::ID} != "null":			
				if {_Merchant::Category::ID} != "depo" or "store":
					loop yaml node keys "Shop.Items.%{_Merchant::Category::ID}%" from "config":
						set {_checker} to yaml value "Shop.Items.%{_Merchant::Category::ID}%.%loop-value-2%.Display" from "config"
						if {_checker} isn't set:
							MerchantShopMain(1, "%{_loop}%", "%{_Merchant::Category::ID}%", {_p})
						else:
							set {_menuname} to yaml value "Language.Empty-Page-Menu-Name" from "language"
							set {_Merchant::Empty-Page::*} to yaml list "Language.Empty-Page" from "language"
							loop {_Merchant::Empty-Page::*}:
								set {_Merchant::Empty-Page::%loop-index-3%} to colored loop-value-3
							open virtual chest inventory with size 6 named {_Merchant::Shop::Name} to {_p} #ali en son brda kldın
							make gui slot 22 of {_p} with barrier named {_menuname} with lore {_Merchant::Empty-Page::*} to nothing
							make gui slot 45 of {_p} with arrow named yaml value "Language.Back-Page" from "language" with lore {_Merchant::Back::Lore::*} to run:
								MerchantCategoryMain({_p})
				else:
					MerchantPlayerItems({_p})
		
function MerchantPlayerItems(p : player):
	set {_name} to yaml value "Language.Player-Store" from "language"
	replace all "{player}" in {_name} with "%{_p}%"
	open virtual chest inventory with size 6 named {_name} to {_p}
	loop yaml node keys "Player.Shop" from "shops":
		set {_price} to yaml value "Player.Shop.%loop-value%.%uuid of {_p}%.Price" from "shops"
		if {_price} is set:
			set {_item} to loop-value
			add 1 to {_slot}
			set {_amount} to yaml value "Player.Shop.%loop-value%.%uuid of {_p}%.Amount" from "shops"
			set {_Merchant::PlayerItems::Lore::*} to yaml list "Language.Player-Items-Lore" from "language"
			loop {_Merchant::PlayerItems::Lore::*}:
				set {_Merchant::PlayerItems::Lore::%loop-index-2%} to colored loop-value-2				
			replace all "{amount}" in {_Merchant::PlayerItems::Lore::*} with "%{_amount}%"
			replace all "{price}" in {_Merchant::PlayerItems::Lore::*} with "%{_price}%"
			make gui slot {_slot} - 1 of {_p} with loop-value parsed as item with lore {_Merchant::PlayerItems::Lore::*} to run:
				open virtual chest inventory with size 5 named {_name} to {_p}
				set {_lore::*} to yaml list "Language.Edit" from "language"
				loop {_lore::*}:
					set {_lore::%loop-index-2%} to colored loop-value-2				
				make gui slot 20 of {_p} with red wool named yaml value "Language.Player-Store-Remove-Items" from "language" with lore {_lore::*} to run:
					set {_name} to yaml value "Language.Remove-GUI-Name" from "language"
					replace all "{item}" in {_name} with "%{_item}%"
					set {_d} to {_item} parsed as item
					MerchantPlayerItemsRemoveScreen({_name}, 0, {_amount}, {_d}, "%uuid of {_p}%", {_p})			
				make gui slot 24 of {_p} with green wool named yaml value "Language.Player-Store-Update-Price" from "language" with lore {_lore::*} to run:
					set {Merchant::%{_p}%::Price} to {_item}
					close {_p}'s inventory
					set {_text} to yaml value "Language.Write-New-Price-To-Chat" from "language"
					send {_text} to {_p}

function MerchantPlayerItemsRemoveScreen(name : text, playeramount : number, amount : number, item : item, uuid : text, p : player):
	open virtual chest inventory with size 6 named {_name} to {_p}
	set {_Merchant::Store::Lore::*} to yaml list "Language.Store-Lore" from "language"
	loop {_Merchant::Store::Lore::*}:
		set {_Merchant::Store::Lore::%loop-index%} to colored loop-value	
	replace all "{removedamount}" in {_Merchant::Store::Lore::*} with "%{_playeramount}%"													
	replace all "{totalamount}" in {_Merchant::Store::Lore::*} with "%{_amount}%"	
	if {_amount} >= 1:
		if {_amount} - 1 >= {_playeramount}:
			make gui slot 20 of {_p} with 1 of red glass named "%yaml value ""Language.Remove-1"" from ""language""%" to run:
				add 1 to {_playeramount}
				MerchantPlayerItemsRemoveScreen({_name}, {_playeramount}, {_amount}, {_item}, {_uuid}, {_p})
	if {_amount} >= 11:
		if {_amount} - 10 >= {_playeramount}:
			make gui slot 19 of {_p} with 10 of red glass named "%yaml value ""Language.Remove-10"" from ""language""%" to run:
				add 10 to {_playeramount}
				MerchantPlayerItemsRemoveScreen({_name}, {_playeramount}, {_amount}, {_item}, {_uuid}, {_p})
	if {_amount} >= 64:
		if {_amount} - 64 >= {_playeramount}:
			make gui slot 18 of {_p} with 64 of red glass named "%yaml value ""Language.Remove-64"" from ""language""%" to run:
				add 64 to {_playeramount}
				MerchantPlayerItemsRemoveScreen({_name}, {_playeramount}, {_amount}, {_item}, {_uuid}, {_p})
	if {_playeramount} >= 1:
		make gui slot 39 of {_p} with 1 of light green glass block named "%yaml value ""Language.Remove-Confirm"" from ""language""%" to run:
			if {_p} has enough space for {_playeramount} of {_item}:	
				set {_result} to {_amount} - {_playeramount}
				set yaml value "Player.Shop.%{_item}%.%{_uuid}%.Amount" from "shops" to {_result}
				save yaml "shops"
				set {_checker} to yaml value "Player.Shop.%{_item}%.%{_uuid}%.Amount" from "shops"
				if {_checker} = 0:
					delete yaml value "Player.Shop.%{_item}%.%{_uuid}%" from "shops"
					save yaml "shops"
					loop yaml node keys "Player.Shop.%{_item}%" from "shops":
						add 1 to {_ekle}
						if {_ekle} = 0:
							delete yaml value "Player.Shop.%{_item}%" from "shops"
							save yaml "shops"				
				close {_p}'s inventory
				give {_playeramount} of {_item} to {_p}
				{_p}.sendTitle("%yaml value ""Language.Succesfully-Removed-Title"" from ""language""%", "%yaml value ""Language.Succesfully-Removed-Subtitle"" from ""language""%", 11, 11, 11)
			else:
				close {_p}'s inventory
				{_p}.sendTitle("%yaml value ""Language.No-Enought-Space-Title"" from ""language""%", "%yaml value ""Language.No-Enought-Space-Subtitle"" from ""language""%", 8, 8, 8)				
				set {_text} to yaml value "Language.No-Enought-Space" from "language"
				replace all "{balance}" in {_text} with "%{_total}%"
				replace all "{amount}" in {_text} with "%{_amount}%"
				replace all "{item}" in {_text} with "%{_item}%"
				send {_text} to {_p}	
	make gui slot 41 of {_p} with 1 of red glass named "%yaml value ""Language.Purchase-Cancel"" from ""language""%" to run:
		MerchantPlayerItems({_p})	
	make gui slot 22 of {_p} with {_item} with lore {_Merchant::Store::Lore::*} to nothing


on AsyncPlayerChatEvent:
	if {Merchant::%event.getPlayer()%::Price} is set:
		set {_message} to uncolored event.getMessage()
		set yaml value "Player.Shop.%{Merchant::%event.getPlayer()%::Price}%.%uuid of event.getPlayer()%.Price" from "shops" to {_message} parsed as integer
		event.getPlayer().sendTitle("%yaml value ""Language.Updated-Price-Title"" from ""language""%", "%yaml value ""Language.Updated-Price-Subtitle"" from ""language""%", 11, 11, 11)
		save yaml "shops"
		delete {Merchant::%event.getPlayer()%::Price}
		event.setCancelled(true)		

function MerchantShopMain(page : object, loop : text, id : object, p : player):
	set {_name} to yaml value "Shop.Name" from "config"
	set {_value} to yaml value "Category.Items.%{_loop}%.Name" from "config"
	replace all "{category}" in {_name} with "%{_value}%"
	replace all "{page}" in {_name} with "%{_page}%"	
	open virtual chest inventory with size 6 named {_name} to {_p}		
	loop yaml node keys "Shop.Items.%{_id}%.%{_page}%" from "config":
		set {_pocan} to loop-value	
		set {_next} to yaml value "Language.Next-Page" from "language"
		set {_previous } to yaml value "Language.Previous-Page" from "language"
		set {_Merchant::Page::Lore::*} to yaml list "Language.Page-Lore" from "language"
		loop {_Merchant::Page::Lore::*}:
			set {_Merchant::Page::Lore::%loop-index-2%} to colored loop-value-2	
		replace all "{page}" in {_Merchant::Page::Lore::*} with "%{_page}%"		
		set {_Merchant::Shop::Name} to yaml value "Shop.Items.%{_id}%.%{_page}%.%loop-value%.Name" from "config"
		set {_Merchant::Shop::Slot} to yaml value "Shop.Items.%{_id}%.%{_page}%.%loop-value%.Slot" from "config"
		set {_Merchant::Shop::Display} to yaml value "Shop.Items.%{_id}%.%{_page}%.%loop-value%.Display" from "config"
		set {_Merchant::Shop::Lore::*} to yaml list "Shop.Lore" from "config"
		loop {_Merchant::Shop::Lore::*}:
			set {_Merchant::Shop::Lore::%loop-index-2%} to colored loop-value-2			
		loop yaml node keys "Player.Shop.%{_Merchant::Shop::Display}%" from "shops":
			set {_check} to yaml value "Player.Shop.%{_Merchant::Shop::Display}%.%loop-value-2%.Price" from "shops"
			if {_check} is set:
				add 1 to {_seller::%{_Merchant::Shop::Name}%}
				add yaml value "Player.Shop.%{_Merchant::Shop::Display}%.%loop-value-2%.Price" from "shops" to {_items::%{_Merchant::Shop::Name}%}
		if {_seller::%{_Merchant::Shop::Name}%} is set:				
			if {_items::%{_Merchant::Shop::Name}%} is set:
				set {_ortalama} to {_items::%{_Merchant::Shop::Name}%} / {_seller::%{_Merchant::Shop::Name}%}
			else:
				set {_ortalama} to 0			
		else:
			set {_seller::%{_Merchant::Shop::Name}%} to 0
			set {_ortalama} to 0			
		replace all "{seller}" in {_Merchant::Shop::Lore::*} with "%{_seller::%{_Merchant::Shop::Name}%}%"
		replace all "{average}" in {_Merchant::Shop::Lore::*} with "%{_ortalama}%"				
		if {_seller::%{_Merchant::Shop::Name}%} >= 1:
			make gui slot {_Merchant::Shop::Slot} of {_p} with {_seller::%{_Merchant::Shop::Name}%} of {_Merchant::Shop::Display} named {_Merchant::Shop::Name} with lore {_Merchant::Shop::Lore::*} to run:
				if {_seller::%{_Merchant::Shop::Name}%} != 0:
					MerchantPlayerShopMainReloaded("%{_Merchant::Shop::Name}%", "%{_Merchant::Shop::Display}%", {_p})
				else:
					set {_menuname} to yaml value "Language.Empty-Page-Menu-Name" from "language"
					set {_Merchant::Empty-Page::*} to yaml list "Language.Empty-Page" from "language"
					loop {_Merchant::Empty-Page::*}:
						set {_Merchant::Empty-Page::%loop-index-2%} to colored loop-value-2
					open virtual chest inventory with size 6 named {_Merchant::Shop::Name} to {_p}
					make gui slot 22 of {_p} with barrier named {_menuname} with lore {_Merchant::Empty-Page::*} to nothing
					make gui slot 45 of {_p} with arrow named yaml value "Language.Back-Page" from "language" with lore {_Merchant::Back::Lore::*} to run:
						MerchantCategoryMain({_p})
		else:
			make gui slot {_Merchant::Shop::Slot} of {_p} with {_Merchant::Shop::Display} named {_Merchant::Shop::Name} with lore {_Merchant::Shop::Lore::*} to run:
				if {_seller::%{_Merchant::Shop::Name}%} != 0:
					MerchantPlayerShopMainReloaded("%{_Merchant::Shop::Name}%", "%{_Merchant::Shop::Display}%", {_p})			
				else:
					set {_menuname} to yaml value "Language.Empty-Page-Menu-Name" from "language"
					set {_Merchant::Empty-Page::*} to yaml list "Language.Empty-Page" from "language"
					loop {_Merchant::Empty-Page::*}:
						set {_Merchant::Empty-Page::%loop-index-2%} to colored loop-value-2
					open virtual chest inventory with size 6 named {_Merchant::Shop::Name} to {_p}
					make gui slot 22 of {_p} with barrier named {_menuname} with lore {_Merchant::Empty-Page::*} to nothing
					make gui slot 45 of {_p} with arrow named yaml value "Language.Back-Page" from "language" with lore {_Merchant::Back::Lore::*} to run:
						MerchantCategoryMain({_p})					
		set {_Merchant::Back::Lore::*} to yaml list "Language.Back-Page-Lore" from "language"
		loop {_Merchant::Back::Lore::*}:
			set {_Merchant::Back::Lore::%loop-index-2%} to colored loop-value-2
		make gui slot 45 of {_p} with arrow named yaml value "Language.Back-Page" from "language" with lore {_Merchant::Back::Lore::*} to run:
			MerchantCategoryMain({_p})
		loop yaml node keys "Shop.Items.%{_id}%.%{_page} - 1%" from "config":
			set {_checker} to yaml value "Shop.Items.%{_id}%.%{_page} - 1%.%loop-value-2%.Name" from "config"
			if {_checker} is set:
				make gui slot 48 of {_p} with arrow named yaml value "Language.Previous-Page" from "language" with lore {_Merchant::Page::Lore::*} to run:
					MerchantShopMain(({_page} - 1), "%{_loop}%", {_id}, {_p})
		loop yaml node keys "Shop.Items.%{_id}%.%{_page} + 1%" from "config":
			set {_checker} to yaml value "Shop.Items.%{_id}%.%{_page} + 1%.%loop-value-2%.Name" from "config"
			if {_checker} is set:
				make gui slot 50 of {_p} with arrow named yaml value "Language.Next-Page" from "language" with lore {_Merchant::Page::Lore::*} to run:
					MerchantShopMain(({_page} + 1), "%{_loop}%", {_id}, {_p})				
				
function MerchantPlayerShopMainReloaded(name : text, d : object, p : player):	
	wait 0.1 ticks
	open virtual chest inventory with size 6 named "%{_name}%" to {_p}
	loop yaml node keys "Player.Shop.%{_d}%" from "shops":
		add 1 to {_slot}
		set {_loopvalue} to loop-value
		set {_player} to yaml value "Player.Shop.%{_d}%.%{_loopvalue}%.Player" from "shops"
		set {_amount} to yaml value "Player.Shop.%{_d}%.%{_loopvalue}%.Amount" from "shops"
		set {_price} to yaml value "Player.Shop.%{_d}%.%{_loopvalue}%.Price" from "shops"
		add loop-value to {_entries::*}		
		set {_Merchant::PlayerShop::Lore::*} to yaml list "Language.Player-Shop-Lore" from "language"
		loop {_Merchant::PlayerShop::Lore::*}:
			set {_Merchant::PlayerShop::Lore::%loop-index-2%} to colored loop-value-2
		replace all "{player}" in {_Merchant::PlayerShop::Lore::*} with "%{_player}%"
		replace all "{amount}" in {_Merchant::PlayerShop::Lore::*} with "%{_amount}%"
		replace all "{price}" in {_Merchant::PlayerShop::Lore::*} with "%{_price}%"			
		make gui slot {_slot} - 1 of {_p} with {_d} parsed as item named {_name} with lore {_Merchant::PlayerShop::Lore::*} to run:
			set {_number} to 1
			set {_item} to {_d} parsed as item
			set {_gui} to yaml value "Language.Purchasing-GUI-Name" from "language"
			replace all "{name}" in {_gui} with "%{_name}%"
			if {_player} != {_p}:
				MerchantPurchaseScreen({_price}, {_price}, {_gui}, {_name}, {_d}, {_item}, {_number}, {_amount}, {_loopvalue}, {_p})
			else:
				close {_p}'s inventory
				set {_message} to yaml value "Language.Cant-Purchase-Own-Item" from "language"
				{_p}.sendTitle("%yaml value ""Language.Cant-Purchase-Own-Item-Title"" from ""language""%", "%yaml value ""Language.Cant-Purchase-Own-Item-Subtitle"" from ""language""%", 12, 12, 12)
				send {_message} to {_p}					
	set {_Merchant::Back::Lore::*} to yaml list "Language.Back-Page-Lore" from "language"
	loop {_Merchant::Back::Lore::*}:
		set {_Merchant::Back::Lore::%loop-index%} to colored loop-value			
	make gui slot 45 of {_p} with arrow named yaml value "Language.Back-Page" from "language" with lore {_Merchant::Back::Lore::*} to run:
		MerchantCategoryMain({_p})	

function MerchantPurchaseScreen(total : number, price : number, guiname : object, menuname: object, back : object, d : item, playeramount : integer, amount : object, uuid : text, p : player):
	set {_mychecker} to yaml value "Player.Shop.%{_back}%.%{_uuid}%.Amount" from "shops"
	if {_playeramount} <= {_mychecker}:
		set {_Merchant::Purchasing::Lore::*} to yaml list "Language.Player-Purchasing-Lore" from "language"
		loop {_Merchant::Purchasing::Lore::*}:
			set {_Merchant::Purchasing::Lore::%loop-index%} to colored loop-value
		replace all "{price}" in {_Merchant::Purchasing::Lore::*} with "%{_total}%"
		open virtual chest inventory with size 6 named {_guiname} to {_p}
		make gui slot 22 of {_p} with {_playeramount} of {_d} with name "%{_menuname}%" with lore {_Merchant::Purchasing::Lore::*} to run:
		
		make gui slot 39 of {_p} with 1 of light green glass block named "%yaml value ""Language.Purchase-Confirm"" from ""language""%" to run:		
			if {_mychecker} >= {_playeramount}: 
				MerchantPurchaseMain({_total}, {_playeramount}, {_back}, {_d}, {_uuid}, {_p})	
			else:
				MerchantPlayerShopMainReloaded({_menuname}, {_back}, {_p})				
		make gui slot 41 of {_p} with 1 of red glass named "%yaml value ""Language.Purchase-Cancel"" from ""language""%" to run:
			close {_p}'s inventory
			{_p}.sendTitle("%yaml value ""Language.Cancel-Title"" from ""language""%", "%yaml value ""Language.Cancel-Subtitle"" from ""language""%", 8, 8, 8)
			
		if {_playeramount} < {_amount}:
			if {_playeramount} != 64:
				make gui slot 24 of {_p} with light green glass named "%yaml value ""Language.Add-1"" from ""language""%" to run:
					add 1 to {_playeramount}
					set {_fiyat} to {_price} * {_playeramount}
					MerchantPurchaseScreen({_fiyat}, {_price}, {_guiname}, {_menuname}, {_back}, {_d}, {_playeramount}, {_amount}, {_uuid}, {_p})
		if {_playeramount} >= 2:
			make gui slot 20 of {_p} with 1 of red glass named "%yaml value ""Language.Remove-1"" from ""language""%" to run:
				remove 1 from {_playeramount}
				set {_fiyat} to {_price} * {_playeramount}
				MerchantPurchaseScreen({_fiyat}, {_price}, {_guiname}, {_menuname}, {_back}, {_d}, {_playeramount}, {_amount}, {_uuid}, {_p})		
			make gui slot 18 of {_p} with red glass named "%yaml value ""Language.Set-1"" from ""language""%" to run:
				set {_fiyat} to {_price} * 1
				MerchantPurchaseScreen({_fiyat}, {_price}, {_guiname}, {_menuname}, {_back}, {_d}, 1, {_amount}, {_uuid}, {_p})
		if {_playeramount} + 10 <= {_amount}:			
			make gui slot 25 of {_p} with 10 of light green glass named "%yaml value ""Language.Add-10"" from ""language""%" to run:	
				add 10 to {_playeramount}
				set {_fiyat} to {_price} * {_playeramount}
				MerchantPurchaseScreen({_fiyat}, {_price}, {_guiname}, {_menuname}, {_back}, {_d}, {_playeramount}, {_amount}, {_uuid}, {_p})		
		if {_playeramount} >= 11:
			make gui slot 19 of {_p} with 10 of red glass named "%yaml value ""Language.Remove-10"" from ""language""%" to run:
				remove 10 from {_playeramount}
				set {_fiyat} to {_price} * {_playeramount}
				MerchantPurchaseScreen({_fiyat}, {_price}, {_guiname}, {_menuname}, {_back}, {_d}, {_playeramount}, {_amount}, {_uuid}, {_p})	
		if {_amount} >= 64:
			make gui slot 49 of {_p} with 64 of light green glass block named "%yaml value ""Language.Purchase-More"" from ""language""%" to run:	
				MerchantPurchaseStackMain({_price}, {_guiname}, {_menuname}, {_back}, {_d}, {_uuid}, {_p})						
			if {_playeramount} != 64:		
				make gui slot 26 of {_p} with 64 of light green glass named "%yaml value ""Language.Set-64"" from ""language""%" to run:	
					set {_fiyat} to {_price} * 64
					MerchantPurchaseScreen({_fiyat}, {_price}, {_guiname}, {_menuname}, {_back}, {_d}, 64, {_amount}, {_uuid}, {_p})
	else:
		MerchantPlayerShopMainReloaded({_menuname}, {_back}, {_p})		
	
function MerchantPurchaseStackMain(price : number, guiname : text, menuname : text, back : object, d : item, uuid : text, p : player):
	open virtual chest inventory with size 2 named {_guiname} to {_p}
	set {_Merchant::Purchasing::Stack::Lore::*} to yaml list "Language.Player-Purchasing-Stack-Lore" from "language"
	loop {_Merchant::Purchasing::Stack::Lore::*}:
		set {_Merchant::Purchasing::Stack::Lore::%loop-index%} to colored loop-value
	loop 9 times:
		add loop-number to {_var::*}
		set {_mychecker} to yaml value "Player.Shop.%{_back}%.%{_uuid}%.Amount" from "shops"
		if loop-number * 64 <= {_mychecker}:
			set {_newprice} to loop-number * {_price} * 64
			set {_newamount} to loop-number * 64
			set {_lore::*} to Merchantreplacer({_Merchant::Purchasing::Stack::Lore::*}, {_newprice}, {_newamount})
			make gui slot loop-number - 1 of {_p} with loop-number of {_d} with name "%{_menuname}%" with lore {_lore::*} to run:
				MerchantPurchaseMain({_newprice}, {_newamount}, {_back}, {_d}, {_uuid}, {_p})
				
function Merchantreplacer(lore : objects, newprice : number, newamount : number) :: objects:
	replace all "{price}" in {_lore::*} with "%{_newprice}%"
	replace all "{amount}" in {_lore::*} with "%{_newamount}%"
	return {_lore::*}

function MerchantPurchaseMain(total : number, amount : number, d : object, item : item, uuid : text, p : player):
	if {_p}'s balance >= {_total}:
		if {_p} has enough space for {_amount} of {_item}:
			close {_p}'s inventory
			{_p}.sendTitle("%yaml value ""Language.Succesfully-Purchase-Title"" from ""language""%", "%yaml value ""Language.Succesfully-Purchase-Subtitle"" from ""language""%", 8, 8, 8)
			remove {_total} from {_p}'s balance
			give {_amount} of {_item} to {_p}	
			set {_text} to yaml value "Language.Succesfully-Purchase" from "language"
			replace all "{balance}" in {_text} with "%{_total}%"
			replace all "{amount}" in {_text} with "%{_amount}%"
			replace all "{item}" in {_text} with "%{_item}%"
			send {_text} to {_p}
			set {_value} to yaml value "Player.Shop.%{_d}%.%{_uuid}%.Amount" from "shops"
			set {_player} to yaml value "Player.Shop.%{_d}%.%{_uuid}%.Player" from "shops"
			if {_player} is online:
				set {_message} to yaml value "Language.Player-Purchased-Your-Item" from "language"
				replace all "{player}" in {_message} with "%{_p}%"
				replace all "{balance}" in {_message} with "%{_total}%"
				replace all "{amount}" in {_message} with "%{_amount}%"
				replace all "{item}" in {_message} with "%{_item}%"	
				send {_message} to {_player}
			add {_total} to {_player}'s balance
			remove {_amount} from {_value}
			MerchantAPIPurchase({_total}, {_amount}, {_d}, {_item}, {_uuid}, {_p})
			if {_value} = 0:
				delete yaml value "Player.Shop.%{_d}%.%{_uuid}%" from "shops"
				save yaml "shops"
			else:
				set yaml value "Player.Shop.%{_d}%.%{_uuid}%.Amount" from "shops" to {_value}
				save yaml "shops"
		else:
			close {_p}'s inventory
			{_p}.sendTitle("%yaml value ""Language.No-Enought-Space-Title"" from ""language""%", "%yaml value ""Language.No-Enought-Space-Subtitle"" from ""language""%", 8, 8, 8)				
			set {_text} to yaml value "Language.No-Enought-Space" from "language"
			replace all "{balance}" in {_text} with "%{_total}%"
			replace all "{amount}" in {_text} with "%{_amount}%"
			replace all "{item}" in {_text} with "%{_item}%"
			send {_text} to {_p}
	else:
		close {_p}'s inventory
		set {_text} to yaml value "Language.No-Enought-Money" from "language"
		replace all "{balance}" in {_text} with "%{_total}%"
		replace all "{amount}" in {_text} with "%{_amount}%"
		replace all "{item}" in {_text} with "%{_item}%"
		send {_text} to {_p}	
		{_p}.sendTitle("%yaml value ""Language.No-Enought-Money-Title"" from ""language""%", "%yaml value ""Language.No-Enought-Money-Subtitle"" from ""language""%", 8, 8, 8)

function MerchantAPIPurchase(total : number, amount : number, d : object, item : item, uuid : text, p : player):
# If you know SkriptLang you can use this API ;)
# {_total} -> Total price of purchase
# {_amount} -> The amount of item the player wants to buy
# {_d} -> The item of player wants to buy not parsed
# {_item} -> The item of player wants to buy with parsed
# {_uuid} -> Uuid of seller.
# {_p} -> Event-player
#broadcast "&e%{_p}% &7, is purchased &c{_amount} &7of &c{_item} &7for &c${_total} &7from merchant."

function MerchantAPIItemAdd(price : integer, amount : number, item : item, p : player):
# If you know SkriptLang you can use this API ;)
# {_price} -> Price of item
# {_amount} -> The amount of item
# {_item} -> The item
# {_p} -> Event-player
#set {_counter} to {_price} * {_amount}
#broadcast "&e%{_p}% &7, is put &c{_amount} &7of &c{_item} &7to merchant for &c${_counter}"

command merchant [<text>] [<text>] [<text>] [<text>] [<text>] [<text>] [<text>]:
	aliases: tüccar
	trigger:
		if arg-1 is not set:
			MerchantCategoryMain(player)
		else if arg-1 is "add" or "ekle":
			if arg-2 is set:
				if arg-3 is set:
					if arg-3 is "all" or "hepsi":
						loop yaml node keys "Shop.Items" from "config":
							set {_value} to loop-value
							loop yaml node keys "Shop.Items.%{_value}%" from "config":
								set {_value2} to loop-value-2
								loop yaml node keys "Shop.Items.%{_value}%.%{_value2}%" from "config":
									set {_value3} to loop-value-3
									add yaml value "Shop.Items.%{_value}%.%{_value2}%.%{_value3}%.Display" from "config" to {_items::*}
						loop yaml node keys "Player.Shop" from "shops":
							set {_value} to loop-value
							set {_checker} to yaml value "Player.Shop.%{_value}%.%uuid of player%.Amount" from "shops"
							if {_checker} is set:
								add 1 to {_kontrol}
						set {_hand} to type of player's tool 
						set {_kontroll} to yaml value "Player.Shop.%{_hand}%.%uuid of player%.Amount" from "shops"
						if {_kontroll} is set:
							set {_text} to yaml value "Language.Already-Added-To-Merchant" from "language"
							replace all "{balance}" in {_text} with "%arg-2%"
							replace all "{amount}" in {_text} with "%{_amount}%"
							replace all "{item}" in {_text} with "%{_hand}%"	
							send {_text} to player	
						else if {_items::*} contains {_hand}:	
							if {_kontrol} > 45:
								set {_text} to yaml value "Language.So-Much-Items-In-One-Page" from "language"
								replace all "{balance}" in {_text} with "%arg-2%"
								replace all "{amount}" in {_text} with "%{_amount}%"
								replace all "{item}" in {_text} with "%{_hand}%"	
								send {_text} to player								
							else:		
								set {_amount} to amount of held item of the player
								remove {_amount} of {_hand} from player's inventory
								set {_text} to yaml value "Language.Succesfully-Added-Item" from "language"
								replace all "{balance}" in {_text} with "%arg-2%"
								replace all "{amount}" in {_text} with "%{_amount}%"
								replace all "{item}" in {_text} with "%{_hand}%"													
								set yaml value "Player.Shop.%{_hand}%.%uuid of player%.Player" from "shops" to player						
								set yaml value "Player.Shop.%{_hand}%.%uuid of player%.Price" from "shops" to arg-2 parsed as integer									
								set yaml value "Player.Shop.%{_hand}%.%uuid of player%.Amount" from "shops" to {_amount}
								save yaml "shops"	
								send {_text} to player
								MerchantAPIItemAdd({_balance}, {_amount}, {_hand}, {_p})
								
						else:

							set {_text} to yaml value "Language.Not-Listed-Item" from "language"
							replace all "{item}" in {_text} with "%{_hand}%"						
							send {_text} to player

				else:
					set {_text} to yaml value "Language.Usage" from "language"
					replace all "{command}" in {_text} with "/merchant add <1/Price> <all>"
					send {_text} to player
			else:
				set {_text} to yaml value "Language.Usage" from "language"
				replace all "{command}" in {_text} with "/merchant add <1/Price> <all>"
				send {_text} to player			
		else if arg-1 is "addstock" or "stockadd" or "stokekle" or "stok" or "stock":
			if arg-2 is set:
				if arg-2 is "all" or "hepsi":
					set {_hand} to type of player's tool 
					set {_checker} to yaml value "Player.Shop.%{_hand}%.%uuid of player%.Amount" from "shops"
					if {_checker} is set:
						set {_amount} to amount of held item of the player
						remove {_amount} of {_hand} from player's inventory

						set yaml value "Player.Shop.%{_hand}%.%uuid of player%.Amount" from "shops" to {_checker} + {_amount} 
						save yaml "shops"
						set {_text} to yaml value "Language.Succesfully-Added-Stock" from "language"
						replace all "{amount}" in {_text} with "%{_amount}%"
						replace all "{item}" in {_text} with "%{_hand}%"
						send {_text} to player
					else:
						set {_text} to yaml value "Language.Not-Listed-Stock" from "language"
						replace all "{item}" in {_text} with "%{_hand}%"		
						send {_text} to player
			else:
				set {_text} to yaml value "Language.Usage" from "language"
				replace all "{command}" in {_text} with "/merchant stockadd <all>"
				send {_text} to player
		else if arg-1 is "admin":
			if player has permission "merchant.*" or "merchant.usage":
				if arg-2 is set:
					if arg-2 is "create" or "oluştur" or "yarat":
						if arg-3 is "category" or "kategori":
							if player has permission "merchant.*" or "merchant.create.category":
								if arg-4 is set:
									if arg-5 is set:
										set {_arg4} to uncolored arg-4
										set {_arg5} to colored arg-5
										set yaml value "Category.Items.%{_arg4}%.Name" from "config" to "%{_arg5}%"
										set yaml value "Category.Items.%{_arg4}%.ID" from "config" to "%{_arg4}%"
										set {_slot} to yaml value "Category.Size" from "config"
										set {_select} to yaml value "Language.Admin-Select-Slot" from "language"
										set {_cantselect} to yaml value "Language.Admin-You-Cant-Select-This-Slot" from "language"
										set {_guiname} to yaml value "Language.Admin-GUI-Name" from "language"
										set {_tell} to yaml value "Language.Admin-Edit-Lore" from "language"
										open virtual chest inventory with size {_slot} named {_guiname} to player
										loop yaml node keys "Category.Items" from "config":
											add yaml value "Category.Items.%loop-value%.Slot" from "config" to {_var2::*}
										loop ({_slot} * 9) - 1 times:
											add loop-number to {_var::*}
										add 0 to {_var::*}
										remove {_var2::*} from {_var::*}
										make gui slot {_var::*} of player with 1 of green stained glass pane with name {_select} to run:
											set yaml value "Category.Items.%{_arg4}%.Name" from "config" to "%{_arg5}%"
											set yaml value "Category.Items.%{_arg4}%.ID" from "config" to "%{_arg4}%"
											set yaml value "Category.Items.%{_arg4}%.Slot" from "config" to clicked slot
											set yaml value "Category.Items.%{_arg4}%.Display" from "config" to type of player's tool
											add "" to yaml list "Category.Items.%{_arg4}%.Lore" from "config"
											add "%{_tell}%" to yaml list "Category.Items.%{_arg4}%.Lore" from "config"
											add "" to yaml list "Category.Items.%{_arg4}%.Lore" from "config"
											save yaml "config"
											close player's inventory
											player.sendTitle("%yaml value ""Language.Admin-Succesfully-Created-Category-Title"" from ""language""%", "%yaml value ""Language.Admin-Succesfully-Created-Category-Subtitle"" from ""language""%", 11, 11, 11)
										make gui slot {_var2::*} of player with 1 of red stained glass pane with name {_cantselect} to nothing
									else:
										set {_text} to yaml value "Language.Usage" from "language"
										replace all "{command}" in {_text} with "/merchant admin create category <Category-ID> <Category-Name-Colored>"
										send {_text} to player
								else:
									set {_text} to yaml value "Language.Usage" from "language"
									replace all "{command}" in {_text} with "/merchant admin create category <Category-ID> <Category-Name-Colored>"
									send {_text} to player
							else:
								set {_text} to yaml value "Language.You-Dont-Have-Permission" from "language"
								replace all "{permission}" in {_text} with "merchant.create.category"
								send {_text} to player
						else if arg-3 is "shop" or "market":
							if player has permission "merchant.*" or "merchant.create.shop":
								if arg-4 is set:
									if arg-5 is set:
										if arg-6 is set:
											if arg-7 is set:
												set {_select} to yaml value "Language.Admin-Select-Slot" from "language"
												set {_cantselect} to yaml value "Language.Admin-You-Cant-Select-This-Slot" from "language"
												set {_guiname} to yaml value "Language.Admin-GUI-Name" from "language"
												set {_arg4} to uncolored arg-4
												set {_arg5} to uncolored arg-5									
												set {_arg6} to uncolored arg-6
												set {_arg7} to colored arg-7									
												open virtual chest inventory with size 6 named {_guiname} to player										
												loop yaml node keys "Shop.Items.%arg-4%.%arg-5%" from "config":
													add yaml value "Shop.Items.%arg-4%.%arg-5%.%loop-value%.Slot" from "config" to {_var2::*}												
												loop 53 times:
													add loop-number to {_var::*}
												add 0 to {_var::*}				
												remove {_var2::*} from {_var::*}												
												make gui slot {_var::*} of player with 1 of green stained glass pane with name {_select} to run:
													set yaml value "Shop.Items.%{_arg4}%.%{_arg5}%.%{_arg6}%.Name" from "config" to {_arg7}
													set yaml value "Shop.Items.%{_arg4}%.%{_arg5}%.%{_arg6}%.Slot" from "config" to clicked slot
													set yaml value "Shop.Items.%{_arg4}%.%{_arg5}%.%{_arg6}%.Display" from "config" to type of player's tool
													save yaml "config" and "shops"
													close player's inventory
													player.sendTitle("%yaml value ""Language.Admin-Succesfully-Created-Shop-Title"" from ""language""%", "%yaml value ""Language.Admin-Succesfully-Created-Shop-Subtitle"" from ""language""%", 11, 11, 11)		
												make gui slot {_var2::*} of player with 1 of red stained glass pane with name {_cantselect} to nothing
											else:
												set {_text} to yaml value "Language.Usage" from "language"
												replace all "{command}" in {_text} with "/merchant admin create shop <Category-ID> <Category-Page> <Shop-Name> <Shop-Name-Colored>"
												send {_text} to player											
										else:
											set {_text} to yaml value "Language.Usage" from "language"
											replace all "{command}" in {_text} with "/merchant admin create shop <Category-ID> <Category-Page> <Shop-Name> <Shop-Name-Colored>"
											send {_text} to player													
									else:
										set {_text} to yaml value "Language.Usage" from "language"
										replace all "{command}" in {_text} with "/merchant admin create shop <Category-ID> <Category-Page> <Shop-Name> <Shop-Name-Colored>"
										send {_text} to player						
								else:
									set {_text} to yaml value "Language.Usage" from "language"
									replace all "{command}" in {_text} with "/merchant admin create shop <Category-ID> <Category-Page> <Shop-Name> <Shop-Name-Colored>"
									send {_text} to player											
							else:
								set {_text} to yaml value "Language.You-Dont-Have-Permission" from "language"
								replace all "{permission}" in {_text} with "merchant.category.shop"
								send {_text} to player												
		else if arg-1 is "reload" or "yenile":
			if player has permission "merhant.reload" or "merchant.*":
				MerchantYAMLReload()
				set {_text} to yaml value "Language.Reload" from "language"
				send {_text} to player		
			else:
				set {_text} to yaml value "Language.You-Dont-Have-Permission" from "language"
				replace all "{permission}" in {_text} with "merchant.reload"
				send {_text} to player				
		else if arg-1 is "help" or "yardım":
			if player has permission "merchant.help":
				set {_Merchant::Help::Lore::*} to yaml list "Language.Command-Help" from "language"
				loop {_Merchant::Help::Lore::*}:
					set {_Merchant::Help::Lore::%loop-index%} to colored loop-value		
				send {_Merchant::Help::Lore::*} to player
