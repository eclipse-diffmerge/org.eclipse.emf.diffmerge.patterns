/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.ui;

import org.eclipse.osgi.util.NLS;

/**
 * Utility class for the externalization mechanism
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.emf.diffmerge.patterns.ui.messages"; //$NON-NLS-1$
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
    // Nothing
  }

  public static String AbstractModelBasedAction_MissingPatternSupport;

  public static String AbstractModifiableTemplateElementsPage_ConfirmExcludeMany;
  public static String AbstractModifiableTemplateElementsPage_ConfirmExcludeOne;
  public static String AbstractModifiableTemplateElementsPage_CreateRole;
  public static String AbstractModifiableTemplateElementsPage_Exclude;
  public static String AbstractModifiableTemplateElementsPage_ExcludeChildrenPrompt;
  public static String AbstractModifiableTemplateElementsPage_Include;
  public static String AbstractModifiableTemplateElementsPage_IncludeChildrenPrompt;
  public static String AbstractModifiableTemplateElementsPage_IncludeAllDependencies;
  public static String AbstractModifiableTemplateElementsPage_IncludeDependencies;
  public static String AbstractModifiableTemplateElementsPage_IncludeInstancesLabel;
  public static String AbstractModifiableTemplateElementsPage_IncludeInstancesPrompt;
  public static String AbstractModifiableTemplateElementsPage_IncludeParent;
  public static String AbstractModifiableTemplateElementsPage_MapToCurrentRole;
  public static String AbstractModifiableTemplateElementsPage_MapToRole;
  public static String AbstractModifiableTemplateElementsPage_Prompt;
  public static String AbstractModifiableTemplateElementsPage_RemoveMapping;
  public static String AbstractModifiableTemplateElementsPage_SelectDependencies;
  public static String AbstractModifiableTemplateElementsPage_WarnDependencies;

  public static String AbstractMultiRoleSelectionPage_Roles;
  public static String AbstractPatternPresentationPage_Authors;
  public static String AbstractPatternPresentationPage_Catalog;
  public static String AbstractPatternPresentationPage_Close;
  public static String AbstractPatternPresentationPage_ConfirmPatternDeletion;
  public static String AbstractPatternPresentationPage_DeleteButton;
  public static String AbstractPatternPresentationPage_DeleteInstancesWithPattern;
  public static String AbstractPatternPresentationPage_Description;
  public static String AbstractPatternPresentationPage_DetectedInstances;
  public static String AbstractPatternPresentationPage_Environments;
  public static String AbstractPatternPresentationPage_Failure;
  public static String AbstractPatternPresentationPage_Image;
  public static String AbstractPatternPresentationPage_IncludeLayoutAndStyle;
  public static String AbstractPatternPresentationPage_InstancesDeletionGroup;
  public static String AbstractPatternPresentationPage_Name;
  public static String AbstractPatternPresentationPage_New;
  public static String AbstractPatternPresentationPage_Open;
  public static String AbstractPatternPresentationPage_Pattern;
  public static String AbstractPatternPresentationPage_TemplateApplicability;
  public static String AbstractPatternPresentationPage_TemplateApplicabilityOnTemplate;
  public static String AbstractPatternPresentationPage_TemplateLabel;

  public static String AbstractPatternPresentationPage_TitlePatternDeletion;
  public static String AbstractPatternPresentationPage_UseTemplate;
  public static String AbstractPatternPresentationPage_Version;
  public static String AbstractPatternWizard_ComputationJobName;
  public static String AbstractRoleSelectionPage_Add;
  public static String AbstractRoleSelectionPage_AddRoleDescription;
  public static String AbstractRoleSelectionPage_AddRoleTitle;
  public static String AbstractRoleSelectionPage_RenameRoleTitle;
  public static String AbstractRoleSelectionPage_Delete;
  public static String AbstractRoleSelectionPage_DeleteRole;
  public static String AbstractRoleSelectionPage_DeleteRoleTitle;
  public static String AbstractRoleSelectionPage_Down;
  public static String AbstractRoleSelectionPage_NewRoleName;
  public static String AbstractRoleSelectionPage_RenameRole;
  public static String AbstractRoleSelectionPage_RoleNameUniqueness;
  public static String AbstractRoleSelectionPage_RoleNonEmptiness;
  public static String AbstractRoleSelectionPage_RoleRequirement;
  public static String AbstractRoleSelectionPage_Roles;
  public static String AbstractRoleSelectionPage_Up;
  public static String AbstractRoleSpecificationPage_AllowApplyAdd;
  public static String AbstractRoleSpecificationPage_ApplyAdd;
  public static String AbstractRoleSpecificationPage_ApplyMerge;
  public static String AbstractRoleSpecificationPage_ConformityConstraint;
  public static String AbstractRoleSpecificationPage_ContainerDerivation;
  public static String AbstractRoleSpecificationPage_Description;
  public static String AbstractRoleSpecificationPage_EmptyRole;
  public static String AbstractRoleSpecificationPage_ExclusiveTarget;
  public static String AbstractRoleSpecificationPage_GeneralProperties;
  public static String AbstractRoleSpecificationPage_Mandatory;
  public static String AbstractRoleSpecificationPage_None;
  public static String AbstractRoleSpecificationPage_PreferredContainment;
  public static String AbstractRoleSpecificationPage_PromptOCLConstraint;
  public static String AbstractRoleSpecificationPage_PromptOCLQuery;
  public static String AbstractRoleSpecificationPage_PromptOCLQueryWithRoles;
  public static String AbstractRoleSpecificationPage_RoleDetails;
  public static String AbstractRoleSpecificationPage_TargetDerivation;
  public static String AbstractRoleSpecificationPage_TargetType;
  public static String AbstractTemplateElementsPage_Message;
  public static String AbstractTemplateElementsPage_TemplateElements;
  public static String AbstractTemplateElementsPage_Unique;

  public static String CloseCatalogAction_Done;
  public static String ContainmentChoiceDialog_Containment;


  public static String DiscriminatingLabelProvider_Catalog;
  public static String DiscriminatingLabelProvider_Empty;
  public static String DiscriminatingLabelProvider_Failure;
  public static String DiscriminatingLabelProvider_In;
  public static String DiscriminatingLabelProvider_Instance;
  public static String DiscriminatingLabelProvider_Template;
  public static String ElementInclusionDialog_Prompt;
  public static String ElementMappingDialog_Map;
  public static String ElementMappingDialog_Message;
  public static String ElementMappingDialog_ModelElements;
  public static String ElementMappingDialog_PatternElements;
  public static String ElementMappingDialog_Title;
  public static String ElementMappingDialog_Unmap;


  public static String HighlightAllPatternsInstances_DialogTitle;
  public static String HighlightAllPatternsInstances_DialogMessage;
  public static String HighlightAllPatternsInstances_DialogColumnHeaderInstance;
  public static String HighlightAllPatternsInstances_DialogColumnHeaderPattern;

  public static String HighlightAllPatternsInstances_NoInstanceLayoutAndStyleInformationAvailable;
  public static String HighlightAllPatternsInstances_ConsiderOpeningPatternCatalogs;
  public static String HighlightAllPatternsInstancesAction_NoElementInInstance;

  public static String InstanceChoiceDialog_InitialSelection;
  public static String InstanceChoiceDialog_InstanceOf;
  public static String InstanceChoiceDialog_NoRole;
  public static String InstanceChoiceDialog_RolePlayed;
  public static String InstanceChoiceDialog_UnknownRole;
  public static String InstanceConformityDialog_Details;
  public static String InstanceConformityDialog_DetailsGroup;
  public static String InstanceConformityDialog_DetailsDifferenceGroup;
  public static String InstanceConformityDialog_DetailsLeftGroup;
  public static String InstanceConformityDialog_DetailsRightGroup;
  public static String InstanceConformityDialog_Header;
  public static String InstanceConformityDialog_Status;
  public static String InstanceExplorerView_General;
  public static String InstanceExplorerView_Instances;
  public static String InstanceExplorerView_ManageInstances;
  public static String InstanceExplorerView_NotAvailable;
  public static String InstanceExplorerView_OpenBrowse;
  public static String InstanceExplorerView_Refresh;
  public static String InstancePanelDialog_Check;
  public static String InstancePanelDialog_CloseCatalog;
  public static String InstancePanelDialog_Conformity;

  public static String InstancePanelDialog_CreatedNodes;
  public static String InstancePanelDialog_Delete;
  public static String InstancePanelDialog_DeleteExplanation;
  public static String InstancePanelDialog_Destructive;
  public static String InstancePanelDialog_Edges;
  public static String InstancePanelDialog_Fold;
  public static String InstancePanelDialog_Header;
  public static String InstancePanelDialog_Highlight;
  public static String InstancePanelDialog_InstanceUpdateHeader;
  public static String InstancePanelDialog_InstanceUpdateSynthesis;
  public static String InstancePanelDialog_KeepElements;
  public static String InstancePanelDialog_KeepUserNames;
  public static String InstancePanelDialog_LifeCycle;
  public static String InstancePanelDialog_Message;
  public static String InstancePanelDialog_Nodes;
  public static String InstancePanelDialog_OpenCatalog;
  public static String InstancePanelDialog_Ports;
  public static String InstancePanelDialog_Rename;
  public static String InstancePanelDialog_Representation;
  public static String InstancePanelDialog_Reset;
  public static String InstancePanelDialog_RestoreLayout;
  public static String InstancePanelDialog_RestoreStyle;
  public static String InstancePanelDialog_ReuseLayoutAtUpdate;
  public static String InstancePanelDialog_ShowDetails;
  public static String InstancePanelDialog_Show;
  public static String InstancePanelDialog_ShowAdditions;
  public static String InstancePanelDialog_ShowInView;
  public static String InstancePanelDialog_ShowUnfolded;
  public static String InstancePanelDialog_Status;
  public static String InstancePanelDialog_Synchronization;
  public static String InstancePanelDialog_SynchronizationOptions;
  public static String InstancePanelDialog_Unchanged;
  public static String InstancePanelDialog_Unfold;
  public static String InstancePanelDialog_UpdateInstance;

  public static String InstancePanelDialog_UpdatePattern;

  public static String ManageInstanceAction_NotInInstance;
  public static String MergeTargetChoiceDialog_Prompt;
  public static String MergeTargetChoiceDialog_PromptWithTarget;

  public static String ModelSubsetViewer_ShowParents;
  public static String ModelSubsetViewer_SortByName;
  public static String ModelSubsetViewer_SortByNameAndType;
  public static String ModelSubsetViewer_TooltipCollapse;
  public static String ModelSubsetViewer_TooltipExpand;
  public static String ModelSubsetViewer_TooltipSort;
  public static String MultiStorageChoiceDialog_Compatible;
  public static String MultiStorageChoiceDialog_Current;
  public static String MultiStorageChoiceDialog_Similar;
  public static String MultiStorageChoiceDialog_Target;
  public static String PatternApplicationAssociationPage_UniqueAssociationByMerge;
  public static String PatternApplicationAssociationPage_AddIn;
  public static String PatternApplicationAssociationPage_AddRole;
  public static String PatternApplicationAssociationPage_ComputedContainer;
  public static String PatternApplicationAssociationPage_DeriveAdd;
  public static String PatternApplicationAssociationPage_DeriveMerge;
  public static String PatternApplicationAssociationPage_Description;
  public static String PatternApplicationAssociationPage_GuessAdd;
  public static String PatternApplicationAssociationPage_GuessFailed;
  public static String PatternApplicationAssociationPage_GuessMerge;
  public static String PatternApplicationAssociationPage_GuessOK;
  public static String PatternApplicationAssociationPage_Header;
  public static String PatternApplicationAssociationPage_Initialization;
  public static String PatternApplicationAssociationPage_MergeWith;
  public static String PatternApplicationAssociationPage_MergeWithRole;
  public static String PatternApplicationAssociationPage_Message;
  public static String PatternApplicationAssociationPage_Multiplicity;
  public static String PatternApplicationAssociationPage_MultiplicityInteger;
  public static String PatternApplicationAssociationPage_MultiplicityPositive;
  public static String PatternApplicationAssociationPage_MultiplicityTooltip;
  public static String PatternApplicationAssociationPage_NamingRule;
  public static String PatternApplicationAssociationPage_NamingRuleTooltip;
  public static String PatternApplicationAssociationPage_NumberOfInstancesLabel;
  public static String PatternApplicationAssociationPage_NumberOfInstancesTooltip;
  public static String PatternApplicationAssociationPage_PromptForContainment;
  public static String PatternApplicationAssociationPage_Propose;
  public static String PatternApplicationAssociationPage_ResetAllRoles;
  public static String PatternApplicationAssociationPage_ResetRole;
  public static String PatternApplicationAssociationPage_ReuseLayout;
  public static String PatternApplicationAssociationPage_ReuseStyle;
  public static String PatternApplicationAssociationPage_RoleContents;
  public static String PatternApplicationAssociationPage_RuleResultMany;
  public static String PatternApplicationAssociationPage_RuleResultTarget;
  public static String PatternApplicationAssociationPage_RuleReturnsMany;
  public static String PatternApplicationAssociationPage_RuleReturnsNone;
  public static String PatternApplicationAssociationPage_SelectContainerManyRoles;
  public static String PatternApplicationAssociationPage_SelectContainerSingleRole;
  public static String PatternApplicationAssociationPage_Selected;
  public static String PatternApplicationAssociationPage_SelectMerge;
  public static String PatternApplicationAssociationPage_ShowInstance;
  public static String PatternApplicationAssociationPage_UnfoldInstance;
  public static String PatternApplicationPresentationPage_ConstraintCatalog;
  public static String PatternApplicationPresentationPage_ConstraintPattern;
  public static String PatternApplicationPresentationPage_Header;
  public static String PatternApplicationPresentationPage_Message;
  public static String PatternApplicationWizard_Header;
  public static String PatternBrowsingElementsPage_Message;
  public static String PatternBrowsingElementsPage_Name;
  public static String PatternBrowsingPresentationPage_Message;
  public static String PatternBrowsingPresentationPage_Name;
  public static String PatternBrowsingRolesPage_Message;
  public static String PatternBrowsingRolesPage_Name;
  public static String PatternBrowsingWizard_Header;
  public static String PatternBrowsingWizard_Message;
  public static String PatternBrowsingWizard_Title;

  public static String PatternCreationElementsPage_Name;
  public static String PatternCreationPresentationPage_ConstraintCatalog;
  public static String PatternCreationPresentationPage_ConstraintPatternName;
  public static String PatternCreationPresentationPage_ConstraintPatternVersion;
  public static String PatternCreationPresentationPage_Message;
  public static String PatternCreationPresentationPage_Name;
  public static String PatternCreationRolesPage_Message;
  public static String PatternCreationRolesPage_Name;
  public static String PatternCreationWizard_Header;
  public static String PatternCreationWizard_Message;
  public static String PatternCreationWizard_Title;
  public static String PatternUpdateElementsPage_ManyDiffs;
  public static String PatternUpdateElementsPage_Name;
  public static String PatternUpdateElementsPage_SingleDiff;
  public static String PatternUpdatePresentationPage_ConstraintCatalog;
  public static String PatternUpdatePresentationPage_ConstraintPatternName;
  public static String PatternUpdatePresentationPage_ConstraintPatternVersion;
  public static String PatternUpdatePresentationPage_Message;
  public static String PatternUpdatePresentationPage_Name;
  public static String PatternUpdateRolesPage_Message;
  public static String PatternUpdateRolesPage_Name;
  public static String PatternUpdateWizard_Header;
  public static String PatternUpdateWizard_Message;
  public static String PatternUpdateWizard_Title;


  public static String RoleChoiceDialog_Prompt;
  public static String RoleChoiceDialog_Role;
  public static String StorageChoiceDialog_Containment;
  public static String StorageChoiceDialog_Origin;
  public static String StorageChoiceDialog_PromptContainment;
  public static String StorageChoiceDialog_PromptMulti;

  public static String TemplateCreationElementsPage_Message;
  public static String TemplateCreationPresentationPage_Message;
  public static String TemplateCreationPresentationPage_ValidationName;
  public static String TemplateCreationPresentationPage_ValidationVersion;
  public static String TemplateCreationRolesPage_FirstRoleNoCollectionRule;
  public static String TemplateCreationRolesPage_FirstRoleSingleElement;
  public static String TemplateCreationRolesPage_MergeGroup;
  public static String TemplateCreationRolesPage_MergeLine;
  public static String TemplateCreationRolesPage_Message;
  public static String TemplateCreationRolesPage_SecondaryRoleCollectionRule;
  public static String TemplateCreationWizard_Header;
  public static String TemplateCreationWizard_Message;
  public static String TemplateCreationWizard_Title;
  public static String TemplateUsageDialog_DeleteRoles;
  public static String TemplateUsageDialog_ExcludeElements;
  public static String TemplateUsageDialog_IncludeChildren;
  public static String TemplateUsageDialog_KeepEmptyRoles;
  public static String TemplateUsageDialog_KeepRules;
  public static String TemplateUsageDialog_Message;
  public static String TemplateUsageDialog_OverrideMainRole;
  public static String TemplateUsageDialog_Title;
  public static String TemplateUsagePresentationPage_CompatibilityCheckboxLabel;
  public static String TemplateUsagePresentationPage_ConstraintTemplate;
  public static String TemplateUsageWizard_Header;
  public static String TemplateUsageWizard_Message;
  public static String TemplateUsageWizard_Title;
  public static String UIUtil_CatalogPrompt;
  public static String UIUtil_ContainerRole;
  public static String UIUtil_ContainerRoles;
  public static String UIUtil_FileExists;
  public static String UIUtil_MergedRole;
  public static String UIUtil_MergedRoles;
  public static String UIUtil_NewCatalogPrompt;
  public static String UIUtil_NotLoaded;
  public static String UIUtil_OpeningFailure;
  public static String UIUtil_OpeningRequiresMigration;
  public static String UIUtil_OperationError;
  public static String UIUtil_SuccessfulOperation;



}
