package br.com.edney.project.alfa.TemplateGraphQL.exception.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class UserNotFoundException extends RuntimeException implements GraphQLError {
	private Map<String, Object> extensions = new HashMap<>();
	
    public UserNotFoundException(String message) {
        super(message);
    }
    
    public UserNotFoundException(String message, String invalidUserId) {
        super(message);
        extensions.put("invalidUserId", invalidUserId);
    }
    
    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
