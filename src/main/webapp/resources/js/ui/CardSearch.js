Ext.define('ui.CardSearch', {
	extend: 'Ext.form.Panel',
	frame:false,
	border:true,
	containerScroll:true,
	name: 'CardSearchPanel',

	
	doSearch: function(searchGrid){
		var gridStore = searchGrid.getStore();
		searchGrid.getProxy().pageParam = 1;
		searchGrid.getProxy().startParam = 0;
		gridStore.removeAll();
		gridStore.filters.clear();
		gridStore.currentPage = 1;
		//searchGrid.params = this.getForm().getValues();
		//searchGrid.store.load();
		searchGrid.store.load({params: this.getForm().getValues()});
		
		return;
	},
	
	listeners: {
		afterRender: function(thisForm,options){
			var searchGrid = Ext.getCmp('searchCardGrid');
			
			this.keyNav = Ext.create('Ext.util.KeyNav', this.el,{
				enter: function(e){
					this.doSearch(searchGrid);
				},
				scope: this
			});
		}
	},
	
	initComponent: function(){
		var cardStore = Ext.create('Ext.data.Store', {
			pageSize : 10,
			autoLoad: false,
			model : 'com.pacegeeks.model.Card'
		});
		
		/*var artistStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.Artist' 			
		});*/
		
		var colorStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.Color' 			
		});
		
		/*var rarityStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.Rarity' 			
		});*/
		
		var subtypeStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.SubType' 			
		});
		
		var typeStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.Type' 			
		});
		
		var grid = Ext.create ('Ext.grid.GridPanel', { //This is the Search Grid
			id: 'searchCardGrid',
			pageSize: 10,
			height: 400,
			store: cardStore,
			columns: [{
				header: 'ID',
				sortable: true,
				dataIndex: 'id',
				renderer: function(value, record){
					if (value === 0) {
						return record.get('id');
					}
					return value;
				},
			
			},{
				header: 'Card Name',
				sortable: true,
				dataIndex: 'cardName',
				menuDisabled: true
			},{
				header: 'Card Converted Mana Cost',
				sortable: true,
				dataIndex: 'cardConvertedManaCost',
				menuDisabled: true
			},{
				header: 'Card Power',
				sortable: true,
				dataIndex: 'cardPower',
				menuDisabled: true
			},{
				header: 'Card Toughness',
				sortable: true,
				dataIndex: 'cardToughness',
				menuDisabled: true
			},{
				header: 'Card Colors',
				sortable: true,
				dataIndex: 'cardColors',
				menuDisabled: true
			},{
				header: 'Card Types',
				sortable: true,
				dataIndex: 'cardTypes',
				menuDisabled: true
			},{
				header: 'Card SubTypes',
				sortable: true,
				dataIndex: 'cardSubTypes',
				menuDisabled: true
			}]
			
			
		});
		/*
		//defines store
		
		me.store = cardStore;
		//sets the columns and data indexes
		var gridCols = [{ text: 'CardName',  dataIndex: 'cardName' },
		           { text: 'CardConvertedManaCost',  dataIndex: 'cardConvertedManaCost' },
		           { text: 'CardPower',  dataIndex: 'cardPower' },
		           { text: 'CardToughness',  dataIndex: 'cardToughness' },
		           { text: 'CardColors',  dataIndex: 'cardColors' },
		           { text: 'CardTypes',  dataIndex: 'cardTypes' },
		           { text: 'CardSubTypes',  dataIndex: 'cardSubTypes' }];
		me.columns = gridCols;
		*/
		//creates toolbar and puts add card button in there to add a new card record
		var addNewCardBtn = Ext.create('Ext.button.Button', {
		    text    : 'Add New Card',
		    formBind: true,
		    scope   : this,
		    handler : function(record) {
		    	var title;
		    	title = 'YES, TITLE';
		    	var addNewWindow = Ext.create('Ext.window.Window', {
				    modal: true,
				    title: title,
				    items: [{
				    	card: record,
				    	grid: grid,
				    	xtype: 'cardEditPanel'
				    }]
				});
				addNewWindow.show();
		    }
		});
		
		this.items = [{
			xtype: 'form',
			title: 'Manage Container Order Addresses',
			border: false,
			frame: false,
			scope: this,
			items: [{
				xtype: 'fieldset',
				title: 'Enter search criteria',
				layout: 'anchor',
				padding: 10,
				margin: 5,
				defaults: {
					xtype: 'container',
					anchor: '100%',
					layout: {
						type: 'hbox',
						align: 'middle'    
					}
				},
				items: [{
					items: [{
						xtype: 'textfield',
						name: 'cardName',
						flex: .75,
						fieldLabel: 'Card Name',
						labelAlign: 'right'
					},{
						xtype: 'textfield',
						name: 'cardConvertedManaCost',
						flex: .2,
						fieldLabel: 'Card Converted Mana Cost',
						labelAlign: 'right'
					},{
						xtype: 'textfield',
						name: 'cardPower',
						flex: 1,
						fieldLabel: 'Card Power',
						labelAlign: 'right'
					}]
				}, {
					items: [{
						xtype: 'textfield',
						name: 'cardToughness',
						flex: 1,
						fieldLabel: 'Card Toughness',
						labelAlign: 'right'
					},{
						xtype: 'combo',
				    	fieldLabel: 'Card Color',
				    	name: 'cardColor',
						queryMode: 'local',
						valueField: 'colorDesc',//colorDesc
					    displayField: 'colorDesc', 
						store: colorStore,
						flex: .5,
						labelAlign: 'right'
					},{
						xtype: 'combo',
						fieldLabel: 'Card Type',
						name: 'cardType',
						queryMode: 'local',
						valueField: 'typeDesc',//typeDesc
					    displayField: 'typeDesc', 
						store: typeStore,
						flex: .5,
						labelAlign: 'right'
					},{
						xtype: 'combo',
						fieldLabel: 'Card SubType',
						name: 'cardSubType',
						queryMode: 'local',
						valueField: 'subtypeDesc',//subtypeDesc
					    displayField: 'subtypeDesc', 
						store: subtypeStore,
						flex: .5,
						labelAlign: 'right'
					}]
				}]
			}, {
				xtype: 'toolbar',
				id: 'buttonbar',
				ui: 'footer',
				style: 'border: solid 1px #99BBE8; margin: 0',
				border: false,
				scope: this,
				flex:1,
				items: [{
					xtype: 'button',
					text: 'Search',
					scope:this,
					margin: '5, 5, 5, 5',
					width: 73,
					border: 1,
					handler: function (btn) {
						this.doSearch(grid);
					}
				}, {
					xtype: 'button',
					text: 'Reset Search Fields',
					scope: this,
					formBind: true,
					margin: '5, 5, 5, 5',
					width: 150,
					border: 1,
					handler: function () {
						this.getForm().getFields().each(function(field){
							if(field.getName() != 'active'){
								field.setValue(null);
							}
						});
					}
				},'->',addNewCardBtn]			    	
			}, grid]


		}];
		
	    /*this.dockedItems = [{
	        xtype: 'toolbar',
	        dock: 'top',
	        displayInfo: true,
	        items: [addNewCardBtn]
	    },{
	        xtype: 'pagingtoolbar',
	        //store: me.store,
	        dock: 'bottom',
	        displayInfo: true
	    }],*/

		this.callParent(arguments);
		//this.doSearch(grid);
	}
	
});



