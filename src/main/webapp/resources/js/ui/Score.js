
Ext.define('ui.Score', {
	extend: 'Ext.panel.Panel',
	frame:false,
	border:true,
	containerScroll:true,

	initComponent: function(){
		
		this.items = [ {
			xtype: 'panel',
			title: 'Tuesday Scores',
			id: 'tuesScores',
			height: 200,
			store: this.store,
			title: 'Final Score',
			items: [{
				xtype: 'displayfield',
				fieldLabel: 'Home',
				name: 'home_score',
				value: '10'
			}, {
				xtype: 'displayfield',
				fieldLabel: 'Visitor',
				name: 'visitor_score',
				value: '11'
			}]
		}];

		this.callParent(arguments);
	}
});