package org.sola.opentenure.services.ejbs.claim.businesslogic;

import java.util.List;
import javax.ejb.Local;
import org.sola.opentenure.services.ejbs.claim.entities.AttachmentBinary;
import org.sola.opentenure.services.ejbs.claim.entities.AttachmentChunk;
import org.sola.opentenure.services.ejbs.claim.entities.Claim;
import org.sola.opentenure.services.ejbs.claim.entities.ClaimPermissions;
import org.sola.opentenure.services.ejbs.claim.entities.ClaimStatus;
import org.sola.opentenure.services.ejbs.claim.entities.FieldConstraintType;
import org.sola.opentenure.services.ejbs.claim.entities.FieldType;
import org.sola.opentenure.services.ejbs.claim.entities.FieldValueType;
import org.sola.opentenure.services.ejbs.claim.entities.FormTemplate;
import org.sola.opentenure.services.ejbs.claim.entities.LandUse;
import org.sola.opentenure.services.ejbs.claim.entities.RejectionReason;
import org.sola.services.common.ejbs.AbstractEJBLocal;

@Local
public interface ClaimEJBLocal extends AbstractEJBLocal {
    List<ClaimStatus> getClaimStatuses(String languageCode);
    ClaimStatus getClaimStatus(String code, String languageCode);
    Claim getClaim(String id);
    Claim getClaimByNumber(String nr);
    List<Claim> getChallengingClaimsByChallengedId(String challengingId);
    Claim saveClaim(Claim claim, String languageCode);
    AttachmentBinary saveAttachment(AttachmentBinary attachment);
    void deleteClaim(String claimId);
    AttachmentBinary saveAttachmentFromChunks(AttachmentBinary attachment);
    AttachmentChunk saveAttachmentChunk(AttachmentChunk chunk);
    AttachmentChunk getAttachmentLastChunk(String attachmentId);
    AttachmentBinary getAttachment(String attachmentId);
    List<AttachmentChunk> getAttachmentChunks(String attachmentId);
    boolean deleteAttachmentChunks(String attachmentId);
    boolean deleteClaimChunks(String claimId);
    int getMaxFileSize();
    int getUploadLimit();
    List<LandUse> getLandUses(String languageCode);
    List<RejectionReason> getRejectionReasons(String languageCode);
    boolean withdrawClaim(String claimId);
    boolean rejectClaim(String claimId, String rejectionReasonCode);
    boolean approveClaimReview(String claimId);
    boolean approveClaimModeration(String claimId);
    boolean assignClaim(String claimId);
    boolean unAssignClaim(String claimId);
    boolean canEditClaim(String claimId);
    boolean canWithdrawClaim(String claimId);
    boolean canRejectClaim(String claimId);
    boolean canApproveClaimReview(String claimId);
    boolean canApproveClaimModeration(String claimId);
    boolean canAssignClaim(String claimId);
    boolean canUnAssignClaim(String claimId);
    boolean canDeleteClaim(String claimId);
    boolean canAddDocumentsToClaim(String claimId);
    boolean canSubmitClaim(String claimId);
    boolean canChallengeClaim(String claimId);
    boolean submitClaim(String claimId, String languageCode);
    void addClaimAttachment(String claimId, String attachmentId);
    ClaimPermissions getClaimPermissions(String claimId);
    List<FormTemplate> getFormTemplates(String languageCode);
    FormTemplate getFormTemplate(String templateName, String languageCode);
    FormTemplate getDefaultFormTemplate(String languageCode);
    List<FieldType> getFieldTypes(String languageCode);
    List<FieldValueType> getFieldValueTypes(String languageCode);
    List<FieldConstraintType> getFieldConstraintTypes(String languageCode);
    boolean checkFormTemplateHasPayload(String formName);
    FormTemplate saveFormTemplate(FormTemplate form);
}