//package util;
//
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import static java.util.Objects.requireNonNull;
//
//public class SecurityUtil {
//    public static AuthorizedPerson safeGet() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth == null) {
//            return null;
//        }
//        Object principal = auth.getPrincipal();
//        return (principal instanceof AuthorizedPerson) ? (AuthorizedPerson) principal : null;
//    }
//
//    public static AuthorizedPerson get() {
//        AuthorizedPerson person = safeGet();
//        requireNonNull(person, "No authorized user found");
//        return person;
//    }
//
//    private SecurityUtil() {
//    }
//
//    public static int authUserId() {
//        return get().getId();
//    }
//
//}