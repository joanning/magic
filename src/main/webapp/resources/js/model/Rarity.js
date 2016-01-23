Ext.define('com.pacegeeks.model.Rarity', {
	extend: 'Ext.data.Model',
	fields : [
	          {name: 'id', type: 'integer'},
	          {name: 'rarityDesc', type: 'string'}
	          ], 
	proxy : {
		type : 'rest',
		url : '/magic/rarities'
	},
	nodeParam : 'rarityDesc'
});